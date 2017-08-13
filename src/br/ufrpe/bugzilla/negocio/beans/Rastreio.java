package br.ufrpe.bugzilla.negocio.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Rastreio implements Serializable{
	
	private static final long serialVersionUID = 121441178803075696L;
	private String situacao;
	//faz mais sentido ter esse atributo localAtual
	//do que um do tipo endereço pra dps pegar só o nome da cidade
	private String localAtual;
	private LocalDateTime dataHora;
	
	public Rastreio() {
		
	}

	public Rastreio(String situacao, String local, LocalDateTime dataHora) {
		this.situacao = situacao;
		this.localAtual = local;
		this.dataHora = dataHora;
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

	public String getLocalAtual() {
		return localAtual;
	}

	public void setEnd(String local) {
		this.localAtual = local;
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
		
		resultado = data + " | "+ this.localAtual  + " | " + situacao;
		
		return resultado;
	}
}
