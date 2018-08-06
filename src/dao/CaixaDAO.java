package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.*;
import connection.ConnectionFactory;

public class CaixaDAO {
	public static void create(Caixa cx, PDV pdv, Endereco e) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			Funcionario f = new Funcionario(cx.getDt_ferias(), cx.getSalario_base(), cx.getCodigo_empregado(),
					cx.getRamal(), cx.getCnpj_filial(), null, cx.getCpf(), Sexo.valueOf(cx.getSx()), cx.getDt_nasc(),
					cx.getNome(), cx.getIdade(), cx.getCep(), cx.getNumero());
			FuncionarioDAO.create(f, e);
			stmt = con.prepareStatement("INSERT INTO gerente (cpf, cod_pdv, dt_inicio, dt_fim ) VALUES (?,?,?,?)");
			stmt.setLong(1, cx.getCpf());
			stmt.setInt(2, pdv.getCod_pdv());
			stmt.setDate(3, cx.getDt_inicio());
			stmt.setDate(4, cx.getDt_fim());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");

		} catch (SQLException ex) {
			System.out.println("Erro CAIXADAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(long cpf, Caixa cx, PDV pdv) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"UPDATE funcionario SET salario_base = ?, ramal = ?, cod_pdv = ?  WHERE cpf.caixa = cpf.funcionario");
			stmt.setDouble(1, cx.getSalario_base());
			stmt.setInt(2, cx.getRamal());
			stmt.setInt(3, pdv.getCod_pdv());
			stmt.setLong(4, cpf);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro CAIXADAO Update" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(long cpf) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM funcionario WHERE cpf.caixa = cpf.funcionario");
			stmt.setLong(1, cpf);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro CAIXADAO Delete" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
