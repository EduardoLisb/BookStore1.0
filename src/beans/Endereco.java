package beans;

public class Endereco {

	public long cep;
	public String complemento;
	public String predio;
	public String logradouro;

	public Endereco(long cep, String complemento, String predio, String logradouro) {
		this.cep = cep;
		this.complemento = complemento;
		this.predio = predio;
		this.logradouro = logradouro;

	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
