package beans;

import java.sql.Date;

public class Palestrante extends Pessoa {

	public Date dt_ultima_palestra;
	public char status;
	public String area;
	public Date dt_inicio;

	public Palestrante(Date dt_ultima_palestra, char status, String area, Date dt_inicio, long cpf, Sexo sx,
			Date dt_nasc, String nome, int idade, long cep, int num) {
		super(cpf, sx, dt_nasc, nome, idade, cep, num);
		this.dt_ultima_palestra = dt_ultima_palestra;
		this.status = status;
		this.area = area;
		this.dt_inicio = dt_inicio;
	}

	public Date getDt_ultima_palestra() {
		return dt_ultima_palestra;
	}

	public void setDt_ultima_palestra(Date dt_ultima_palestra) {
		this.dt_ultima_palestra = dt_ultima_palestra;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

}
