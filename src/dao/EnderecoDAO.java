package dao;

import beans.Endereco;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class EnderecoDAO {
    public static void create(Endereco e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{

            stmt = con.prepareStatement("INSERT INTO endereco (cep,complemento, predio, logradouro) VALUES (?,?,?,?)");
            stmt.setLong(1, e.getCep());

            if(e.getComplemento() == null) stmt.setNull(2, Types.VARCHAR);
            else stmt.setString(2, e.getComplemento());

            if(e.getPredio() == null) stmt.setNull(3, Types.VARCHAR);
            else stmt.setString(3, e.getPredio());

            stmt.setString(4, e.getLogradouro());

            stmt.executeUpdate();
            stmt.close();
            System.out.println("Chegou aqui");
        } catch (SQLException ex){
            System.out.println("Erro ENDERECODAO Create" + ex);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
}
