package br.ufrpe.bugzilla.negocio.beans;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	private double salario;
	
	public Funcionario(String nome, String cpf, LocalDate nascimento, String telefone,
						Endereco endereco, double salario, String senha, Usuario usuario){
		
		super(nome, cpf, nascimento, telefone, endereco, usuario);
		this.salario = salario;
		//log = new Login(cpf, senha);
		
	}
	public Funcionario(){
		this(null, null, null, null, null, 0, null, null);
		//log = new Login();
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
	
	@Override
	public String toString(){
		String resultado = super.toString();
		resultado += "\nSalario: " + this.salario + "\nLogin: " + this.getUsuario().getLogin() + "\nSenha: " + this.getUsuario().getSenha();
		
		return resultado;
	}
}
