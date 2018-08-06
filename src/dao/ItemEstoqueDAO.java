package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.ItemEstoque;
import connection.ConnectionFactory;

public class ItemEstoqueDAO {
	public static void create(ItemEstoque iE) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			stmt = con.prepareStatement(
					"INSERT INTO material_escolar (cod_prod, seq_sk, em_prateleira, preco_venda, qtd_minima, dt_entrada, qtd_atual, id_estoque, serial_prateleira) VALUES (?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, iE.getCod_prod().getCod_produto());
			stmt.setInt(2, iE.getSeq_SK());
			stmt.setBoolean(3, iE.getEm_prateleira());
			stmt.setDouble(4, iE.getPreco_venda());
			stmt.setInt(5, iE.getQtd_minima());
			stmt.setDate(6, iE.getDt_entrada());
			stmt.setInt(7, iE.getQtd_atual());
			stmt.setInt(8, iE.getId_estoque().getId_Estoque());
			stmt.setInt(9, iE.getSerial_prateleira().getSerial_prateleira());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");

		} catch (SQLException ex) {
			System.out.println("Erro ITEMESTOQUEDAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(long cod_produto, ItemEstoque iE) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"UPDATE item_estoque SET em_prateleira = ?, preco_venda = ?, qtd_minima = ?, qtd_atual = ?,  WHERE cod_produto = ? ");
			stmt.setBoolean(1, iE.getEm_prateleira());
			stmt.setDouble(2, iE.getPreco_venda());
			stmt.setInt(3, iE.getQtd_minima());
			stmt.setLong(4, iE.getQtd_atual());
			stmt.setLong(5, cod_produto);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro ITEMESTOQUEDAO Update" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(long cod_produto) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM item_estoque WHERE cod_produto = ?");
			stmt.setLong(1, cod_produto);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro ITEMESTOQUEDAO Delete" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
