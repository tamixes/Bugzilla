package br.ufrpe.bugzilla.exceptions;

public class ErroAoAtualizarException extends Exception{
	
	public ErroAoAtualizarException(){
		super("N�o foi poss�vel atualizar!");
	}
}
