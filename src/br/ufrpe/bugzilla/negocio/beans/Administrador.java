package br.ufrpe.bugzilla.negocio.beans;

import java.time.LocalDate;

public class Administrador extends Pessoa{
	
	private boolean admin=true;
	private Login log;

	public Administrador(String nome, String cpf, LocalDate nascimento, String telefone,
			Endereco endereco,String senha) {
		super(nome, cpf, nascimento, telefone, endereco);
		
		log = new Login(cpf, senha);
	}
	
	public Administrador(){
		this(null, null, null, null, null, null);
		log = new Login();
	}

	public Login getLog() {
		return log;
	}

	public void setLog(Login log) {
		this.log = log;
	}

	public boolean isAdmin() {
		return admin;
	}
	

	public String toString(){
		String resultado = "Administrador\n" + super.toString();
		resultado += String.format("\nLogin: %s\nSenha: %d\n",
				this.log.getLogin(),this.log.getSenha());
		
		return resultado;
	}
	
}
