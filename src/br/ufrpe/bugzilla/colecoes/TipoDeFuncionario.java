package br.ufrpe.bugzilla.colecoes;

public enum TipoDeFuncionario {
	FUNC("Funcionario"),
	ADM("Administrador");
	
	public String tipoFunc;
	
	TipoDeFuncionario(String tipo){
		tipoFunc = tipo;
	}
	
	public String getTipo() {
		return tipoFunc;
	}
}
