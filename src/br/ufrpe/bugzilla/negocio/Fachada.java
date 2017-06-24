package br.ufrpe.bugzilla.negocio;

import br.ufrpe.bugzilla.negocio.beans.*;
import java.util.List;

public class Fachada implements IFachada{
	
	private CadastroAdministrador cadastroAdministrador;
	private CadastroFuncionario cadastroFuncionario; 
	private static Fachada instance;
	
	
	private Fachada(){
		this.cadastroAdministrador = CadastroAdministrador.getInstance();
		this.cadastroFuncionario = CadastroFuncionario.getInstance();
	}
	
	public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		
		return instance;
	}
	
	public void cadastrarAdministrador(Administrador adm) {
		this.cadastroAdministrador.cadastrarAdministrador(adm);
		
	}

	public Administrador buscarAdministrador(String cpf) {
		return this.cadastroAdministrador.buscaAdministrador(cpf);
	}

	public void removerAdministrador(Administrador adm) {
		this.removerAdministrador(adm);
		
	}

	public void alterarAdministrador(Administrador adm) {
		this.cadastroAdministrador.alterarAdministrador(adm);
		
	}

	public List<Administrador> listarAdministradores() {
		return this.cadastroAdministrador.listaAdministrador();
	}

	public void addFuncionario(Funcionario func) {
		this.cadastroFuncionario.cadastrarFuncionario(func);
		
	}

	public Funcionario buscarFuncionario(String cpf) {
		return this.cadastroFuncionario.buscarFuncionario(cpf);
	}

	public void removerFuncionario(Funcionario func) {
		this.cadastroFuncionario.removerFuncionario(func);
		
	}

	public void alterarFuncionario(Funcionario func) {
		this.cadastroFuncionario.alterarFuncionario(func);
		
	}

	public List<Funcionario> listarFuncionarios() {
		return this.cadastroFuncionario.mostrarfunc();
	}
	
	
}
