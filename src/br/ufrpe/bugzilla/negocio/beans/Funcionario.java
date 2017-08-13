package br.ufrpe.bugzilla.negocio.beans;
import java.io.Serializable;
import java.time.LocalDate;

import br.ufrpe.bugzilla.colecoes.TipoDeFuncionario;

public class Funcionario extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 4726347881805729324L;
	private double salario;
	//private TipoDeFuncionario tipo;
	
	public Funcionario(String nome, String cpf, LocalDate nascimento, String telefone,Endereco endereco, double salario, Usuario usuario/*,TipoDeFuncionario tipo*/){
		
		super(nome, cpf, nascimento, telefone, endereco, usuario);
		this.salario = salario;
	}
	
	public Funcionario(){
		this(null, null, null, null, null, 0, null);
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	/*public TipoDeFuncionario getTipo() {
		return tipo;
	}*/
	
	@Override
	public String toString(){
		String resultado = super.toString();
		resultado += /*"\n Cargo: " + getTipo() +*/ "\nSalario: " + this.salario + "\nLogin: " + this.getUsuario().getLogin() + "\nSenha: " + this.getUsuario().getSenha();
		
		return resultado;
	}
}
