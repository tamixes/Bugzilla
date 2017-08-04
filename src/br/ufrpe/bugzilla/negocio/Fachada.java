package br.ufrpe.bugzilla.negocio;

import br.ufrpe.bugzilla.negocio.beans.*;
import br.ufrpe.exceptions.ErroAoAtualizarException;
import br.ufrpe.exceptions.ErroAoRemoverException;
import br.ufrpe.exceptions.ObjectJaExisteException;
import br.ufrpe.exceptions.ObjectNaoExisteException;

import java.util.ArrayList;
import java.util.List;

public class Fachada implements IFachada{
	
	private CadastroAdministrador cadastroAdministrador;
	private CadastroFuncionario cadastroFuncionario;
	private ControladorEncomenda controleEncomenda;
	private ControladorLocal controleLocal;
	private ControladorCliente controleCliente;
	private static Fachada instance;
	
	private Fachada(){
		this.cadastroAdministrador = CadastroAdministrador.getInstance();
		this.cadastroFuncionario = CadastroFuncionario.getInstance();
		this.controleEncomenda = ControladorEncomenda.getInstance();
		this.controleLocal = ControladorLocal.getInstance();
		this.controleCliente = ControladorCliente.getInstance();
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
	
	public void defineTarifaBase(double tarifa){
		controleEncomenda.defineTarifaBase(tarifa);
	}

	
	//ADMINISTRADOR
	public void cadastrarAdministrador(Administrador adm) throws ObjectJaExisteException{
		this.cadastroAdministrador.cadastrarAdministrador(adm);
		
	}

	public Administrador buscarAdministrador(String cpf) throws ObjectNaoExisteException{
		return this.cadastroAdministrador.buscaAdministrador(cpf);
	}
	
	public boolean verificaLoginAdministrador(Usuario usuario){
		return this.cadastroAdministrador.verificaLogin(usuario);
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
	public boolean verificaLoginFuncionario(Usuario usuario){
		return this.cadastroFuncionario.login(usuario.getLogin(), usuario.getSenha());
	}

	public List<Funcionario> listarFuncionarios() {
		return this.cadastroFuncionario.mostrarfunc();
	}

	//LOCAL

	public void cadastrarLocal(Local l) throws ObjectJaExisteException {
			
		this.controleLocal.cadastrarLocal(l);
	}

	public Local procurarLocal(String nome) throws ObjectNaoExisteException {
		
		return this.controleLocal.procurarLocal(nome);
	}


	public void atualizarLocal(Local l) throws ObjectNaoExisteException {
		
		this.controleLocal.atualizarLocal(l);
	}


	public void removerLocal(String nome) throws ObjectNaoExisteException {
		
		this.controleLocal.removerLocal(nome);
	}


	public ArrayList<Local> listarLocais() {
		
		return this.controleLocal.listarLocais();
	}

	
	//CLIENTE
	
	public void cadastrarCliente(Cliente cliente) {
		
		this.controleCliente.cadastrarCliente(cliente);
	}


	public Cliente procurarCliente(String nome) {
		
		return this.controleCliente.procurarCliente(nome);
	}


	public void atualizarCliente(Cliente cliente) {
		
		this.controleCliente.atualizarCliente(cliente);
	}


	public void removerCliente(String nome) {
		
		this.controleCliente.removerCliente(nome);
	}


	public ArrayList<Cliente> listarClientes() {
		
		return this.controleCliente.listarClientes();
	}
	
}