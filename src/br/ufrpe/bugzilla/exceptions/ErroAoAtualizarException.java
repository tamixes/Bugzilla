package br.ufrpe.bugzilla.exceptions;

public class ErroAoAtualizarException extends Exception{
	
	public ErroAoAtualizarException(){
		super("Não foi possível atualizar!");
	}
}
