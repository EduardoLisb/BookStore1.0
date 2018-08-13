package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.Fornecedor;
import connection.ConnectionFactory;

public class FornecedorDAO {
	public static void create(Fornecedor f) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			con.setAutoCommit(false);
			stm = con.prepareStatement("INSERT INTO fornecedor "
					+ "(cnpj_fornecedor,nome_fantasia,dt_inicio,dt_fim,tipo)" + "VALUES(?,?,?,?,?)");
			stm.setLong(1, f.getCnpj_fornecedor());
			stm.setString(2, f.getNome_fantasia_fornecedor());
			stm.setDate(3, f.getDt_inicio());
			stm.setDate(4, f.getDt_fim());
			stm.setString(5, f.getTipo() + "");
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

	public static void update(Fornecedor f) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			con.setAutoCommit(false);
			stm = con.prepareStatement(
					"UPDATE fornecedor " + "SET nome_fantasia = ?, tipo = ? " + "WHERE cnpj_fornecedor = ?");
			stm.setString(1, f.getNome_fantasia_fornecedor());
			stm.setString(2, f.getTipo() + "");
			stm.setLong(3, f.getCnpj_fornecedor());
			stm.executeUpdate();
			con.commit();
		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback..." + ex);
			}
		} finally {
			ConnectionFactory.closeConnection(con, stm);
		}
	}

	public static void delete(long cnpj) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stm = null;
		try {
			con.setAutoCommit(false);
			stm = con.prepareStatement("DELETE FROM fornecedor " + "WHERE cnpj_fornecedor = ?");
			stm.setLong(1, cnpj);
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
