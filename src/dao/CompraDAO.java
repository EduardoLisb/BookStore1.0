package dao;

import beans.Compra;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class CompraDAO {

    public static void create(Compra c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO compra (cod_compra, vl_desconto, vl_imposto, dt_compra, vl_comissao, vl_total_bruto" +
                    "vl_total_a_pagar, cod_pdv, cod_compra, cpf_vendedor, cpf_cliente) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1,c.getCod_compra());
            if(c.getVl_desconto() == 0) stmt.setNull(2, Types.DOUBLE); else stmt.setDouble(2, c.getVl_desconto());
            if(c.getVl_imposto() == 0) stmt.setNull(3, Types.DOUBLE); else stmt.setDouble(3, c.getVl_imposto());
            stmt.setDate(4, c.getDt_compra());
            if(c.getVl_comissao() == 0) stmt.setNull(5, Types.DOUBLE); else stmt.setDouble(5, c.getVl_comissao());
            stmt.setDouble(6, c.getVl_total_bruto());
            stmt.setDouble(7, c.getVl_total_a_pagar());
            stmt.setInt(8, c.getCod_pdv().getCod_pdv());
            stmt.setInt(9, c.getCod_compra());
            stmt.setLong(10, c.getCpf_vendedor().getCpf());
            stmt.setLong(11, c.getCpf_cliente().getCpf());

            stmt.executeUpdate();
            stmt.close();
            System.out.println("Chegou aqui");
        } catch (SQLException ex) {
            System.out.println("Erro COMPRADAO Create" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
