package br.ufrpe.bugzilla.exceptions;

public class ObjectNaoExisteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4641532288956236216L;

	public ObjectNaoExisteException(){
		super("Não encontrado!");
	}

}
