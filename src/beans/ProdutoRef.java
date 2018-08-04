package beans;

public class ProdutoRef {

	public int cod_produto;
	public double preco;
	public String desc_produto;
	public double preco_fornecedor;
	public int cod_barra;
	public Fornecedor cnpj_fornecedor;
	public String marca;

	public ProdutoRef(int cod_produto, double preco, String desc_produto, double preco_fornecedor, int cod_barra,
			Fornecedor cnpj_fornecedor, String marca) {
		this.cod_produto = cod_produto;
		this.preco = preco;
		this.desc_produto = desc_produto;
		this.preco_fornecedor = preco_fornecedor;
		this.cod_barra = cod_barra;
		this.cnpj_fornecedor = cnpj_fornecedor;
		this.marca = marca;
	}

	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDesc_produto() {
		return desc_produto;
	}

	public void setDesc_produto(String desc_produto) {
		this.desc_produto = desc_produto;
	}

	public double getPreco_fornecedor() {
		return preco_fornecedor;
	}

	public void setPreco_fornecedor(double preco_fornecedor) {
		this.preco_fornecedor = preco_fornecedor;
	}

	public int getCod_barra() {
		return cod_barra;
	}

	public void setCod_barra(int cod_barra) {
		this.cod_barra = cod_barra;
	}

	public Fornecedor getCnpj_fornecedor() {
		return cnpj_fornecedor;
	}

	public void setCnpj_fornecedor(Fornecedor cnpj_fornecedor) {
		this.cnpj_fornecedor = cnpj_fornecedor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
