package beans;

import java.sql.Date;

public class Comissao {

	public int id_comissao;
	public double percentual;
	public Date dt_inicio;
	public Date dt_fim;
	public char status;
	public char tipo;

	public Comissao(int id_comissao, double percentual, Date dt_inicio, Date dt_fim, char status, char tipo) {
		this.id_comissao = id_comissao;
		this.percentual = percentual;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.status = status;
		this.tipo = tipo;
	}

	public int getId_comissao() {
		return id_comissao;
	}

	public void setId_comissao(int id_comissao) {
		this.id_comissao = id_comissao;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
}
