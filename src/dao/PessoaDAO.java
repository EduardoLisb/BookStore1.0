package dao;

import beans.Endereco;
import beans.Pessoa;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class PessoaDAO {
	public static void create(Pessoa p, Endereco e) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			EnderecoDAO.create(e);

			stmt = con.prepareStatement(
					"INSERT INTO pessoa (cpf, nome, sexo, dt_nascimento, idade, endereco_cep, endereco_num) VALUES (?,?,?,?,?,?,?)");
			stmt.setLong(1, p.getCpf());
			stmt.setString(2, p.getNome());
			stmt.setString(3, p.getSx());
			stmt.setDate(4, p.getDt_nasc());
			stmt.setInt(5, p.getIdade());

			if (p.getCep() == 0)
				stmt.setNull(6, Types.BIGINT);
			else
				stmt.setLong(6, p.getCep());

			if (p.getNumero() == 0)
				stmt.setNull(7, Types.INTEGER);
			else
				stmt.setInt(7, p.getNumero());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro PESSOADAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
