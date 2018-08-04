import beans.Autor;
import beans.Cliente;
import beans.Sexo;
import com.mysql.jdbc.Util;
import dao.AutorDAO;
import dao.ClienteDAO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainTest {
    public static void main(String[] args){
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());


        Cliente c = new Cliente(false, true, date, date, 12345, 0, 87672718000293l, 70519237888l, Sexo.masculino, Date.valueOf("1999-01-11"), "Saulo Ferreira", 19, 1252457, 779);
        ClienteDAO.create(c);
    }
}


