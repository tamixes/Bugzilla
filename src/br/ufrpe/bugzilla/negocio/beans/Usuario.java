package br.ufrpe.bugzilla.negocio.beans;

public class Usuario {
	
	private String login;
	private String senha; 
	
	public Usuario(String login, String senha){
		this.login = login;
		this.senha = senha;
	}
	public Usuario(){
		this(null, null);
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
