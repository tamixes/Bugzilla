package br.ufrpe.bugzilla.negocio.beans;

public class Tarifa {
	private int preco;
	private int tempo;
	
	public Tarifa(int preco, String entrega){
		this.preco = preco;
		
		if(entrega.equals("expressa")){
			this.tempo = 2;
		}
		else{
			this.tempo = 1;
		}
	}
	
	public Tarifa(int preco){
		this.preco = preco;
		this.tempo = 1;
	}
	
	

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Tarifa other = (Tarifa) obj;
		if (preco == other.preco && tempo == other.tempo)
			return true;
		return false;
	}

	@Override
	public String toString() {
		String texto = "";
		
		texto = String.format("Preço por Km: %d\nPrazo de entrega: %d dias por Km"
				,preco, tempo);
		
		return texto;
	}
	//temp
	public static void main(String[] args) {
		Local l1 = new Local("São Paulo",50);
		Tarifa t1 = new Tarifa(3,"expressa");
		
		System.out.println(t1);
		System.out.println();
		System.out.println(l1);
	}

}
