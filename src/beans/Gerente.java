package beans;

import java.sql.Date;

public class Gerente extends Funcionario {

	public Date dt_inicio;
	public Date dt_fim;

	public Gerente(Date dt_inicio, Date dt_fim, Date dt_ferias, double salario_base, int codigo_empregado, int ramal,
			BookStoreFilial cnpj_filial, Gerente cpf_gerente, long cpf, Sexo sx, Date dt_nasc, String nome, int idade,
			long cep, int numero) {
		super(dt_ferias, salario_base, codigo_empregado, ramal, cnpj_filial, cpf_gerente, cpf, sx, dt_nasc, nome, idade,
				cep, numero);
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;

	}

	public Date getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public Date getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}

}
