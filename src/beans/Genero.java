package beans;

public class Genero {

	public int cod_genero;
	public String desc_genero;

	public Genero(int cod_genero, String desc_genero) {
		this.cod_genero = cod_genero;
		this.desc_genero = desc_genero;
	}

	public int getCod_genero() {
		return cod_genero;
	}

	public void setCod_genero(int cod_genero) {
		this.cod_genero = cod_genero;
	}

	public String getDesc_genero() {
		return desc_genero;
	}

	public void setDesc_genero(String desc_genero) {
		this.desc_genero = desc_genero;
	}

}
