package dao;

import beans.*;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class ClienteDAO {
	public static void create(Cliente c, Endereco e) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			Pessoa p = new Pessoa(c.getCpf(), Sexo.valueOf(c.getSx()), c.getDt_nasc(), c.getNome(), c.getIdade(),
					c.getCep(), c.getNumero());

			PessoaDAO.create(p, e);

			stmt = con.prepareStatement(
					"INSERT INTO cliente (cpf, eh_professor, status, dt_fim_adesao, dt_adesao, cod_plano, pontosFidelidade, cnpj_filial) VALUES (?,?,?,?,?,?,?,?)");
			stmt.setLong(1, c.getCpf());
			stmt.setBoolean(2, c.getEh_professor());
			stmt.setBoolean(3, c.getStatus());
			stmt.setDate(4, c.getDt_fim_adesao());
			stmt.setDate(5, c.getDt_adesao());

			if (c.getCod_plano() == 0)
				stmt.setNull(6, Types.INTEGER);
			else
				stmt.setInt(6, c.getCod_plano());

			if (c.getPontos_fidelidade() == -1)
				stmt.setNull(7, Types.INTEGER);
			else
				stmt.setInt(7, c.getPontos_fidelidade());

			stmt.setLong(8, c.getCnpj_filial());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro CLIENTEDAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
