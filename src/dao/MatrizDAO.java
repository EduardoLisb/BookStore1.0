package dao;

import beans.Matriz;
import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MatrizDAO {

    public static void create(Matriz matriz){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("INSERT INTO matriz (cnpj_matriz, nome_fantasia) VALUES (?,?)");
            stmt.setLong(1,matriz.getCnpj_matriz());
            stmt.setString(2,matriz.getNome_fantasia());

            stmt.executeUpdate();
            stmt.close();
            System.out.println("Chegou aqui");
        } catch (SQLException ex){
            System.out.println("Erro MATRIZDAO Create" + ex);
        }finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
}
