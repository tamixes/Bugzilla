package br.ufrpe.exceptions;

public class ErroAoRemoverException extends Exception {
	
	public ErroAoRemoverException(){
		super("Não foi possível remover");
	}
}
