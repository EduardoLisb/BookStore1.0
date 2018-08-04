package beans;

public class TipoEvento {

	public int cod_tipo;
	public String desc_tipo;
	public String categoria;

	public TipoEvento(int cod_tipo, String desc_tipo, String categoria) {
		this.cod_tipo = cod_tipo;
		this.desc_tipo = desc_tipo;
		this.categoria = categoria;
	}

	public int getCod_tipo() {
		return cod_tipo;
	}

	public void setCod_tipo(int cod_tipo) {
		this.cod_tipo = cod_tipo;
	}

	public String getDesc_tipo() {
		return desc_tipo;
	}

	public void setDesc_evento(String desc_tipo) {
		this.desc_tipo = desc_tipo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
