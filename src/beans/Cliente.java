package beans;

import java.sql.Date;

public class Cliente extends Pessoa {

	private Boolean eh_professor;
	private boolean status;
	private Date dt_adesao;
	private Date dt_fim_adesao;
	private int cod_plano;
	private int pontos_fidelidade;
	private long cnpj_filial;

	public Cliente(Boolean eh_professor, boolean status, Date dt_adesao, Date dt_fim_adesao, int cod_plano,
			int pontos_fidelidade, long cnpj_filial, long cpf, Sexo sx, Date dt_nasc, String nome, int idade,
			long cep, int numero) {

		super(cpf, sx, dt_nasc, nome, idade, cep, numero);
		this.eh_professor = eh_professor;
		this.status = status;
		this.dt_adesao = dt_adesao;
		this.dt_fim_adesao = dt_fim_adesao;
		this.cod_plano = cod_plano;
		this.pontos_fidelidade = pontos_fidelidade;
		this.cnpj_filial = cnpj_filial;
	}
	public Cliente(long cpf) {
		super(cpf);
	}
	public Boolean getEh_professor() {
		return eh_professor;
	}

	public void setEh_professor(Boolean eh_professor) {
		this.eh_professor = eh_professor;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDt_adesao() {
		return dt_adesao;
	}

	public void setDt_adesao(Date dt_adesao) {
		this.dt_adesao = dt_adesao;
	}

	public Date getDt_fim_adesao() {
		return dt_fim_adesao;
	}

	public void setDt_fim_adesao(Date dt_fim_adesao) {
		this.dt_fim_adesao = dt_fim_adesao;
	}

	public boolean isStatus() {
		return status;
	}

	public int getCod_plano() {
		return cod_plano;
	}

	public void setCod_plano(int cod_plano) {
		this.cod_plano = cod_plano;
	}

	public int getPontos_fidelidade() {
		return this.pontos_fidelidade;
	}

	public void setPontos_fidelidade(int pontos_fidelidade) {
		this.pontos_fidelidade = pontos_fidelidade;
	}

	public long getCnpj_filial() {
		return cnpj_filial;
	}

	public void setCnpj_filial(long cnpj_filial) {
		this.cnpj_filial = cnpj_filial;
	}
}
