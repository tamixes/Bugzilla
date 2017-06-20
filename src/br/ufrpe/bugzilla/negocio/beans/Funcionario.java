package br.ufrpe.bugzilla.negocio.beans;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	private Login log;
	private double salario;
	
	public Funcionario(String nome, String cpf, LocalDate nascimento, String telefone,
						Endereco endereco, double salario){
		
		super(nome, cpf, nascimento, telefone, endereco);
		this.salario = salario; 
		String senha; 
		// falta fazer a parte da senha receber o cpf e o login receber o nome do funcionario
		
	}

	public Login getLog() {
		return log;
	}

	public void setLog(Login log) {
		this.log = log;
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
		resultado += "\nSalario: " + this.salario + "\nLogin: " + this.log.getLogin() + "\nSenha: " + this.log.getSenha();
		
		return resultado;
	}
}
