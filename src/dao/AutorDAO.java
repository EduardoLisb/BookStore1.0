package dao;

import beans.Autor;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutorDAO {

	public static void create(Autor a) throws SQLException {
		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		try {
			//TRANSACTION
			con.setAutoCommit(false);

			stmt = con.prepareStatement("INSERT INTO autor (id_autor, nome, best_seller) VALUES (?,?,?)");
			stmt.setInt(1, a.getId_autor());
			stmt.setString(2, a.getNome());
			stmt.setString(3, a.getBest_seller());

			stmt.executeUpdate();
			con.commit();
			stmt.close();
			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback...");
			}
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(int id, Autor b) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("UPDATE autor SET  nome = ?, best_seller = ? WHERE id_autor = ?");
			stmt.setString(1, b.getNome());
			stmt.setString(2, b.getBest_seller());
			stmt.setInt(3, id);

			stmt.executeUpdate();
			con.commit();
			stmt.close();

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback...");
			}
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(int id) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("DELETE FROM autor WHERE id_autor = ?");
			stmt.setInt(1, id);

			stmt.executeUpdate();
			con.commit();
			stmt.close();

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback...");
			}
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
