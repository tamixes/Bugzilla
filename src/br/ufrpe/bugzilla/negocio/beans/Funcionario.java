package br.ufrpe.bugzilla.negocio.beans;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	private double salario;
	
	public Funcionario(String nome, String cpf, LocalDate nascimento, String telefone,
						Endereco endereco, double salario, Usuario usuario){
		
		super(nome, cpf, nascimento, telefone, endereco, usuario);
		this.salario = salario;
		
	}
	public Funcionario(){
		this(null, null, null, null, null, 0, null);
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString(){
		String resultado = super.toString();
		resultado += "\nSalario: " + this.salario + "\nLogin: " + this.getUsuario().getLogin() + "\nSenha: " + this.getUsuario().getSenha();
		
		return resultado;
	}
}
