package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Auxiliar;
import beans.Funcionario;
import beans.MaterialEscolar;
import beans.Sexo;
import connection.ConnectionFactory;

public class MaterialEscolarDAO {
	public static void create(MaterialEscolar mE) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			Funcionario f = new Funcionario(mE.getDt_ferias(), mE.getSalario_base(), mE.getCodigo_empregado(),
					mE.getRamal(), mE.getCnpj_filial(), mE.getCpf_gerente(), mE.getCpf(), Sexo.valueOf(mE.getSx()),
					mE.getDt_nasc(), mE.getNome(), mE.getIdade(), mE.getCep(), mE.getNumero());
			FuncionarioDAO.create(f, e);
			stmt = con.prepareStatement("INSERT INTO auxiliar (cpf) VALUES (?)");
			stmt.setLong(1, mE.getCpf());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");

		} catch (SQLException ex) {
			System.out.println("Erro AUXILIARDAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(long cpf, Auxiliar a) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"UPDATE auxiliar SET salario_base = ?, ramal = ?  WHERE cpf.auxiliar = cpf.funcionario");
			stmt.setDouble(1, a.getSalario_base());
			stmt.setInt(2, a.getRamal());
			stmt.setLong(3, cpf);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro AUXILIARDAO Update" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(long cpf) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM funcionario WHERE cpf.auxiliar = cpf.funcionario");
			stmt.setLong(1, cpf);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro AUXILIARDAO Delete" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
