package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Pagamento;
import connection.ConnectionFactory;

public class PagamentoDAO {
	public static void create(Pagamento pagamento) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("INSERT INTO pagamento (cod_pag, vl_pago) VALUES (?,?)");
			stmt.setInt(1, pagamento.getCod_pag());
			stmt.setDouble(2, pagamento.getVl_pago());

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
