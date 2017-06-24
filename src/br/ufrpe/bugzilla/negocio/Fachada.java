package br.ufrpe.bugzilla.negocio;

import br.ufrpe.bugzilla.negocio.beans.*;

import java.util.ArrayList;
import java.util.List;

public class Fachada implements IFachada{
	
	private CadastroAdministrador cadastroAdministrador;
	private CadastroFuncionario cadastroFuncionario;
	private ControladorEncomenda controleEncomenda;
	private static Fachada instance;
	
	private Fachada(){
		this.cadastroAdministrador = CadastroAdministrador.getInstance();
		this.cadastroFuncionario = CadastroFuncionario.getInstance();
		this.controleEncomenda = ControladorEncomenda.getInstance();
	}
	
	
	public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		
		return instance;
	}
	
	//Encomenda
	public void novaEncomenda(Encomenda encomenda) {
		controleEncomenda.novaEncomenda(encomenda);
	}

	public Encomenda buscaEncomenda(long codigoDaEncomenda) {
		return controleEncomenda.buscaEncomenda(codigoDaEncomenda);
	}

	public void atualizaEncomenda(Encomenda encomenda) {
		controleEncomenda.atualizaEncomenda(encomenda);
	}

	public void removeEncomenda(long codigoDaEncommenda) {
		controleEncomenda.removeEncomenda(codigoDaEncommenda);
	}

	public ArrayList<Encomenda> listaDeEncomendas() {
		return controleEncomenda.listaDeEncomendas();
	}

	
	//Adm
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
	
	//Funcionario
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
