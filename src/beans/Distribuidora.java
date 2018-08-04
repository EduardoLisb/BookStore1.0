package beans;

import java.sql.Date;

public class Distribuidora extends Fornecedor {

	public Distribuidora(long cnpj_fornecedor, String nome_fantasia_fornecedor, Date dt_inicio, Date dt_fim,
			char tipo) {
		super(cnpj_fornecedor, nome_fantasia_fornecedor, dt_inicio, dt_fim, tipo);
	}
}
