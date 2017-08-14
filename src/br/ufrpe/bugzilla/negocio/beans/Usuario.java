package br.ufrpe.bugzilla.negocio.beans;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 6071819937197676390L;
	private String login;
	private String senha; 
	
	public Usuario(String login, String senha){
		this.login = login;
		this.senha = senha;
	}
	public Usuario(){
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean equals(Usuario outro){
		
		if(outro==this){
			return true;
		}
		if(this.login.equalsIgnoreCase(outro.getLogin()) && this.senha.equals(outro.getSenha())){
			return true;
		}
		else{
			return false; 
		}
		
	}
	
	@Override
	public String toString() {
		return "Login: " + login + "\n" + "Senha: " + senha;
	}
	
}
