package br.ufrpe.bugzilla.exceptions;

public class ObjectNaoExisteException extends Exception{
	
	public ObjectNaoExisteException(){
		super("Não encontrado!");
	}

}
