package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

import beans.Cliente;
import beans.Compra;
import beans.NotaFiscal;
import beans.PDV;
import beans.Vendedor;
import connection.ConnectionFactory;

public class CompraDAOSP {
	public static Compra create(Cliente c, Vendedor v, PDV pdv) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		CallableStatement cstm = null;
		Compra compra = null;
		PreparedStatement stm = null;
		try {
			con.setAutoCommit(false);
			cstm = con.prepareCall("CALL `SP_iniciar_compra` (?,?,?,?);");
			cstm.setInt(1, pdv.getCod_pdv());
			cstm.setLong(2, v.getCpf());
			cstm.setLong(3, c.getCpf());
			cstm.registerOutParameter(4, Types.INTEGER);
			cstm.execute();
			con.commit();
			int cod = cstm.getInt(4);
			cstm.close();
			
			stm = con.prepareStatement("SELECT * FROM compra WHERE cod_compra = ?;");
			stm.setInt(1, cod);
			ResultSet rs = stm.getResultSet();
			compra = new Compra(cod, 0.0, 0.0, stm.getResultSet().getDate("dt_compra"), 0.0, 0.0, 0.0, pdv, v, c);
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback..." + ex);
			}
		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}
		return compra;
	}
	public static NotaFiscal finalizar(Compra c) {
		Connection con = ConnectionFactory.getConnection();
		CallableStatement cstm = null;
		Compra compra = null;
		PreparedStatement stm = null;
		try {
			con.setAutoCommit(false);
			cstm = con.prepareCall("CALL `SP_finalizar_compra`(?);");
			cstm.setInt(1, c.getCod_compra());
			cstm.execute();
			con.commit();
			
			stm = con.prepareStatement("SELECT * FROM compra WHERE cod_compra = ?;");
			stm.setInt(1, cod);
			ResultSet rs = stm.getResultSet();
			compra = new Compra(cod, 0.0, 0.0, stm.getResultSet().getDate("dt_compra"), 0.0, 0.0, 0.0, pdv, v, c);
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback..." + ex);
			}
		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}		
	}
	
}
