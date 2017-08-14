package br.ufrpe.bugzilla.exceptions;

public class ErroAoAtualizarException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9172635424293568498L;

	public ErroAoAtualizarException(){
		super("Não foi possível atualizar!");
	}
}
