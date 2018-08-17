package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import beans.BookStoreFilial;
import beans.Endereco;
import beans.Matriz;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
//	private static final String USER = "root";
//	private static final String PASS = "";
	private static String user = "";
	private static String pass = "";
	public static void setLogin(String user, String pass) {
		ConnectionFactory.user = user;
		ConnectionFactory.pass = pass;
	}
	
	public static Connection getConnection() {

		try {

			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, user, pass);

		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("Erro na conexão", ex);
		}
	}

	public static void closeConnection(Connection con) {

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException ex) {
			System.err.println("Erro:" + ex);
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {
			System.err.println("Erro:" + ex);
		}
	}
	// retorna alguma filial ai
	public static BookStoreFilial getFilial() {
		return new BookStoreFilial(3333333333L, "", "", new Endereco(0, "", "", ""), 0, new Matriz(0, ""));
	}
}