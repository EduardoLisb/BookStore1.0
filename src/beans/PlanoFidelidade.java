package beans;

import java.sql.Date;

public class PlanoFidelidade {

	public int cod_plano;
	public char tipo;
	public Date dt_inicio;
	public Date dt_fim;

	public PlanoFidelidade(int cod_plano, char tipo, Date dt_inicio, Date dt_fim) {
		this.cod_plano = cod_plano;
		this.tipo = tipo;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
	}

	public int getCod_plano() {
		return this.cod_plano;
	}

	public void setCod_plano(int cod_plano) {
		this.cod_plano = cod_plano;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
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
