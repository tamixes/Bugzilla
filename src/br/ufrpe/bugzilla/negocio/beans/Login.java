package br.ufrpe.bugzilla.negocio.beans;

public class Login {
	private String login;
	private int senha; 
	
	public Login(String login, int senha){
		this.login = login;
		this.senha = senha;
		
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

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public boolean equals(Login outro){
		if(this.login.equalsIgnoreCase(outro.getLogin()) && this.senha == outro.getSenha()){
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
