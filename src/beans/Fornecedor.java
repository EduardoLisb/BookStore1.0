package beans;

import java.sql.Date;

public class Fornecedor {

	public long cnpj_fornecedor;
	public String nome_fantasia_fornecedor;
	public Date dt_inicio;
	public Date dt_fim;
	public char tipo;

	public Fornecedor(long cnpj_forncedor, String nome_fantasia_fornecedor, Date dt_inicio, Date dt_fim, char tipo) {
		this.cnpj_fornecedor = cnpj_forncedor;
		this.nome_fantasia_fornecedor = nome_fantasia_fornecedor;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.tipo = tipo;
	}

	public long getCnpj_fornecedor() {
		return cnpj_fornecedor;
	}

	public void setCnpj_fornecedor(long cnpj_fornecedor) {
		this.cnpj_fornecedor = cnpj_fornecedor;
	}

	public String getNome_fantasia_fornecedor() {
		return nome_fantasia_fornecedor;
	}

	public void setNome_fantasia_fornecedor(String nome_fantasia_fornecedor) {
		this.nome_fantasia_fornecedor = nome_fantasia_fornecedor;
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

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

}
