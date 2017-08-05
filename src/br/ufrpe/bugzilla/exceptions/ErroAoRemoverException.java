package br.ufrpe.bugzilla.exceptions;

public class ErroAoRemoverException extends Exception {
	
	public ErroAoRemoverException(){
		super("Não foi possível remover");
	}
}
