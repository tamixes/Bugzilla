package br.ufrpe.bugzilla.negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import old.Pessoa;

public class Encomenda {
	private static int geraCodigo = 1;

	private int codigo;
	private Pessoa destinatario;
	private double peso;
	private String tipoDoProduto;
	private boolean entregue = false;
	private int pedido;
	private String localAtual;
	private String relatorioDeRastreio = "Relatório de rastreio\n";

	public Encomenda(Pessoa destinatario, double peso, String tipo, int pedido) {
		this.codigo = geraCodigo;
		geraCodigo++;

		this.peso = peso;
		this.destinatario = destinatario;
		this.tipoDoProduto = tipo;
		this.pedido = pedido;
	}

	public Encomenda() {
		this(null, 0, null, 0);
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


	public int getPedido() {
		return pedido;
	}

	//Por causa do construtor vazio que inicia o numero de pedido em 0, eu fiz o setPedido desse jeito;
	public void setPedido(int pedido) {
		if (this.codigo == 0){
			this.pedido = pedido;
		}
		else
			System.out.println("Esta entrega já possui um código de pedido definido!");
		
	}

	public int getCodigo() {
		return codigo;
	}
	
	public Pessoa getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Pessoa destinatario) {
		this.destinatario = destinatario;
	}

	public String getRelatorioDeRastreio() {
		return relatorioDeRastreio;
	}
	
	
	public String Status(){
		String resultado;
		if(this.entregue == false){
			resultado = "ENCOMENDA A CAMINHO";
		}
		else{
			resultado = "ENCOMENDA ENTREGUE";
		}
		
		return resultado;
	}
	
	
	public String atualizaRelatorio(String local, String situacao) {
		//No caso, local seria o endereço de onde está atualmente, e situação se está postado, encaminhado, indo pra entrega e etc.
		//Esse metodo vai pegar o que tem no atributo relatorioDeRastreio e concatenar com novas informações de relatório
		
		LocalDate data = LocalDate.now();
		String resultado = this.relatorioDeRastreio;

		if (this.entregue == false) {
			data = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MM yyyy");
			String date = data.format(format);

			resultado = resultado + date + "| ";
			resultado = resultado + local + "| " + situacao + "\n";

			this.relatorioDeRastreio = resultado;
			this.localAtual = local;
			
			if(this.localAtual.equals(this.destinatario.getEnd().getRua())){
				this.entregue = true;
			}
			
			return this.relatorioDeRastreio;
		}

		else {
			return this.relatorioDeRastreio;
		}
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
				+ "\t Codigo de pedido: " 		+ this.pedido + "\n";
		
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
