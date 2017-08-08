package br.ufrpe.bugzilla.colecoes;

public enum TipoCliente {
	FIS("Pessoa F�sica"),
	JUR("Pessoa Jur�dica");
	
	public String tipoCliente;
	
	TipoCliente(String tipo){
		tipoCliente = tipo;
	}
	
	public String getTipo(){
		return tipoCliente;
	}
}
