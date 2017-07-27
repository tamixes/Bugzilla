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
	boolean verificaLoginAdministrador(Login login);
	void removerAdministrador(Administrador adm) throws ErroAoRemoverException;
	void alterarAdministrador(Administrador adm) throws ErroAoAtualizarException;
	List<Administrador> listarAdministradores();

	//Funcionario
	void addFuncionario(Funcionario func) throws ObjectJaExisteException;
	Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException;
	boolean verificaLoginFuncionario(Login login);
	void removerFuncionario(Funcionario func) throws ErroAoRemoverException;
	void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException;
	List<Funcionario> listarFuncionarios();
	
	//Encomenda
	void novaEncomenda(Encomenda encomenda);
	Encomenda buscaEncomenda(long codigoDaEncomenda);
	void atualizaEncomenda(Encomenda encomenda);
	void removeEncomenda(long codigoDaEncommenda);
	ArrayList<Encomenda> listaDeEncomendas();
	
	//Local
	void cadastrarLocal(Local l) throws LocalExisteException;
	Local procurarLocal(String nome) throws LocalNaoEncontradoException;
	void atualizarLocal(Local l) throws LocalNaoEncontradoException;
	void removerLocal(String nome) throws LocalNaoEncontradoException;
	ArrayList<Local> listarLocais();
	
	// Tarifa e Tempo
	
	void defineTarifa(Tarifa t);
	void atualizaTarifa(Tarifa t);
	void atualizaTarifa(int preco, String entrega);
	int getTarifa(Local l);
	int getPrazo(Local l);
	int getTarifaDois(Local l1, Local l2);
	int getPrazoDois(Local l1, Local l2);
	
}
