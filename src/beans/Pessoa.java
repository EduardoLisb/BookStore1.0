package beans;

import java.sql.Date;

public class Pessoa {

	private long cpf;
	public Sexo sx;
	public Date dt_nasc;
	public String nome;
	public int idade;
	public long cep;
	private int numero;

	public Pessoa(long cpf, Sexo sx, Date dt_nasc, String nome, int idade, long cep, int numero) {
		this.cpf = cpf;
		this.sx = sx;
		this.dt_nasc = dt_nasc;
		this.nome = nome;
		this.idade = idade;
		this.cep = cep;
		this.numero = numero;
	}
	public Pessoa(long cpf) {
		this.cpf = cpf;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getSx() {
		return sx.toString();
	}

	public void setSx(Sexo sx) {
		this.sx = sx;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}
}
