package dao;

import beans.BookStoreFilial;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class BookstoreDAO {
	public static void create(BookStoreFilial bF) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			if (bF.getCep() != null)
				EnderecoDAO.create(bF.cep);
			stmt = con.prepareStatement(
					"INSERT INTO bookstore_filial (cnpj_filial, nome_fantasia, razao_social, endereco_cep, endereco_num, cnpj_matriz) VALUES (?,?,?,?,?,?)");
			stmt.setLong(1, bF.getCnpj_filial());
			stmt.setString(2, bF.getNome_fantasia_filial());
			stmt.setString(3, "Livraria");
			if (bF.getCep() == null)
				stmt.setNull(4, Types.BIGINT);
			else
				stmt.setLong(4, bF.getCep().getCep());
			if (bF.getNum() == 0)
				stmt.setNull(5, Types.INTEGER);
			else
				stmt.setInt(5, bF.getNum());
			stmt.setLong(6, bF.getCnpj_matriz().getCnpj_matriz());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro BOOKSTOREDAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(BookStoreFilial bF) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"UPDATE bookstore_filial SET  nome_fantasia = ?, endereco_cep = ?, endereco_num = ?, cnpj_matriz = ? WHERE cnpj_filial = ?");
			stmt.setString(1, bF.getNome_fantasia_filial());
			if (bF.getCep() == null)
				stmt.setNull(2, Types.BIGINT);
			else
				stmt.setLong(3, bF.getCep().getCep());
			if (bF.getNum() == 0)
				stmt.setNull(3, Types.INTEGER);
			else
				stmt.setInt(4, bF.getNum());
			stmt.setLong(4, bF.getCnpj_matriz().getCnpj_matriz());
			stmt.setLong(5, bF.getCnpj_filial());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro BOOKSTOREDAO Update" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
