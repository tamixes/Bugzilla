package br.ufrpe.bugzilla.negocio;

import br.ufrpe.bugzilla.negocio.beans.*;
import br.ufrpe.exceptions.ErroAoAtualizarException;
import br.ufrpe.exceptions.ErroAoRemoverException;
import br.ufrpe.exceptions.LocalExisteException;
import br.ufrpe.exceptions.LocalNaoEncontradoException;
import br.ufrpe.exceptions.ObjectJaExisteException;
import br.ufrpe.exceptions.ObjectNaoExisteException;

import java.util.ArrayList;
import java.util.List;

public class Fachada implements IFachada{
	
	private CadastroAdministrador cadastroAdministrador;
	private CadastroFuncionario cadastroFuncionario;
	private ControladorEncomenda controleEncomenda;
	private ControladorLocal controleLocal;
	private static Fachada instance;
	
	private Fachada(){
		this.cadastroAdministrador = CadastroAdministrador.getInstance();
		this.cadastroFuncionario = CadastroFuncionario.getInstance();
		this.controleEncomenda = ControladorEncomenda.getInstance();
		this.controleLocal = ControladorLocal.getInstance();
	}
	
	
	public static Fachada getInstance(){
		if(instance == null){
			instance = new Fachada();
		}
		
		return instance;
	}
	
	//ENCOMENDA
	public void novaEncomenda(Encomenda encomenda) {
		controleEncomenda.novaEncomenda(encomenda);
	}

	public Encomenda buscaEncomenda(String codigoDaEncomenda) {
		return controleEncomenda.buscaEncomenda(codigoDaEncomenda);
	}

	public void atualizaEncomenda(Encomenda encomenda) {
		controleEncomenda.atualizaEncomenda(encomenda);
	}

	public void removeEncomenda(String codigoDaEncommenda) {
		controleEncomenda.removeEncomenda(codigoDaEncommenda);
	}

	public ArrayList<Encomenda> listaDeEncomendas() {
		return controleEncomenda.listaDeEncomendas();
	}

	
	//ADMINISTRADOR
	public void cadastrarAdministrador(Administrador adm) throws ObjectJaExisteException{
		this.cadastroAdministrador.cadastrarAdministrador(adm);
		
	}

	public Administrador buscarAdministrador(String cpf) throws ObjectNaoExisteException{
		return this.cadastroAdministrador.buscaAdministrador(cpf);
	}
	
	public boolean verificaLoginAdministrador(Login login){
		return this.cadastroAdministrador.verificaLogin(login);
	}

	public void removerAdministrador(Administrador adm) throws ErroAoRemoverException{
		this.removerAdministrador(adm);
		
	}

	public void alterarAdministrador(Administrador adm) throws ErroAoAtualizarException{
		this.cadastroAdministrador.alterarAdministrador(adm);
		
	}

	public List<Administrador> listarAdministradores() {
		return this.cadastroAdministrador.listaAdministrador();
	}
	
	//FUNCIONÁRIO
	public void addFuncionario(Funcionario func) throws ObjectJaExisteException{
		this.cadastroFuncionario.cadastrarFuncionario(func);
		
	}

	public Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException {
		return this.cadastroFuncionario.buscarFuncionario(cpf);
	}

	public void removerFuncionario(Funcionario func) throws ErroAoRemoverException{
		this.cadastroFuncionario.removerFuncionario(func);
		
	}

	public void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException{
		this.cadastroFuncionario.alterarFuncionario(func);
		
	}
	public boolean verificaLoginFuncionario(Login login){
		return this.cadastroFuncionario.login(login.getLogin(), login.getSenha());
	}

	public List<Funcionario> listarFuncionarios() {
		return this.cadastroFuncionario.mostrarfunc();
	}

	//LOCAL

	public void cadastrarLocal(Local l) throws LocalExisteException {
			
		this.controleLocal.cadastrarLocal(l);
	}

	public Local procurarLocal(String nome) throws LocalNaoEncontradoException {
		
		return this.controleLocal.procurarLocal(nome);
	}


	public void atualizarLocal(Local l) throws LocalNaoEncontradoException {
		
		this.controleLocal.atualizarLocal(l);
	}


	public void removerLocal(String nome) throws LocalNaoEncontradoException {
		
		this.controleLocal.removerLocal(nome);
	}


	public ArrayList<Local> listarLocais() {
		
		return this.controleLocal.listarLocais();
	}
	
}
