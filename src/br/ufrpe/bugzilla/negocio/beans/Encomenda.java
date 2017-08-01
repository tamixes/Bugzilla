package br.ufrpe.bugzilla.negocio.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Encomenda {
	private static long geraCodigo = 1000;

	/*private long pedido;*/
	private String codigo;
	private Pessoa destinatario;
	private double peso;
	private String tipoDoProduto;
	private boolean entregue = false;
	private ArrayList<Rastreio> rastreio = new ArrayList<Rastreio>();
	
	//a tarifa é definida pelo método preço, usando a tarifa base e a localização do destino 
	private double tarifa;
	//tarifa por km
	private static double tarifaBase;
	//prazo em dias é definido ao cadastrar encomenda
	private int prazoEntrega;
	/*O local de destino é uma cidade e tem como atributos o nome 
	 e a localização (distância em km da base da transportadora)*/
	private Local localDestino;

	public Encomenda(Pessoa destinatario, double peso, String tipo, Local destino, int prazo/*, int pedido*/) {
		this.codigo = "BUG" + geraCodigo + "BR";
		geraCodigo++;

		this.localDestino = destino;
		this.peso = peso;
		this.destinatario = destinatario;
		this.tipoDoProduto = tipo;
		this.tarifa = this.preço();
		this.prazoEntrega = prazo;
		//this.pedido = pedido;
	}

	public Encomenda() {
		this(null, 0, null/*, 0*/, null, 0);
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public static double getTarifaBase() {
		return tarifaBase;
	}

	public static void setTarifaBase(double tarifaBase) {
		Encomenda.tarifaBase = tarifaBase;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public void setRastreio(ArrayList<Rastreio> rastreio) {
		this.rastreio = rastreio;
	}

	public Local getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(Local localDestino) {
		this.localDestino = localDestino;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getTipoDoProduto() {
		return tipoDoProduto;
	}

	public void setTipoDoProduto(String tipoDoProduto) {
		this.tipoDoProduto = tipoDoProduto;
	}

	public boolean isEntregue() {
		return entregue;
	}

	/*public long getPedido() {
		return pedido;
	}

	// Por causa do construtor vazio que inicia o numero de pedido em 0, eu fiz
	// o setPedido desse jeito;
	public void setPedido(int pedido) {
		if (this.codigo == 0) {
			this.pedido = pedido;
		} else
			System.out.println("Esta entrega jÃ¡ possui um cÃ³digo de pedido definido!");

	}*/

	public String getCodigo() {
		return codigo;
	}

	public Pessoa getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Pessoa destinatario) {
		this.destinatario = destinatario;
	}

	public ArrayList<Rastreio> getRastreio() {
		return rastreio;
	}

	/*public void setCodigo(String codigo) {
		this.codigo = codigo;
	}*/


	public String Status() {
		String resultado;
		if (this.entregue == false) {
			resultado = "ENCOMENDA A CAMINHO";
		} else {
			resultado = "ENCOMENDA ENTREGUE";
		}

		return resultado;
	}

	public void atualizaRelatorio(String situacao, Endereco local, LocalDateTime dataHora) {
		Rastreio rastreio = new Rastreio(situacao, local, dataHora);

		this.rastreio.add(rastreio);
	}

	public void atualizaRelatorio(Rastreio rastreio) {
		this.rastreio.add(rastreio);
	}

	public String getRelatorio() {
		String result = "";

		for (int i = 0; i < this.rastreio.size(); i++) {
			result = result + rastreio.get(i) + "\n";
		}
		return result;
	}

	public String getRelatorioPorData(LocalDateTime data) {
		String result = "NÃ£o houve nada nessa data";
		for (int i = 0; i < this.rastreio.size(); i++) {
			if (data.equals(this.rastreio.get(i).getDataHora()) == true) {
				result = this.rastreio.get(i).toString();
			}
		}
		return result;
	}

	public String toString() {
		String resultado = new String("EUAHEUAH");
		
		resultado =
				  "Dados da encomenda:\n" 
				+ "\t Nome do destinatÃ¡rio: " 	+ this.destinatario.getNome() + "\n"
				+ "\t Destino do produto: " 	+ this.destinatario.getEnd() + "\n"
				+ "\t Status da entrega: " 		+ this.Status() + "\n"
				+ "\t Tipo de produto: " 		+ this.tipoDoProduto + "\n"
				+ "\t Peso do produto: " 		+ this.peso + "kg\n"
				+ "\t Codigo de entrega: " 		+ this.codigo + "\n"
				/*+ "\t Codigo de pedido: " 		+ this.pedido + "\n"*/;
		
		return resultado;
	}

	//TODO corrigir equals para receber Object 
	public boolean equals(Encomenda encomenda) {
		if (this == encomenda) {
			return true;
		} else if (encomenda != null && (this.codigo.equalsIgnoreCase(encomenda.codigo))){
			return true;
		} else {
			return false;
		}
	}
	
	//Tarifa
	
	public double preço(){
		double t=0;
		
		t = this.getLocalDestino().getLocalizacao() * Encomenda.getTarifaBase();
		
		return t;
	}
}
