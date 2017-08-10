package br.ufrpe.bugzilla.colecoes;

public enum TipoCliente {
	FIS("Pessoa Física"),
	JUR("Pessoa Jurídica");
	
	public String tipoCliente;
	
	TipoCliente(String tipo){
		tipoCliente = tipo;
	}
	
	public String getTipo(){
		return tipoCliente;
	}
}
