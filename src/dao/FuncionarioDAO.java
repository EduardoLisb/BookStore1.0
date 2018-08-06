package dao;

import beans.Endereco;
import beans.Funcionario;
import beans.Pessoa;
import beans.Sexo;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class FuncionarioDAO {
	public static void create(Funcionario f, Endereco e) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			// ADICIONANDO PESSOA
			Pessoa pessoa = new Pessoa(f.getCpf(), Sexo.valueOf(f.getSx()), f.getDt_nasc(), f.getNome(), f.getIdade(),
					f.getCep(), f.getNumero());
			PessoaDAO.create(pessoa, e);

			// ADICIONANDO FUNCIONARIO
			stmt = con.prepareStatement(
					"INSERT INTO funcionario (cpf, dt_ferias, salario_base, ramal, cpf_gerente) VALUES (?,?,?,?,?)");
			stmt.setLong(1, f.getCpf());
			stmt.setDate(2, f.getDt_ferias());
			stmt.setDouble(3, f.salario_base);
			stmt.setInt(4, f.getRamal());
			if (f.getCpf_gerente() == null)
				stmt.setNull(5, Types.BIGINT);
			else
				stmt.setLong(5, f.getCpf_gerente().getCpf());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro FUNCIONARIODAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
