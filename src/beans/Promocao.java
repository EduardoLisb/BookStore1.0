package beans;

import java.sql.Date;

public class Promocao {

	public int id_promocao;
	public Date dt_inicio;
	public char tipo;
	public double porcentagem;
	public Date dt_fim;
	public PlanoFidelidade desc_plano;

	public Promocao(int id_promocao, Date dt_inicio, char tipo, double porcentagem, Date dt_fim,
			PlanoFidelidade desc_plano) {
		this.id_promocao = id_promocao;
		this.dt_inicio = dt_inicio;
		this.tipo = tipo;
		this.porcentagem = porcentagem;
		this.dt_fim = dt_fim;
		this.desc_plano = desc_plano;
	}

	public int getId_promocao() {
		return id_promocao;
	}

	public void setId_promocao(int id_promocao) {
		this.id_promocao = id_promocao;
	}

	public Date getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Date getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}

	public PlanoFidelidade getDesc_plano() {
		return desc_plano;
	}

	public void setDesc_plano(PlanoFidelidade desc_plano) {
		this.desc_plano = desc_plano;
	}

}
