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
	public static void create(Vendedor v, Endereco e) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			Funcionario f = new Funcionario(v.getDt_ferias(),v.getSalario_base(),v.getCodigo_empregado(),v.getRamal(),v.getCnpj_filial(),v.getCpf_gerente(), v.getCpf(), Sexo.valueOf(v.getSx()),v.getDt_nasc(),v.getNome(),v.getIdade(),v.getCep(),v.getNumero());
			FuncionarioDAO.create(f,e);
			stmt = con.prepareStatement("INSERT INTO vendedor (cpf) VALUES (?)");
			stmt.setLong(1, v.getCpf());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");

		} catch (SQLException ex) {
			System.out.println("Erro VENDEDORDAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(long cpf, Vendedor v) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"UPDATE vendedor SET salario_base = ?, ramal = ?  WHERE cpf.vendedor = cpf.funcionario");
			stmt.setDouble(1, v.getSalario_base());
			stmt.setInt(2, v.getRamal());
			stmt.setLong(3, cpf);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro VENDEDORDAO Update" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(long cpf) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM funcionario WHERE cpf.vendedor = ?");
			stmt.setLong(1, cpf);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro VENDEDORDAO Delete" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
