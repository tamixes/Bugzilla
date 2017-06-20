package br.ufrpe.bugzilla.negocio.beans;

public class Login {
	private String login;
	private String senha; 
	
	public Login(String login, String senha){
		this.login = login;
		this.senha = senha;
		
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
	
	public boolean equals(Login outro){
		if(this.login.equalsIgnoreCase(outro.getLogin()) && this.senha.equalsIgnoreCase(outro.getSenha())){
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
