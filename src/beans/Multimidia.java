package beans;

public class Multimidia extends ProdutoRef {

	public String titulo;
	public int duracao;
	public TipoMultimidia tp;

	public Multimidia(String titulo, int duracao, TipoMultimidia tp, int cod_produto, double preco, String desc_produto,
			double preco_fornecedor, int cod_barra, Fornecedor cnpj_fornecedor, String marca) {
		super(cod_produto, preco, desc_produto, preco_fornecedor, cod_barra, cnpj_fornecedor, marca);
		this.titulo = titulo;
		this.duracao = duracao;
		this.tp = tp;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public TipoMultimidia getTp() {
		return tp;
	}

	public void setTp(TipoMultimidia tp) {
		this.tp = tp;
	}

}
