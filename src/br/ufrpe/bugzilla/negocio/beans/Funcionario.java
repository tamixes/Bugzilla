package br.ufrpe.bugzilla.negocio.beans;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	private Login log;
	private double salario;
	
	public Funcionario(String nome, String cpf, LocalDate nascimento, String telefone,
						Endereco endereco, double salario, String senha){
		
		super(nome, cpf, nascimento, telefone, endereco);
		this.salario = salario;
		log = new Login(cpf, senha);
		
	}
	public Funcionario(){
		this(null, null, null, null, null, 0, null);
		log = new Login();
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
