package br.ufrpe.bugzilla.exceptions;

public class ErroAoRemoverException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2401353299711938936L;

	public ErroAoRemoverException(){
		super("N�o foi poss�vel remover");
	}
}
