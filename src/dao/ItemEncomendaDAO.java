package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.ItemEncomenda;
import connection.ConnectionFactory;

public class ItemEncomendaDAO {
	
	public static void create(ItemEncomenda iE) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			
//			public Encomenda id_encomenda;
//			public ProdutoRef cod_produto;
//			public int qntd;


			stmt = con.prepareStatement("INSERT INTO item_estoque (id_encomenda, cod_produto, qntd ) VALUES (?,?,?)");
			stmt.setInt(1, iE.getId_encomenda().getId_encomenda());
			stmt.setInt(2, iE.getCod_produto().getCod_produto());
			stmt.setInt(3, iE.getQntd());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");

		} catch (SQLException ex) {
			System.out.println("Erro ITEMENCOMENDADAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
