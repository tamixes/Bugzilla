package br.ufrpe.bugzilla.negocio.beans;

import java.time.LocalDate;

public class Administrador extends Pessoa{
	
	private boolean admin=true;
	private String login;
	private long senha;

	public Administrador(String nome, String cpf, LocalDate nascimento, String telefone,
			Endereco endereco, String login, long senha) {
		super(nome, cpf, nascimento, telefone, endereco);
		
		this.setLogin(login);
		this.setSenha(senha);
	}

	public boolean isAdmin() {
		return admin;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public long getSenha() {
		return senha;
	}

	public void setSenha(long senha) {
		this.senha = senha;
	}

	public String toString(){
		String resultado = "Administrador\n" + super.toString();
		resultado += String.format("\nLogin: %s\nSenha: %d\n",
				this.getLogin(),this.getSenha());
		
		return resultado;
	}
	
	//temp
	public static void main(String[] args) {
		
		
		Administrador p1 = new Administrador("Tamires", "15869525420",
				LocalDate.of(2017, 6, 22),
				"81985445236", new Endereco("muito engraçada", "Ibura", 
						"Hellcife", "PE", "53674-095", 54),"admin",123456789);
		
		System.out.println(p1);
	}
	
	
}
