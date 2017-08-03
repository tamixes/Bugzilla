package br.ufrpe.bugzilla.negocio;
import java.util.ArrayList;
import java.util.List;
import br.ufrpe.bugzilla.negocio.beans.*;
import br.ufrpe.exceptions.ErroAoAtualizarException;
import br.ufrpe.exceptions.ErroAoRemoverException;
import br.ufrpe.exceptions.LocalExisteException;
import br.ufrpe.exceptions.LocalNaoEncontradoException;
import br.ufrpe.exceptions.ObjectJaExisteException;
import br.ufrpe.exceptions.ObjectNaoExisteException;

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
	void novaEncomenda(Encomenda encomenda);
	Encomenda buscaEncomenda(String codigoDaEncomenda);
	void atualizaEncomenda(Encomenda encomenda);
	void removeEncomenda(String codigoDaEncommenda);
	ArrayList<Encomenda> listaDeEncomendas();
	public void defineTarifaBase(double tarifa);
	
	//Local
	void cadastrarLocal(Local l) throws LocalExisteException;
	Local procurarLocal(String nome) throws LocalNaoEncontradoException;
	void atualizarLocal(Local l) throws LocalNaoEncontradoException;
	void removerLocal(String nome) throws LocalNaoEncontradoException;
	ArrayList<Local> listarLocais();
	
	//Cliente
	void cadastrarCliente(Cliente cliente);
	Cliente procurarCliente(String nome);
	void atualizarCliente(Cliente cliente);
	void removerCliente(String nome);
	ArrayList<Cliente> listarClientes();
	
}
