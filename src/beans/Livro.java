package beans;

import java.sql.Date;

public class Livro extends ProdutoRef {

	public long isbn;
	public String titulo;
	public Date dt_ultima_edicao;
	public int num_edicao;
	public TipoLivro tpLivro;

	public Livro(long isbn, String titulo, Date dt_ultima_edicao, int num_edicao, TipoLivro tpLivro, int cod_produto,
			double preco, String desc_produto, double preco_fornecedor, int cod_barra, Fornecedor cnpj_fornecedor,
			String marca) {
		super(cod_produto, preco, desc_produto, preco_fornecedor, cod_barra, cnpj_fornecedor, marca);
		this.isbn = isbn;
		this.titulo = titulo;
		this.dt_ultima_edicao = dt_ultima_edicao;
		this.num_edicao = num_edicao;
		this.tpLivro = tpLivro;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDt_ultima_edicao() {
		return dt_ultima_edicao;
	}

	public void setDt_ultima_edicao(Date dt_ultima_edicao) {
		this.dt_ultima_edicao = dt_ultima_edicao;
	}

	public int getNum_edicao() {
		return num_edicao;
	}

	public void setNum_edicao(int num_edicao) {
		this.num_edicao = num_edicao;
	}

	public String getTpLivro() {
		return tpLivro.toString();
	}

	public void setTpLivro(TipoLivro tpLivro) {
		this.tpLivro = tpLivro;
	}

}
