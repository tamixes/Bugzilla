package br.ufrpe.bugzilla.negocio.beans;

public class Local {
	
	private String nome;
	//vai ser utilizada para calcular distancia em km
	private double longitude;
	private double latitude;
	
	public Local(){
		
	}
	
	public Local(String nome, double longitude, double latitude){
		
		this.nome = nome;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String toString() {
		return "Local: " + nome + "\nLocalização: " + "(" + this.getLongitude() + ", " + this.getLatitude() + ")";
	}
	
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		Local other = (Local) obj;
		
		if(this.nome.equalsIgnoreCase(other.getNome()) && this.longitude == 
				other.getLongitude() && this.latitude == other.getLatitude()){
			return true;
		}
		return false;
	}
}
