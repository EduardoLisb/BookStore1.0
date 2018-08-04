package beans;

public class Estante {

	public int serial_estante;
	public String desc_estante;

	public Estante(int serial_estante, String desc_estante) {

		this.serial_estante = serial_estante;
		this.desc_estante = desc_estante;

	}

	public int getSerial_estante() {
		return serial_estante;
	}

	public void setSerial_estante(int serial_estante) {
		this.serial_estante = serial_estante;
	}

	public String getDesc_estante() {
		return desc_estante;
	}

	public void setDesc_estante(String desc_estante) {
		this.desc_estante = desc_estante;
	}

}
