package br.ufrpe.bugzilla.negocio.beans;

import java.time.LocalDateTime;


public class Rastreio {
	private String situacao;
	private Endereco local;
	private LocalDateTime dataHora;

	public Rastreio(String situacao, Endereco local, LocalDateTime dataHora) {
		this.situacao = situacao;
		this.local = local;
		this.dataHora = dataHora;
	}

	public Rastreio() {
		this(null, null, null);
	}

	public String DateToString(LocalDateTime data) {
		String resultado;
		int dia = data.getDayOfMonth();
		int mes = data.getMonthValue();
		int ano = data.getYear();
		int hora = data.getHour();
		int minuto = data.getMinute();

		resultado = Integer.toString(dia) + "/" + mes + "/" + ano + " - " + hora + ":" + minuto;

		return resultado;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Endereco getLocal() {
		return local;
	}

	public void setLocal(Endereco local) {
		this.local = local;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		String resultado = null;
		String data = this.DateToString(this.dataHora);
		
		resultado = data + " | "+ local.getRua() + ", " + local.getCidade() + " | " + situacao;
		
		return resultado;
	}
}
