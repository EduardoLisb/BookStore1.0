package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.NotaFiscal;
import connection.ConnectionFactory;

public class NotaFiscalDAO {

	public static void create(NotaFiscal nF) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement(
					"INSERT INTO nota_fiscal (codigo_nf, dt_emissao, serie, vl_total, //cod_compra) VALUES (?,?,?,?,?)");
			stmt.setInt(1, nF.getCodigoNF());
			stmt.setDate(2, nF.getDt_emissao());
			stmt.setInt(3, nF.getSerie());
			stmt.setDouble(4, nF.getVl_total());

			stmt.executeUpdate();
			con.commit();
			stmt.close();
			System.out.println("Chegou aqui");

		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback..." + ex);
			}
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
