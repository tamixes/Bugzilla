package br.ufrpe.bugzilla.exceptions;

public class ObjectJaExisteException extends Exception{

	public ObjectJaExisteException(){
		super("Já existe no sistema!");
	}
}
