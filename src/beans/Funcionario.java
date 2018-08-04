package beans;

import java.sql.Date;

public class Funcionario extends Pessoa {

	public Date dt_ferias;
	public double salario_base;
	public int codigo_empregado;
	public int ramal;
	public BookStoreFilial cnpj_filial;
	public Gerente cpf_gerente;

	public Funcionario(Date dt_ferias, double salario_base, int codigo_empregado, int ramal,
			BookStoreFilial cnpj_filial, Gerente cpf_gerente, long cpf, Sexo sx, Date dt_nasc, String nome, int idade,
			long cep, int numero) {

		super(cpf, sx, dt_nasc, nome, idade, cep, numero);
		this.dt_ferias = dt_ferias;
		this.salario_base = salario_base;
		this.codigo_empregado = codigo_empregado;
		this.ramal = ramal;
		this.cnpj_filial = cnpj_filial;
		this.cpf_gerente = cpf_gerente;
	}

	public Date getDt_ferias() {
		return dt_ferias;
	}

	public void setDt_ferias(Date dt_ferias) {
		this.dt_ferias = dt_ferias;
	}

	public double getSalario_base() {
		return salario_base;
	}

	public void setSalario_base(double salario_base) {
		this.salario_base = salario_base;
	}

	public int getCodigo_empregado() {
		return codigo_empregado;
	}

	public void setCodigo_empregado(int codigo_empregado) {
		this.codigo_empregado = codigo_empregado;
	}

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}

	public BookStoreFilial getCnpj_filial() {
		return cnpj_filial;
	}

	public void setCnpj_filial(BookStoreFilial cnpj_filial) {
		this.cnpj_filial = cnpj_filial;
	}

	public Gerente getCpf_gerente() {
		return cpf_gerente;
	}

	public void setCpf_gerente(Gerente cpf_gerente) {
		this.cpf_gerente = cpf_gerente;
	}
}
