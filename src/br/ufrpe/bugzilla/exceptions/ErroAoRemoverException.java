package br.ufrpe.bugzilla.exceptions;

public class ErroAoRemoverException extends Exception {
	
	public ErroAoRemoverException(){
		super("N�o foi poss�vel remover");
	}
}
