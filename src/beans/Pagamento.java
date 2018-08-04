package beans;

public class Pagamento {

	public int cod_pag;
	public double vl_pago;

	public Pagamento(int cod_pag, double vl_pago) {
		this.cod_pag = cod_pag;
		this.vl_pago = vl_pago;
	}

	public int getCod_pag() {
		return cod_pag;
	}

	public void setCod_pag(int cod_pag) {
		this.cod_pag = cod_pag;
	}

	public double getVl_pago() {
		return vl_pago;
	}

	public void setVl_pago(double vl_pago) {
		this.vl_pago = vl_pago;
	}
}
