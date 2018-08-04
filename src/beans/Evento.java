package beans;

import java.sql.Date;

public class Evento {

	public int cod_evento;
	public String desc_evento;
	public Boolean requer_inscricao;
	public Date dt_inicio_divulg;
	public Palestrante cpf_palestrante;
	public Date dt_realizacao;
	public BookStoreFilial cnpj_filial;
	public TipoEvento cod_tipo;

	public Evento(int cod_evento, String desc_evento, Boolean requer_inscricao, Date dt_inicio_divulg,
			Palestrante cpf_palestrante, Date dt_realizacao, BookStoreFilial cnpj_filial, TipoEvento cod_tipo) {

		this.cod_evento = cod_evento;
		this.desc_evento = desc_evento;
		this.requer_inscricao = requer_inscricao;
		this.dt_inicio_divulg = dt_inicio_divulg;
		this.cpf_palestrante = cpf_palestrante;
		this.dt_realizacao = dt_realizacao;
		this.cnpj_filial = cnpj_filial;
		this.cod_tipo = cod_tipo;
	}

	public int getCod_evento() {
		return cod_evento;
	}

	public void setCod_evento(int cod_evento) {
		this.cod_evento = cod_evento;
	}

	public String getDesc_evento() {
		return desc_evento;
	}

	public void setDesc_evento(String desc_evento) {
		this.desc_evento = desc_evento;
	}

	public Boolean getRequer_inscricao() {
		return requer_inscricao;
	}

	public void setRequer_inscricao(Boolean requer_inscricao) {
		this.requer_inscricao = requer_inscricao;
	}

	public Date getDt_inicio_divulg() {
		return dt_inicio_divulg;
	}

	public void setDt_inicio_divulg(Date dt_inicio_divulg) {
		this.dt_inicio_divulg = dt_inicio_divulg;
	}

	public Palestrante getCpf_palestrante() {
		return cpf_palestrante;
	}

	public void setCpf_palestrante(Palestrante cpf_palestrante) {
		this.cpf_palestrante = cpf_palestrante;
	}

	public Date getDt_realizacao() {
		return dt_realizacao;
	}

	public void setDt_realizacao(Date dt_realizacao) {
		this.dt_realizacao = dt_realizacao;
	}

	public BookStoreFilial getCnpj_filial() {
		return cnpj_filial;
	}

	public void setCnpj_filial(BookStoreFilial cnpj_filial) {
		this.cnpj_filial = cnpj_filial;
	}

	public TipoEvento getCod_tipo() {
		return cod_tipo;
	}

	public void setCod_tipo(TipoEvento cod_tipo) {
		this.cod_tipo = cod_tipo;
	}
}
