package beans;

import java.sql.Date;

public class Compra {

	public int cod_compra;
	public double vl_desconto;
	public double vl_imposto;
	public Date dt_compra;
	public double vl_comissao;
	public double vl_total_bruto;
	public double vl_total_a_pagar;
	public PDV cod_pdv;
	public Vendedor cpf_vendedor;
	public Cliente cpf_cliente;

	public Compra(int cod_compra, double vl_desconto, double vl_imposto, Date dt_compra, double vl_comissao,
			double vl_total_bruto, double vl_total_a_pagar, PDV cod_pdv, Vendedor cpf_vendedor, Cliente cpf_cliente) {
		this.cod_compra = cod_compra;
		this.vl_desconto = vl_desconto;
		this.vl_imposto = vl_imposto;
		this.dt_compra = dt_compra;
		this.vl_comissao = vl_comissao;
		this.vl_total_bruto = vl_total_bruto;
		this.vl_total_a_pagar = vl_total_a_pagar;
		this.cod_pdv = cod_pdv;
		this.cpf_vendedor = cpf_vendedor;
		this.cpf_cliente = cpf_cliente;
	}

	public int getCod_compra() {
		return cod_compra;
	}

	public void setCod_compra(int cod_compra) {
		this.cod_compra = cod_compra;
	}

	public double getVl_desconto() {
		return vl_desconto;
	}

	public void setVl_desconto(double vl_desconto) {
		this.vl_desconto = vl_desconto;
	}

	public double getVl_imposto() {
		return vl_imposto;
	}

	public void setVl_imposto(double vl_imposto) {
		this.vl_imposto = vl_imposto;
	}

	public Date getDt_compra() {
		return dt_compra;
	}

	public void setDt_compra(Date dt_compra) {
		this.dt_compra = dt_compra;
	}

	public double getVl_comissao() {
		return vl_comissao;
	}

	public void setVl_comissao(double vl_comissao) {
		this.vl_comissao = vl_comissao;
	}

	public double getVl_total_bruto() {
		return vl_total_bruto;
	}

	public void setVl_total_bruto(double vl_total_bruto) {
		this.vl_total_bruto = vl_total_bruto;
	}

	public double getVl_total_a_pagar() {
		return vl_total_a_pagar;
	}

	public void setVl_total_a_pagar(double vl_total_a_pagar) {
		this.vl_total_a_pagar = vl_total_a_pagar;
	}

	public PDV getCod_pdv() {
		return cod_pdv;
	}

	public void setCod_pdv(PDV cod_pdv) {
		this.cod_pdv = cod_pdv;
	}

	public Vendedor getCpf_vendedor() {
		return cpf_vendedor;
	}

	public void setCpf_vendedor(Vendedor cpf_vendedor) {
		this.cpf_vendedor = cpf_vendedor;
	}

	public Cliente getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(Cliente cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

}
