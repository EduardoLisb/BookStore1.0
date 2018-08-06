package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Endereco;
import beans.Funcionario;
import beans.Gerente;
import beans.Sexo;
import connection.ConnectionFactory;

public class GerenteDAO {

	public static void create(Gerente g, Endereco e) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			Funcionario f = new Funcionario(g.getDt_ferias(),g.getSalario_base(),g.getCodigo_empregado(),g.getRamal(),g.getCnpj_filial(),null, g.getCpf(), Sexo.valueOf(g.getSx()),g.getDt_nasc(),g.getNome(),g.getIdade(),g.getCep(),g.getNumero());
			FuncionarioDAO.create(f,e);
			stmt = con.prepareStatement("INSERT INTO gerente (cpf, dt_inicio, dt_fim) VALUES (?,?,?)");
			stmt.setLong(1, g.getCpf());
			stmt.setDate(2, g.getDt_inicio());
			stmt.setDate(3, g.getDt_fim());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");

		} catch (SQLException ex) {
			System.out.println("Erro GERENTEDAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(long cpf, Gerente g) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"UPDATE funcionario SET salario_base = ?, ramal = ?  WHERE cpf.gerente = cpf.funcionario");
			stmt.setDouble(1, g.getSalario_base());
			stmt.setInt(2, g.getRamal());
			stmt.setLong(3, cpf);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro GERENTEDAO Update" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(long cpf) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM funcionario WHERE cpf.gerente = cpf.funcionario");
			stmt.setLong(1, cpf);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro GERENTEDAO Delete" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
