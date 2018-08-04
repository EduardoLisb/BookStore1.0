package beans;

import java.sql.Date;

public class Encomenda {

	public int id_encomenda;
	public Date dt_pedido;
	public char status;
	public Date dt_prevista;
	public Cliente cpf_cliente;

	public Encomenda(int id_encomenda, Date dt_pedido, char status, Date dt_prevista, Cliente cpf_cliente) {
		this.id_encomenda = id_encomenda;
		this.dt_pedido = dt_pedido;
		this.status = status;
		this.dt_prevista = dt_prevista;
		this.cpf_cliente = cpf_cliente;
	}

	public int getId_encomenda() {
		return id_encomenda;
	}

	public void setId_encomenda(int id_encomenda) {
		this.id_encomenda = id_encomenda;
	}

	public Date getDt_pedido() {
		return dt_pedido;
	}

	public void setDt_pedido(Date dt_pedido) {
		this.dt_pedido = dt_pedido;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Date getDt_prevista() {
		return dt_prevista;
	}

	public void setDt_prevista(Date dt_prevista) {
		this.dt_prevista = dt_prevista;
	}

	public Cliente getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(Cliente cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
}
