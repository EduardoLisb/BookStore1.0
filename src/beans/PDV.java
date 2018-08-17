package beans;

import java.sql.Date;

public class PDV {

	public int cod_pdv;
	public Date dt_ult_manuntencao;
	public String desc_pdv;

	public PDV(int cod_pdv, Date dt_ult_manuntencao, String desc_pdv) {
		this.cod_pdv = cod_pdv;
		this.dt_ult_manuntencao = dt_ult_manuntencao;
		this.desc_pdv = desc_pdv;
	}
	public PDV(int cod) {
		this.cod_pdv = cod;
	}
	public int getCod_pdv() {
		return cod_pdv;
	}

	public void setCod_pdv(int cod_pdv) {
		this.cod_pdv = cod_pdv;
	}

	public Date getDt_ult_manuntencao() {
		return dt_ult_manuntencao;
	}

	public void setDt_ult_manuntencao(Date dt_ult_manuntencao) {
		this.dt_ult_manuntencao = dt_ult_manuntencao;
	}

	public String getDesc_pdv() {
		return desc_pdv;
	}

	public void setDesc_pdv(String desc_pdv) {
		this.desc_pdv = desc_pdv;
	}

}
