package br.ufrpe.bugzilla.negocio.beans;

public class Local {
	
	private String nome;
	//vai ser utilizada para calcular tarifa e tempo (distancia em km da central)
	private int localizacao;
	
	Local(String nome, int localizacao){
		
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
		return "Local: " + nome + ", Localiza��o=" + localizacao;
	}
	
}
