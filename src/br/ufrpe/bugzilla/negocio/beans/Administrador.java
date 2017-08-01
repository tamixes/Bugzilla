package br.ufrpe.bugzilla.negocio.beans;

import java.time.LocalDate;

public class Administrador extends Pessoa{
	
	private boolean admin=true;

	public Administrador(String nome, String cpf, LocalDate nascimento, String telefone,
			Endereco endereco,String senha, Usuario usuario) {
		super(nome, cpf, nascimento, telefone, endereco, usuario);
		
		//log = new Login(cpf, senha);
	}
	
	public Administrador(){
		this(null, null, null, null, null, null, null);
		//log = new Login();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setLog(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAdmin() {
		return admin;
	}
	

	public String toString(){
		String resultado = "Administrador\n" + super.toString();
		resultado += String.format("\nLogin: %s\nSenha: %d\n",
				this.getUsuario().getLogin(),this.getUsuario().getSenha());
		
		return resultado;
	}
	
}
