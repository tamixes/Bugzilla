package br.ufrpe.bugzilla.negocio.beans;

public class Local {
	
	private String nome;
	private int localizacao;
	//vai ser utilizada para calcular tarifa/tempo (distancia em km da central)
	
	public Local(){
		this.nome = "";
		localizacao = 0;
	}
	
	public Local(String nome, int localizacao){
		
		this.nome = nome;
		this.localizacao = localizacao;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}

	public int getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(int localizacao) {
		this.localizacao = localizacao;
	}

	public String toString() {
		return "Local: " + nome + ", Localização: " + localizacao;
	}
	
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		Local other = (Local) obj;
		
		if(this.nome.equals(other.getNome()) && this.localizacao == 
				other.getLocalizacao()){
			return true;
		}
		return false;
	}
}
