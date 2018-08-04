package beans;

import java.sql.Date;

public class Editora extends Fornecedor {

	public Editora(long cnpj_fornecedor, String nome_fantasia_fornecedor, Date dt_inicio, Date dt_fim, char tipo) {
		super(cnpj_fornecedor, nome_fantasia_fornecedor, dt_inicio, dt_fim, tipo);
	}

}
