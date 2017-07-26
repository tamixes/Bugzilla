package br.ufrpe.exceptions;

import br.ufrpe.bugzilla.negocio.beans.Local;

public class LocalNaoEncontradoException extends Exception{
	
	private String nome;
	
	public LocalNaoEncontradoException(String nome){
		super("O local " + nome + " n�o foi encontrado");
		this.nome = nome;
	}
	
	public LocalNaoEncontradoException(Local l){
		super("O local " + l.getNome() + " n�o foi encontrado");
		this.nome = l.getNome();
	}
	
	public String getNome(){
		return nome;
	}

}
