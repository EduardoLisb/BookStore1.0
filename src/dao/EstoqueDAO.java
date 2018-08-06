package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Estoque;
import connection.ConnectionFactory;

public class EstoqueDAO {
	public static void create(Estoque e) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("INSERT INTO estoque "
					+ "(id_estoque, dt_ultima_compra, desc_estoque, cnpj_filial)"
					+ "VALUES(?,?,?,?)");
			stm.setInt(1, e.getId_Estoque());
			stm.setDate(2, e.getDt_ultima_compra());
			stm.setString(3, e.getDesc());
			stm.setLong(4, e.getCnpj_filial().getCnpj_filial());
			stm.executeUpdate();
		} catch(SQLException exc) {
			throw exc;
		} finally {
			ConnectionFactory.closeConnection(con, stm);
//			stm.close();
//			con.close();
		}
	}
	public static void update (Estoque e) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("UPDATE estoque "
					+ "SET dt_ultima_compra = ?, desc_estoque = ? "
					+ "WHERE id_estoque = ?");
			stm.setDate(1, e.getDt_ultima_compra());
			stm.setString(2, e.getDesc());
			stm.setInt(3, e.getId_Estoque());
			stm.executeUpdate();
		} catch(SQLException exc) {
			throw exc;
		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}
	}
	public static void delete(int id_estoque) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("DELETE FROM estoque "
					+ "WHERE id_estoque = ?");
			stm.setInt(1, id_estoque);
			stm.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionFactory.closeConnection(con, stm);
//			stm.close();
//			con.close();
		}
	}
}
