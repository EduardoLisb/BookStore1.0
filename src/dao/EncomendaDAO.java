package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.Encomenda;
import connection.ConnectionFactory;

public class EncomendaDAO {
	public static void create(Encomenda e) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			con.setAutoCommit(false);
			stm = con.prepareStatement("INSERT INTO encomenda "
					+ "(id_encomenda, dt_pedido, status_encomenda, dt_prevista,cpf_cliente) " + "VALUES(?,?,?,?,?)");
			stm.setInt(1, e.getId_encomenda());
			stm.setDate(2, e.getDt_pedido());
			stm.setString(3, e.getStatus() + "");
			stm.setDate(4, e.getDt_prevista());
			stm.setLong(5, e.getCpf_cliente().getCpf());
			stm.executeUpdate();
			con.commit();
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback..." + ex);
			}
		} finally {
			ConnectionFactory.closeConnection(con, stm);
//			stm.close();
//			con.close();
		}
	}

	public static void remove(int id_encomenda) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			con.setAutoCommit(false);
			stm = con.prepareStatement("DELETE FROM encomenda " + "WHERE id_encomenda = ?");
			stm.setInt(3, id_encomenda);
			stm.executeUpdate();
			con.commit();
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback..." + ex);
			}
		} finally {
			ConnectionFactory.closeConnection(con, stm);
//			stm.close();
//			con.close();
		}
	}

	public static void update(Encomenda e) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			con.setAutoCommit(false);
			stm = con.prepareStatement(
					"UPDATE encomenda " + "SET status_encomenda = ?, dt_prevista = ? " + "WHERE id_encomenda = ?");
			stm.setString(1, e.getStatus() + "");
			stm.setDate(2, e.getDt_prevista());
			stm.setInt(3, e.getId_encomenda());
			stm.executeUpdate();
			con.commit();
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback..." + ex);
			}
		} finally {
			ConnectionFactory.closeConnection(con, stm);
//			stm.close();
//			con.close();
		}
	}
}
