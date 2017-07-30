package br.ufrpe.bugzilla.negocio.beans;

public class Tarifa {
	
	private int valorBase;
	private int tipoEntrega;
	
	public Tarifa(int valor, String entrega){
		this.valorBase = valor;
		
		if(entrega.equals("expressa")){
			this.tipoEntrega = 2;
		}
		else{
			this.tipoEntrega = 1;
		}
	}
	
	public Tarifa(int valor){
		this.valorBase = valor;
		this.tipoEntrega = 1;
	}
	

	public int getValorBase() {
		return valorBase;
	}

	public void setValorBase(int valorBase) {
		this.valorBase = valorBase;
	}

	public int getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(int tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Tarifa other = (Tarifa) obj;
		if (valorBase == other.valorBase && tipoEntrega == other.tipoEntrega)
			return true;
		return false;
	}

	@Override
	public String toString() {
		String texto = "";
		
		texto = String.format("Preço por Km: %d\nPrazo de entrega: %d dias por Km"
				,valorBase, tipoEntrega);
		
		return texto;
	}

}
