package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.ItemCompra;
import connection.ConnectionFactory;

public class ItemCompraDAO {
	public static void create(ItemCompra iC) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement(
					"INSERT INTO item_compra (cod_produto, qtd, cod_compra, vl_unitario) VALUES (?,?,?,?)");
			stmt.setInt(1, iC.getCod_produto().getCod_produto());
			stmt.setInt(2, iC.getQtd());
			stmt.setInt(3, iC.getCod_compra().getCod_compra());
			stmt.setDouble(4, iC.getVl_unitario());

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

	public static void update(int cod_produto, ItemCompra iC) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("UPDATE item_compra SET  qtd = ?, vl_unitario = ? WHERE cod_produto = ?");
			stmt.setInt(1, iC.getQtd());
			stmt.setDouble(2, iC.getVl_unitario());
			stmt.setInt(3, cod_produto);

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

	public static void delete(int cod_produto) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("DELETE FROM item_compra WHERE cod_produto = ?");
			stmt.setInt(1, cod_produto);

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
