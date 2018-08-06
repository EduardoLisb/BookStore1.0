package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Pagamento;
import connection.ConnectionFactory;

public class PagamentoDAO {
	public static void create(Pagamento pagamento) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO pagamento (cod_pag, vl_pago) VALUES (?,?)");
			stmt.setInt(1, pagamento.getCod_pag());
			stmt.setDouble(2, pagamento.getVl_pago());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro PAGAMENTODAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
