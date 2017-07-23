package br.ufrpe.exceptions;

public class LocalExisteException extends Exception {
	
	private String nome;
	
	public LocalExisteException(String nome){
		super("O local " + nome + " j� existe");
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}

}
