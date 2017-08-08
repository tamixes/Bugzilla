package br.ufrpe.bugzilla.negocio;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.*;

public interface IFachada {
	
	//Administrador
	void cadastrarAdministrador(Administrador adm) throws ObjectJaExisteException;
	Administrador buscarAdministrador(String cpf) throws ObjectNaoExisteException;
	boolean verificaLoginAdministrador(Usuario usuario);
	void removerAdministrador(Administrador adm) throws ErroAoRemoverException;
	void alterarAdministrador(Administrador adm) throws ErroAoAtualizarException;
	List<Administrador> listarAdministradores();

	//Funcionario
	void addFuncionario(Funcionario func) throws ObjectJaExisteException;
	Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException;
	boolean verificaLoginFuncionario(Usuario usuario);
	void removerFuncionario(Funcionario func) throws ErroAoRemoverException;
	void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException;
	List<Funcionario> listarFuncionarios();
	
	//Encomenda
	void novaEncomenda(Encomenda encomenda) throws ObjectJaExisteException;
	Encomenda buscaEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException;
	void atualizaEncomenda(Encomenda encomenda) throws ObjectNaoExisteException, ErroAoAtualizarException;
	void removeEncomenda(String codigoDaEncommenda) throws ObjectNaoExisteException, ErroAoRemoverException;
	ArrayList<Encomenda> listaDeEncomendas();
	public void defineTarifaBase(double tarifa);
	
	//Local
	void cadastrarLocal(Local l) throws ObjectJaExisteException;
	Local procurarLocal(String nome) throws ObjectNaoExisteException;
	void atualizarLocal(Local l) throws ObjectNaoExisteException;
	void removerLocal(String nome) throws ObjectNaoExisteException;
	ArrayList<Local> listarLocais();
	
	//Cliente
	void cadastrarCliente(Cliente cliente) throws ObjectJaExisteException;
	Cliente procurarCliente(String nome) throws ObjectNaoExisteException;
	void atualizarCliente(Cliente cliente) throws ObjectNaoExisteException;
	void removerCliente(String nome) throws ObjectNaoExisteException;
	ArrayList<Cliente> listarClientes();
	
}
