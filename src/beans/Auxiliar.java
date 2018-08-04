package beans;

import java.sql.Date;

public class Auxiliar extends Funcionario {

	public Auxiliar(Date dt_ferias, double salario_base, int codigo_empregado, int ramal, BookStoreFilial cnpj_filial,
			Gerente cpf_gerente, long cpf, Sexo sx, Date dt_nasc, String nome, int idade, long cep, int numero) {
		
		super(dt_ferias, salario_base, codigo_empregado, ramal, cnpj_filial, cpf_gerente, cpf, sx, dt_nasc, nome, idade,
				cep, numero);

	}

}
