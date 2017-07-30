package br.ufrpe.bugzilla.negocio.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Encomenda {
	private static long geraCodigo = 1;

	/*private long pedido;*/
	private long codigo;
	private Pessoa destinatario;
	private double peso;
	private String tipoDoProduto;
	private boolean entregue = false;
	private ArrayList<Rastreio> rastreio = new ArrayList<Rastreio>();
	private Tarifa tarifa;
	private Local localDestino;

	public Encomenda(Pessoa destinatario, double peso, String tipo, Tarifa tarifa, Local destino/*, int pedido*/) {
		this.codigo = geraCodigo;
		geraCodigo++;

		this.tarifa = tarifa;
		this.localDestino = destino;
		this.peso = peso;
		this.destinatario = destinatario;
		this.tipoDoProduto = tipo;
		//this.pedido = pedido;
	}

	public Encomenda() {
		this(null, 0, null/*, 0*/, null, null);
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
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
			System.out.println("Esta entrega já possui um código de pedido definido!");

	}*/

	public long getCodigo() {
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

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
		String result = "Não houve nada nessa data";
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
				+ "\t Nome do destinatário: " 	+ this.destinatario.getNome() + "\n"
				+ "\t Destino do produto: " 	+ this.destinatario.getEnd() + "\n"
				+ "\t Status da entrega: " 		+ this.Status() + "\n"
				+ "\t Tipo de produto: " 		+ this.tipoDoProduto + "\n"
				+ "\t Peso do produto: " 		+ this.peso + "kg\n"
				+ "\t Codigo de entrega: " 		+ this.codigo + "\n"
				/*+ "\t Codigo de pedido: " 		+ this.pedido + "\n"*/;
		
		return resultado;
	}

	public boolean equals(Encomenda encomenda) {
		if (this == encomenda) {
			return true;
		} else if (encomenda != null && (encomenda.codigo == this.codigo)) {
			return true;
		} else {
			return false;
		}
	}
}
