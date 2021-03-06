package br.ufrpe.bugzilla.negocio.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Encomenda implements Serializable{
	
	private static final long serialVersionUID = -4937323924669001136L;

	private static long geraCodigo = 10000;

	private String codigo;
	private Cliente remetente;
	private Cliente destinatario;
	private double peso;
	private String tipoDoProduto;
	private boolean entregue = false;
	private ArrayList<Rastreio> rastreio = new ArrayList<Rastreio>();
	
	/**a tarifa � definida pelo m�todo pre�o
	/**usando a tarifa base, o peso e a dist�ncia
	 * em KM entre o Local de partida e Destino**/
	private double tarifa;
	//tarifa em R$ por km
	private static double tarifaBase = 0.20;
	//prazo em dias � definido ao cadastrar encomenda
	private int prazoEntrega;
	/*O local de partida � uma cidade*/
	private Local localPartida;
	/*O local de destino � uma cidade*/
	private Local localDestino;
	
	public Encomenda() {
		
	}

	public Encomenda(Cliente remetente, Cliente destinatario, double peso, String tipo, Local partida, Local destino, int prazo) {
		this.codigo = "BUG" + geraCodigo + "BR";
		geraCodigo++;

		this.localPartida = partida;
		this.localDestino = destino;
		this.peso = peso;
		this.destinatario = destinatario;
		this.tipoDoProduto = tipo;
		this.tarifa = this.pre�o();
		this.prazoEntrega = prazo;
		this.remetente = remetente;
	}
	
	public Cliente getRemetente() {
		return remetente;
	}

	public void setRemetente(Cliente remetente) {
		this.remetente = remetente;
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
	
	public Local getLocalPartida() {
		return localPartida;
	}

	public void setLocalPartida(Local localDestino) {
		this.localPartida = localDestino;
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
	
	public void setEntregue(){
		this.entregue = true;
	}

	public String getCodigo() {
		return codigo;
	}

	public Cliente getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Cliente destinatario) {
		this.destinatario = destinatario;
	}

	public ArrayList<Rastreio> getRastreio() {
		return rastreio;
	}


	public String Status() {
		String resultado;
		if (this.entregue == false) {
			resultado = "ENCOMENDA A CAMINHO";
		} else {
			resultado = "ENCOMENDA ENTREGUE";
		}

		return resultado;
	}

	public void atualizaRelatorio(String situacao, String local, LocalDateTime dataHora) {
		Rastreio rastreio = new Rastreio(situacao, local, dataHora);

		this.rastreio.add(rastreio);
	}

	public void atualizaRelatorio(Rastreio rastreio) {
		this.rastreio.add(rastreio);
	}

	//alterei o for para mostrar os �ltimos rastreios primeiro
	public String getRastreamento() {
		String result = "";

		for (int i = this.rastreio.size()-1; i >= 0; --i) {
			result += "\t" + rastreio.get(i) + "\n";
		}
		return result;
	}

	public String getRelatorioPorData(LocalDateTime data) {
		String result = "N�o houve nada nessa data";
		for (int i = 0; i < this.rastreio.size(); i++) {
			if (data.equals(this.rastreio.get(i).getDataHora())) {
				result = this.rastreio.get(i).toString();
			}
		}
		return result;
	}

	public String toString() {
		String resultado = "";
		
		resultado =
				  "\t - - - - - -Dados da encomenda- - - - - -\n\n" 
				+ "\t Remetente: "                  + this.getRemetente().getNome() + "\n"
				+ "\t Nome do destinat�rio: " 	+ this.destinatario.getNome() + "\n"
				+ "\t Destino do produto: " 	+ "Central Bugzilla em " + this.localDestino.getNome() + "\n"
				+ "\t Destino final: " 	+ this.destinatario.getEndereco() + "\n"
				+ "\t Status da entrega: " 		+ this.Status() + "\n"
				+ "\t Tipo de produto: " 		+ this.tipoDoProduto + "\n"
				+ "\t Peso do produto: " 		+ this.peso + "kg\n"
				+ "\t Codigo de rastreamento: " 		+ this.codigo + "\n"
				+ "\t Prazo de entrega: " 		+ this.prazoEntrega + " dias\n"
				+ "\t Valor: R$" 		            + String.format("%.2f", this.tarifa) + "\n"
				+ "\n\n"
				+ "\t - - - - - -Rastreamento- - - - - -\n\n"
				+ this.getRastreamento();
		
		return resultado;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} 
		
		Encomenda outro = (Encomenda) obj;
		
		if (obj != null && (this.codigo.equalsIgnoreCase(outro.getCodigo()))){
			return true;
		} else {
			return false;
		}
	}
	
	//Tarifa
	
	public double pre�o(){
		double t=0;
		
		//O valor em R$ � definido pela dist�ncia em km (X) a tarifa base (+) o peso da encomenda (/) por 2.
		t = ( (CalculaDistancia.DistanciaGeoEmKm(localPartida, localDestino) * Encomenda.getTarifaBase()) + this.peso / 2 );
		
		return t;
	}

}
