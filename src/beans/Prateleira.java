package beans;

public class Prateleira {

	public int serial_prateleira;
	public int num_nivel;
	public Estante serial_estante;

	public Prateleira(int serial_prateleira, int num_nivel, Estante serial_estantes) {
		this.serial_prateleira = serial_prateleira;
		this.num_nivel = num_nivel;
		this.serial_estante = serial_estantes;
	}

	public int getSerial_prateleira() {
		return serial_prateleira;
	}

	public void setSerial_prateleira(int serial_prateleira) {
		this.serial_prateleira = serial_prateleira;
	}

	public int getNum_nivel() {
		return num_nivel;
	}

	public void setNum_nivel(int num_nivel) {
		this.num_nivel = num_nivel;
	}

	public Estante getSerial_estante() {
		return serial_estante;
	}

	public void setSerial_estante(Estante serial_estante) {
		this.serial_estante = serial_estante;
	}

}
