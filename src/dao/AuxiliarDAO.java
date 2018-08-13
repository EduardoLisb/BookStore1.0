package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Auxiliar;
import beans.Endereco;
import beans.Funcionario;
import beans.Sexo;
import connection.ConnectionFactory;

public class AuxiliarDAO {
	public static void create(Auxiliar a, Endereco e) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			con.setAutoCommit(false);

			Funcionario f = new Funcionario(a.getDt_ferias(), a.getSalario_base(), a.getCodigo_empregado(),
					a.getRamal(), a.getCnpj_filial(), a.getCpf_gerente(), a.getCpf(), Sexo.valueOf(a.getSx()),
					a.getDt_nasc(), a.getNome(), a.getIdade(), a.getCep(), a.getNumero());
			FuncionarioDAO.create(f, e);
			stmt = con.prepareStatement("INSERT INTO auxiliar (cpf) VALUES (?)");
			stmt.setLong(1, a.getCpf());

			stmt.executeUpdate();
			con.commit();
			stmt.close();

		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback..." + ex);
			}
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(long cpf, Auxiliar a) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);

			stmt = con.prepareStatement(
					"UPDATE auxiliar SET salario_base = ?, ramal = ?  WHERE cpf.auxiliar = cpf.funcionario");
			stmt.setDouble(1, a.getSalario_base());
			stmt.setInt(2, a.getRamal());
			stmt.setLong(3, cpf);

			stmt.executeUpdate();
			con.commit();
			stmt.close();


		} catch (SQLException ex) {
			if (con != null) {
				con.rollback();
				System.out.println("Connection rollback..." + ex);
			}
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(long cpf) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);

			stmt = con.prepareStatement("DELETE FROM funcionario WHERE cpf.auxiliar = cpf.funcionario");
			stmt.setLong(1, cpf);

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
