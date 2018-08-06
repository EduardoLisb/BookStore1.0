package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Compra;
import beans.NotaFiscal;
import connection.ConnectionFactory;

public class NotaFiscalDAO {
	
	public static void create(NotaFiscal nF) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			
			//ADICIONANDO PRODUTOREF
//			Compra compra = new Compra(nF.getCod_compra(), nF.getVl_desconto(), nF.getVl_imposto(), nF.getDt_compra(),
//					nF.getVl_comissao(), nF.getVl_total_bruto(), nF.getVl_total_a_pagar(), nF.getCod_pdv(),
//					nF.getCpf_vendedor(), nF.getCpf_cliente());
//			CompraDAO.create(compra);

			
			stmt = con.prepareStatement(
					"INSERT INTO nota_fiscal (codigo_nf, dt_emissao, serie, vl_total, //cod_compra) VALUES (?,?,?,?,?)");
			stmt.setInt(1, nF.getCodigoNF());
			stmt.setDate(2, nF.getDt_emissao());
			stmt.setInt(3, nF.getSerie());
			stmt.setDouble(4, nF.getVl_total());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");

		} catch (SQLException ex) {
			System.out.println("Erro MULTIMIDIADAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
