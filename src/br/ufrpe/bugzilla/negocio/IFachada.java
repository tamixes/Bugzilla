package br.ufrpe.bugzilla.negocio;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.*;

public interface IFachada {
	
	//Funcionario
	void addFuncionario(Funcionario func) throws ObjectJaExisteException;
	Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException;
	boolean verificaLoginFuncionario(Usuario usuario);
	boolean verificaLoginADM(Usuario usuario);
	String nomePorLogin(Usuario u);
	String nomePorLoginADM(Usuario u);
	void removerFuncionario(String cpf) throws ErroAoRemoverException;
	void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException;
	List<Funcionario> listarFuncionarios();
	boolean existeFunc(String cpf);
	public long contadorFuncionario();
	
	//Encomenda
	void novaEncomenda(Encomenda encomenda) throws ObjectJaExisteException;
	Encomenda buscaEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException;
	void atualizaEncomenda(Encomenda encomenda) throws ObjectNaoExisteException, ErroAoAtualizarException;
	void removeEncomenda(String codigoDaEncommenda) throws ObjectNaoExisteException, ErroAoRemoverException;
	ArrayList<Encomenda> listaDeEncomendas();
	public void defineTarifaBase(double tarifa);
	public long contadorEncomenda();
	
	//Local
	void cadastrarLocal(Local l) throws ObjectJaExisteException;
	Local procurarLocal(String nome) throws ObjectNaoExisteException;
	void atualizarLocal(Local l) throws ObjectNaoExisteException, ErroAoAtualizarException;
	void removerLocal(String nome) throws ObjectNaoExisteException, ErroAoRemoverException;
	ArrayList<Local> listarLocais();
	public long contadorCentral();
	
	//Cliente
	void cadastrarCliente(Cliente cliente) throws ObjectJaExisteException;
	Cliente procurarCliente(String nome) throws ObjectNaoExisteException;
	Cliente procurarCliente(int id) throws ObjectNaoExisteException;
	void atualizarCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoAtualizarException;
	void removerCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoRemoverException;
	ArrayList<Cliente> listarClientes();
	boolean existeCliente(Cliente cliente);
	public long contadorCliente();
	
}
