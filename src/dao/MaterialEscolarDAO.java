package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.MaterialEscolar;
import beans.ProdutoRef;
import connection.ConnectionFactory;

public class MaterialEscolarDAO {
	public static void create(MaterialEscolar mE) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			
			//ADICIONANDO PRODUTOREF
			ProdutoRef prodRef = new ProdutoRef(mE.getCod_produto(), mE.getPreco(), mE.getDesc_produto(),
					mE.getPreco_fornecedor(), mE.getCod_barra(), mE.getCnpj_fornecedor(), mE.getMarca());

			//CRIANDO PRODUTOREF
			//ProdutoRefDAO.create(prodRef);
			
			stmt = con.prepareStatement(
					"INSERT INTO material_escolar (desc_material, cod_produto, preco, desc_produto, preco_fornecedor, cod_barra, cnpj_fornecedor, marca) VALUES (?,?,?,?,?,?,?,?)");
			stmt.setString(1, mE.getDesc_material());
			stmt.setLong(2, mE.getCod_produto());
			stmt.setDouble(3, mE.getPreco());
			stmt.setString(4, mE.getDesc_produto());
			stmt.setDouble(5, mE.getPreco_fornecedor());
			stmt.setInt(6, mE.getCod_barra());
			stmt.setLong(7, mE.getCnpj_fornecedor().getCnpj_fornecedor());
			stmt.setString(8, mE.getMarca());
			

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");

		} catch (SQLException ex) {
			System.out.println("Erro MATERIALESCOLARDAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(long cod_produto, MaterialEscolar mE) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
					"UPDATE material_escolar SET preco = ?, desc_produto = ?, preco_fornecedor = ?  WHERE cod_produto = ? ");
			stmt.setDouble(1, mE.getPreco());
			stmt.setString(2, mE.getDesc_produto());
			stmt.setDouble(3, mE.getPreco_fornecedor());
			stmt.setLong(4, cod_produto);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro MATERIALESCOLARDAO Update" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(long cod_produto) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM material_escolar WHERE cod_produto = ?");
			stmt.setLong(1, cod_produto);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro MATERIALESCOLARDAO Delete" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
