package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Endereco;
import beans.Funcionario;
import beans.Sexo;
import beans.Vendedor;
import connection.ConnectionFactory;

public class VendedorDAO {
	public static void create(Vendedor v, Endereco e) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			con.setAutoCommit(false);
			Funcionario f = new Funcionario(v.getDt_ferias(), v.getSalario_base(), v.getCodigo_empregado(),
					v.getRamal(), v.getCnpj_filial(), v.getCpf_gerente(), v.getCpf(), Sexo.valueOf(v.getSx()),
					v.getDt_nasc(), v.getNome(), v.getIdade(), v.getCep(), v.getNumero());
			FuncionarioDAO.create(f, e);
			stmt = con.prepareStatement("INSERT INTO vendedor (cpf) VALUES (?)");
			stmt.setLong(1, v.getCpf());

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

	public static void update(long cpf, Vendedor v) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement(
					"UPDATE vendedor SET salario_base = ?, ramal = ?  WHERE cpf.vendedor = ?");
			stmt.setDouble(1, v.getSalario_base());
			stmt.setInt(2, v.getRamal());
			stmt.setLong(3, cpf);

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

	public static void delete(long cpf) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			stmt = con.prepareStatement("DELETE FROM funcionario WHERE cpf.vendedor = ?");
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
