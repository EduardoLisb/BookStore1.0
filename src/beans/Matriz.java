package beans;

public class Matriz {

	public long cnpj_matriz;
	public String nome_fantasia;

	public Matriz(long cnpj_matriz, String nome_fantasia) {
		this.cnpj_matriz = cnpj_matriz;
		this.nome_fantasia = nome_fantasia;

	}

	public long getCnpj_matriz() {
		return cnpj_matriz;
	}

	public void setCnpj_matriz(long cnpj_matriz) {
		this.cnpj_matriz = cnpj_matriz;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

}
