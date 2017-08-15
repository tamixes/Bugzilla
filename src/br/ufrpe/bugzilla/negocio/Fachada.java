package br.ufrpe.bugzilla.negocio;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.*;

import java.util.ArrayList;
import java.util.List;

public class Fachada implements IFachada {

	private CadastroFuncionario cadastroFuncionario;
	private ControladorEncomenda controleEncomenda;
	private ControladorLocal controleLocal;
	private ControladorCliente controleCliente;
	private static Fachada instance;

	private Fachada() {
		this.cadastroFuncionario = CadastroFuncionario.getInstance();
		this.controleEncomenda = ControladorEncomenda.getInstance();
		this.controleLocal = ControladorLocal.getInstance();
		this.controleCliente = ControladorCliente.getInstance();
	}

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}

		return instance;
	}

	/** ENCOMENDA **/
	public void novaEncomenda(Encomenda encomenda) throws ObjectJaExisteException {
		this.controleEncomenda.novaEncomenda(encomenda);
	}

	public Encomenda buscaEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException {
		return this.controleEncomenda.buscaEncomenda(codigoDaEncomenda);
	}

	public void atualizaEncomenda(Encomenda encomenda) throws ObjectNaoExisteException, ErroAoAtualizarException {
		this.controleEncomenda.atualizaEncomenda(encomenda);
	}

	public void removeEncomenda(String codigoDaEncommenda) throws ObjectNaoExisteException, ErroAoRemoverException {
		this.controleEncomenda.removeEncomenda(codigoDaEncommenda);
	}

	public ArrayList<Encomenda> listaDeEncomendas() {
		return this.controleEncomenda.listaDeEncomendas();
	}

	public void defineTarifaBase(double tarifa) {
		this.controleEncomenda.defineTarifaBase(tarifa);
	}
	
	public long contadorEncomenda(){
		
		return this.controleEncomenda.contadorEncomenda();
	}
	

	/** FUNCIONÁRIO **/
	public void addFuncionario(Funcionario func) throws ObjectJaExisteException {
		this.cadastroFuncionario.cadastrarFuncionario(func);

	}

	public Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException {
		return this.cadastroFuncionario.buscarFuncionario(cpf);
	}

	public void removerFuncionario(Funcionario func) throws ErroAoRemoverException {
		this.cadastroFuncionario.removerFuncionario(func);

	}

	public void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException {
		this.cadastroFuncionario.alterarFuncionario(func);

	}

	public boolean verificaLoginFuncionario(Usuario usuario) {
		return this.cadastroFuncionario.login(usuario.getLogin(), usuario.getSenha());
	}
	
	public boolean verificaLoginADM(Usuario usuario){
		return this.cadastroFuncionario.loginADM(usuario);
	}

	public List<Funcionario> listarFuncionarios() {
		return this.cadastroFuncionario.mostrarfunc();
	}

	public boolean existeFunc(String cpf) {
		return this.cadastroFuncionario.existe(cpf);
	}
	
	public long contadorFuncionario(){
		return this.cadastroFuncionario.contadorFuncionario();
	}
	
	public String nomePorLogin(Usuario u) {
		
		return this.cadastroFuncionario.nomePorLogin(u);
	}

	public String nomePorLoginADM(Usuario u) {
		
		return this.cadastroFuncionario.nomePorLoginADM(u);
	}

	/** LOCAL **/

	public void cadastrarLocal(Local l) throws ObjectJaExisteException {

		this.controleLocal.cadastrarLocal(l);
	}

	public Local procurarLocal(String nome) throws ObjectNaoExisteException {

		return this.controleLocal.procurarLocal(nome);
	}

	public void atualizarLocal(Local l) throws ObjectNaoExisteException, ErroAoAtualizarException {

		this.controleLocal.atualizarLocal(l);
	}

	public void removerLocal(String nome) throws ObjectNaoExisteException, ErroAoRemoverException {

		this.controleLocal.removerLocal(nome);
	}

	public ArrayList<Local> listarLocais() {

		return this.controleLocal.listarLocais();
	}
	
	public long contadorCentral(){
		
		return this.controleLocal.contadorLocal();
	}

	/**
	 * CLIENTE
	 * 
	 * @throws ObjectJaExisteException
	 **/

	public void cadastrarCliente(Cliente cliente) throws ObjectJaExisteException {

		this.controleCliente.cadastrarCliente(cliente);
	}

	public Cliente procurarCliente(String nome) throws ObjectNaoExisteException {

		return this.controleCliente.procurarCliente(nome);
	}

	public Cliente procurarCliente(int id) throws ObjectNaoExisteException {

		return this.controleCliente.procurarCliente(id);
	}

	public void atualizarCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoAtualizarException {

		this.controleCliente.atualizarCliente(cliente);
	}

	public void removerCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoRemoverException {

		this.controleCliente.removerCliente(cliente);
	}

	public ArrayList<Cliente> listarClientes() {

		return this.controleCliente.listarClientes();
	}

	public boolean existeCliente(Cliente cliente) {

		return this.controleCliente.existe(cliente);

	}
	
	public long contadorCliente(){
		
		return this.controleCliente.contadorCliente();
	}


}