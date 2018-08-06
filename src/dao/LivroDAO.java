package dao;

import beans.Livro;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

	public static void create(Livro l) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"INSERT INTO livro (isbn, titulo, dt_ultima_edicao, num_edicao, tpLivro) VALUES (?,?,?,?,?)");
			stmt.setLong(1, l.getIsbn());
			stmt.setString(2, l.getTitulo());
			stmt.setDate(3, l.getDt_ultima_edicao());
			stmt.setInt(4, l.getNum_edicao());
			stmt.setString(5, l.getTpLivro());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro LIVRODAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(long isbn, Livro l) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"UPDATE livro SET  titulo = ?, dt_ultima_edicao = ?, num_edicao = ? WHERE isbn = ?");
			stmt.setString(1, l.getTitulo());
			stmt.setDate(2, l.getDt_ultima_edicao());
			stmt.setInt(3, l.getNum_edicao());
			stmt.setLong(4, isbn);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro LIVRODAO Update" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(int isbn) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM livro WHERE isbn = ?");
			stmt.setInt(1, isbn);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro ISBNDAO Delete" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
