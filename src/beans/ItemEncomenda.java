package beans;

public class ItemEncomenda {

	public Encomenda id_encomenda;
	public ProdutoRef cod_produto;
	public int qntd;

	public ItemEncomenda(Encomenda id_encomenda, ProdutoRef cod_produto, int qntd) {
		this.id_encomenda = id_encomenda;
		this.cod_produto = cod_produto;
		this.qntd = qntd;
	}

	public Encomenda getId_encomenda() {
		return id_encomenda;
	}

	public void setId_encomenda(Encomenda id_encomenda) {
		this.id_encomenda = id_encomenda;
	}

	public ProdutoRef getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(ProdutoRef cod_produto) {
		this.cod_produto = cod_produto;
	}

	public int getQntd() {
		return qntd;
	}

	public void setQntd(int qntd) {
		this.qntd = qntd;
	}

}
