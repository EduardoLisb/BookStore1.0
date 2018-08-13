package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Multimidia;
import beans.ProdutoRef;
import connection.ConnectionFactory;

public class MultimidiaDAO {
	public static void create(Multimidia m) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			// ADICIONANDO PRODUTOREF
			ProdutoRef prodRef = new ProdutoRef(m.getCod_produto(), m.getPreco(), m.getDesc_produto(),
					m.getPreco_fornecedor(), m.getCod_barra(), m.getCnpj_fornecedor(), m.getMarca());

			// CRIANDO PRODUTOREF
			// ProdutoRefDAO.create(prodRef);

			stmt = con.prepareStatement("INSERT INTO multimidia (titulo, duracao, //tipo multimidia//) VALUES (?,?,?)");
			stmt.setString(1, m.getTitulo());
			stmt.setInt(2, m.getDuracao());
			stmt.setString(3, m.getTp());

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
