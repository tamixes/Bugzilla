package br.ufrpe.exceptions;

public class ObjectJaExisteException extends Exception{
	
	public ObjectJaExisteException(){
		super("Já existe no sistema!");
	}
}
