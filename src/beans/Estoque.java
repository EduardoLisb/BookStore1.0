package beans;

import java.sql.Date;

public class Estoque {
	
	public int id_Estoque;
	public Date dt_ultima_compra;
	public String desc;
	public BookStoreFilial cnpj_filial;
	
	public Estoque(int id_estoque, Date dt_ultima_compra, String desc, BookStoreFilial cnpj_filial) {
		this.id_Estoque = id_estoque;
		this.dt_ultima_compra = dt_ultima_compra;
		this.desc = desc;
		this.cnpj_filial = cnpj_filial;
		
	}

	public int getId_Estoque() {
		return id_Estoque;
	}

	public void setId_Estoque(int id_Estoque) {
		this.id_Estoque = id_Estoque;
	}

	public Date getDt_ultima_compra() {
		return dt_ultima_compra;
	}

	public void setDt_ultima_compra(Date dt_ultima_compra) {
		this.dt_ultima_compra = dt_ultima_compra;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public BookStoreFilial getCnpj_filial() {
		return cnpj_filial;
	}

	public void setCnpj_filial(BookStoreFilial cnpj_filial) {
		this.cnpj_filial = cnpj_filial;
	}

}
