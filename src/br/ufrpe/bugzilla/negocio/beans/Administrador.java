package br.ufrpe.bugzilla.negocio.beans;

import java.time.LocalDate;

public class Administrador extends Pessoa{
	
	private boolean admin=true;
	private Login log;

	public Administrador(String nome, String cpf, LocalDate nascimento, String telefone,
			Endereco endereco) {
		super(nome, cpf, nascimento, telefone, endereco);
	
			
		
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
	
	//temp
//	public static void main(String[] args) {
//		
//		
//		Administrador p1 = new Administrador("Tamires", "15869525420",
//				LocalDate.of(2017, 6, 22),
//				"81985445236", new Endereco("muito engraçada", "Ibura", 
//						"Hellcife", "PE", "53674-095", 54),"admin",123456789);
//		
//		System.out.println(p1);
//	}
//	
	
}
