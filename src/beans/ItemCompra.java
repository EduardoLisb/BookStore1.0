package beans;

public class ItemCompra {

	public ProdutoRef cod_produto;
	public int qtd;
	public Compra cod_compra;
	public double vl_unitario;

	public ItemCompra(ProdutoRef cod_produto, int qtd, Compra cod_compra, double vl_unitario) {
		this.cod_produto = cod_produto;
		this.qtd = qtd;
		this.cod_compra = cod_compra;
		this.vl_unitario = vl_unitario;
	}

	public ProdutoRef getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(ProdutoRef cod_produto) {
		this.cod_produto = cod_produto;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Compra getCod_compra() {
		return cod_compra;
	}

	public void setCod_compra(Compra cod_compra) {
		this.cod_compra = cod_compra;
	}

	public double getVl_unitario() {
		return vl_unitario;
	}

	public void setVl_unitario(double vl_unitario) {
		this.vl_unitario = vl_unitario;
	}

}
