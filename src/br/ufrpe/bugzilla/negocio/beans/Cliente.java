package br.ufrpe.bugzilla.negocio.beans;

import br.ufrpe.bugzilla.colecoes.TipoCliente;

public class Cliente {

	private String nome;
	private static int geraId = 1;
	private int id;
	private String cnpj;
	private String cpf;
	private String telefone;
	private Endereco endereco;
	private TipoCliente tipo;

	public Cliente(String nome, String cnpj, String cpf, String telefone, Endereco end, TipoCliente tipo) {
		if (tipo == TipoCliente.JUR) {
			this.id = geraId;
			geraId++;

			this.nome = nome;
			this.cnpj = cnpj;
			this.telefone = telefone;
			this.endereco = end;
			this.tipo = tipo;
		} else {
			this.id = geraId;
			geraId++;

			this.nome = nome;
			this.cpf = cpf;
			this.telefone = telefone;
			this.endereco = end;
		}

	}

	public Cliente() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeEmpresa) {
		this.nome = nomeEmpresa;
	}

	public String getCnpj() {
		return this.formataCnpj(cnpj);
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return this.formataCpf(cpf);
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public TipoCliente getTipo() {
		return tipo;
	}

	public String formataCpf(String cpf) {

		String p1 = cpf.substring(0, 3);
		String p2 = cpf.substring(3, 6);
		String p3 = cpf.substring(6, 9);
		String p4 = cpf.substring(9, 11);

		cpf = String.format("%s.%s.%s-%s", p1, p2, p3, p4);
		return cpf;
	}
	
	public String formataCnpj(String cnpj) {
		
		String p1 = cnpj.substring(0, 2);
		String p2 = cnpj.substring(2, 5);
		String p3 = cnpj.substring(5, 8);
		String p4 = cnpj.substring(8, 12);
		String p5 = cnpj.substring(12, 14);

		cnpj = String.format("%s.%s.%s/%s-%s", p1, p2, p3, p4, p5);
		
		return cnpj;
	}

	public String toString() {

		String resultado = "";
		if (this.tipo == TipoCliente.JUR) {
			resultado =
				  "Dados do cliente:\n" 
				+ "\t Nome da empresa: " 	+ this.getNome() + "\n"
				+ "\t ID: " 	+ this.getId() + "\n"
				+ "\t CNPJ: " 		+ this.getCnpj() + "\n"
				+ "\t Telefone: " 		+ this.getTelefone() + "\n"
				+ "\t Endereço: " 		+ this.getEndereco() + "\n";
		} else {
			resultado =
				  "Dados do cliente:\n" 
				+ "\t Nome do cliente: " 	+ this.getNome() + "\n"
				+ "\t ID: " 	+ this.getId() + "\n"
				+ "\t CPF: " 		+ this.getCpf() + "\n"
				+ "\t Telefone: " 		+ this.getTelefone() + "\n"
				+ "\t Endereço: " 		+ this.getEndereco() + "\n";
		}
		
		
		return resultado;

	}

	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;

		Cliente other = (Cliente) obj;

		if (this.id == other.id && ( this.cnpj.equals(other.cnpj) || this.cpf.equals(other.cpf) ) && this.endereco.equals(other.endereco)
				&& this.nome.equalsIgnoreCase(other.nome)) {

			return true;
		}

		return false;
	}
}
