package beans;

import java.sql.Date;

public class ItemEstoque {

	public ProdutoRef cod_prod;
	public int seq_SK;
	public Boolean em_prateleira;
	public double preco_venda;
	public int qtd_minima;
	public Date dt_entrada;
	public int qtd_atual;
	public Estoque id_estoque;
	public Prateleira serial_prateleira;

	public ItemEstoque(ProdutoRef cod_prod, int seq_SK, Boolean em_prateleira, double preco_venda, int qtd_minima,
			Date dt_entrada, int qtd_atual, Estoque id_estoque, Prateleira serial_prateleira) {
		this.cod_prod = cod_prod;
		this.seq_SK = seq_SK;
		this.em_prateleira = em_prateleira;
		this.preco_venda = preco_venda;
		this.qtd_minima = qtd_minima;
		this.dt_entrada = dt_entrada;
		this.qtd_atual = qtd_atual;
		this.id_estoque = id_estoque;
		this.serial_prateleira = serial_prateleira;
	}

	public ProdutoRef getCod_prod() {
		return cod_prod;
	}

	public void setCod_prod(ProdutoRef cod_prod) {
		this.cod_prod = cod_prod;
	}

	public int getSeq_SK() {
		return seq_SK;
	}

	public void setSeq_SK(int seq_SK) {
		this.seq_SK = seq_SK;
	}

	public Boolean getEm_prateleira() {
		return em_prateleira;
	}

	public void setEm_prateleira(Boolean em_prateleira) {
		this.em_prateleira = em_prateleira;
	}

	public double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public int getQtd_minima() {
		return qtd_minima;
	}

	public void setQtd_minima(int qtd_minima) {
		this.qtd_minima = qtd_minima;
	}

	public Date getDt_entrada() {
		return dt_entrada;
	}

	public void setDt_entrada(Date dt_entrada) {
		this.dt_entrada = dt_entrada;
	}

	public int getQtd_atual() {
		return qtd_atual;
	}

	public void setQtd_atual(int qtd_atual) {
		this.qtd_atual = qtd_atual;
	}

	public Estoque getId_estoque() {
		return id_estoque;
	}

	public void setId_estoque(Estoque id_estoque) {
		this.id_estoque = id_estoque;
	}

	public Prateleira getSerial_prateleira() {
		return serial_prateleira;
	}

	public void setSerial_prateleira(Prateleira serial_prateleira) {
		this.serial_prateleira = serial_prateleira;
	}

}
