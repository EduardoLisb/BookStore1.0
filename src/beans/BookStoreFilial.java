package beans;

public class BookStoreFilial {

	public long cnpj_filial;
	public String nome_fantasia_filial;
	public String razao_social;
	public Endereco cep;
	public Matriz cnpj_matriz;
	private int num;

	public BookStoreFilial(long cnpj_filial, String nome_fantasia_filial, String razao_social, Endereco cep, int num,
			Matriz cnpj_matriz) {
		this.cnpj_filial = cnpj_filial;
		this.nome_fantasia_filial = nome_fantasia_filial;
		this.razao_social = razao_social;
		this.cep = cep;
		this.cnpj_matriz = cnpj_matriz;
	}

	public long getCnpj_filial() {
		return cnpj_filial;
	}

	public void setCnpj_filial(long cnpj_filial) {
		this.cnpj_filial = cnpj_filial;
	}

	public String getNome_fantasia_filial() {
		return nome_fantasia_filial;
	}

	public void setNome_fantasia_filial(String nome_fantasia_filial) {
		this.nome_fantasia_filial = nome_fantasia_filial;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public Endereco getCep() {
		return cep;
	}

	public void setCep(Endereco cep) {
		this.cep = cep;
	}

	public Matriz getCnpj_matriz() {
		return cnpj_matriz;
	}

	public void setCnpj_matriz(Matriz cnpj_matriz) {
		this.cnpj_matriz = cnpj_matriz;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
