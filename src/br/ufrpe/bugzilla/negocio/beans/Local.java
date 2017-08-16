package br.ufrpe.bugzilla.negocio.beans;

import java.io.Serializable;

public class Local implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2827046348593130271L;
	private String nome;
	//vai ser utilizada para calcular distancia em km
	private double latitude;
	private double longitude;
	
	public Local(){
		
	}
	
	public Local(String nome, double latitude, double longitude){
		
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
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
		return this.nome + "\nLocalização: (" + latitude + ", " + longitude + ")";
	}
	
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		
		if(obj instanceof Local){
			Local other = (Local) obj;
		
			if(this.nome.equalsIgnoreCase(other.getNome()) && this.longitude == 
					other.getLongitude() && this.latitude == other.getLatitude()){
				return true;
			}
		}
		return false;
	}
}
