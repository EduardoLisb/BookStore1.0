package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.ItemCompra;
import beans.Compra;
import beans.ProdutoRef;
import connection.ConnectionFactory;

public class ItemCompraDAO {
	public static void create(ItemCompra iC) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			// ADICIONANDO PRODUTOREF
			ProdutoRef prodRef = new ProdutoRef(iC.getCod_produto(), iC.getPreco(), iC.getDesc_produto(),
					iC.getPreco_fornecedor(), iC.getCod_barra(), iC.getCnpj_fornecedor(), iC.getMarca());
			ProdutoRefDAO.create(prodRef);

			// ADICIONANDO COMPRA
			Compra compra = new Compra(iC.getCod_compra(), iC.getVl_desconto(), iC.getVl_imposto(), iC.getDt_compra(),
					iC.getVl_comissao(), iC.getVl_total_bruto(), iC.getVl_total_a_pagar(), iC.getCod_pdv(),
					iC.getCpf_vendedor(), iC.getCpf_cliente());
			CompraDAO.create(compra);

			stmt = con.prepareStatement(
					"INSERT INTO item_compra (cod_produto, qtd, cod_compra, vl_unitario) VALUES (?,?,?,?)");
			stmt.setInt(1, iC.getCod_produto());
			stmt.setInt(2, iC.getQtd());
			stmt.setString(3, iC.getCod_compra());
			stmt.setDouble(4, iC.getVl_unitario());

			stmt.executeUpdate();
			stmt.close();
			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro ITEMCOMPRADAO Create" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void update(int cod_produto, ItemCompra iC) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("UPDATE item_compra SET  qtd = ?, vl_unitario = ? WHERE cod_produto = ?");
			stmt.setInt(1, iC.getQtd());
			stmt.setDouble(2, iC.getVl_unitario());
			stmt.setInt(3, cod_produto);

			stmt.executeUpdate();
			stmt.close();
			;

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro ITEMCOMPRADAO Update" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public static void delete(int cod_produto) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM item_compra WHERE cod_produto = ?");
			stmt.setInt(1, cod_produto);

			stmt.executeUpdate();
			stmt.close();

			System.out.println("Chegou aqui");
		} catch (SQLException ex) {
			System.out.println("Erro ITEMCOMPRADAO Delete" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
