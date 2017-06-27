package br.ufrpe.bugzilla.negocio.beans;

public class Local {
	
	private String nome;
	//vai ser utilizada para calcular tarifa e tempo (distancia em km da central)
	private int localizacao;
	
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
		return "Local: " + nome + ", Localização=" + localizacao;
	}
	
	public boolean equals(Object obj){
		//TODO implementar equals
		return true;
	}
	
}
