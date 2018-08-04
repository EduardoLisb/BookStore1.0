package beans;

public class Cartao extends Pagamento {

	public int numero;
	public int qt_parcelas;
	public String bandeira;
	public String banco;

	public Cartao(int numero, int qt_parcelas, String bandeira, String banco, int cod_pag, double vl_pago) {

		super(cod_pag, vl_pago);
		this.numero = numero;
		this.qt_parcelas = qt_parcelas;
		this.bandeira = bandeira;
		this.banco = banco;

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getQt_parcelas() {
		return qt_parcelas;
	}

	public void setQt_parcelas(int qt_parcelas) {
		this.qt_parcelas = qt_parcelas;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}
