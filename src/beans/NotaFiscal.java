package beans;

import java.sql.Date;

public class NotaFiscal {

	public int codigoNF;
	public Date dt_emissao;
	public int serie;
	public double vl_total;
	public Compra cod_compra;

	public NotaFiscal(int codigoNF, Date dt_emissao, int serie, double vl_total, Compra cod_compra) {

		this.codigoNF = codigoNF;
		this.dt_emissao = dt_emissao;
		this.serie = serie;
		this.vl_total = vl_total;
		this.cod_compra = cod_compra;
	}

	public int getCodigoNF() {
		return codigoNF;
	}

	public void setCodigoNF(int codigoNF) {
		this.codigoNF = codigoNF;
	}

	public Date getDt_emissao() {
		return dt_emissao;
	}

	public void setDt_emissao(Date dt_emissao) {
		this.dt_emissao = dt_emissao;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public double getVl_total() {
		return vl_total;
	}

	public void setVl_total(double vl_total) {
		this.vl_total = vl_total;
	}

	public Compra getCod_compra() {
		return cod_compra;
	}

	public void setCod_compra(Compra cod_compra) {
		this.cod_compra = cod_compra;
	}

}
