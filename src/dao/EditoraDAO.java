package dao;


import java.sql.SQLException;

import beans.Editora;

public class EditoraDAO {
	public static void create(Editora e) throws SQLException {
		FornecedorDAO.create(e);
	}
}
