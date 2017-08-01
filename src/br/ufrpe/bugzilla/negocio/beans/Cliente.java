package br.ufrpe.bugzilla.negocio.beans;

public class Cliente {
	
	private String nomeEmpresa;
	private static int geraId = 1;
	private int id;
	private String cnpj;
	private String telefone;
	private Endereco endereco;
	
	public Cliente(String nome, String cnpj, String telefone, Endereco end){
		
		this.id = geraId;
		geraId++;
		
		this.nomeEmpresa = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.endereco = end;
	}
	
	public Cliente(){
		
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	
	public String toString() {

		String resultado = "";
		
		resultado =
				  "Dados do cliente:\n" 
				+ "\t Nome da empresa: " 	+ this.getNomeEmpresa() + "\n"
				+ "\t ID: " 	+ this.getId() + "\n"
				+ "\t CNPJ: " 		+ this.getCnpj() + "\n"
				+ "\t Telefone: " 		+ this.getTelefone() + "\n"
				+ "\t Endereço: " 		+ this.getEndereco() + "\n";
		
		return resultado;

	}

	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Cliente other = (Cliente) obj;
		
		if(this.id == other.id && this.cnpj.equals(other.cnpj)
				&& this.endereco.equals(other.endereco) && this.nomeEmpresa.equalsIgnoreCase(other.nomeEmpresa)){
			return true;
		}
	
		return false;
	}
}