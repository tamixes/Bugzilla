package br.ufrpe.bugzilla.exceptions;

public class ObjectJaExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4111137564737416345L;

	public ObjectJaExisteException(){
		super("Já existe no sistema!");
	}
}
