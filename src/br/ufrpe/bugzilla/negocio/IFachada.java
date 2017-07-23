package br.ufrpe.bugzilla.negocio;
import java.util.ArrayList;
import java.util.List;
import br.ufrpe.bugzilla.negocio.beans.*;
import br.ufrpe.exceptions.LocalExisteException;

public interface IFachada {
	
	//Administrador
	void cadastrarAdministrador(Administrador adm);
	Administrador buscarAdministrador(String cpf);
	boolean verificaLoginAdministrador(Login login);
	void removerAdministrador(Administrador adm);
	void alterarAdministrador(Administrador adm);
	List<Administrador> listarAdministradores();

	//Funcionario
	void addFuncionario(Funcionario func);
	Funcionario buscarFuncionario(String cpf);
	boolean verificaLoginFuncionario(Login login);
	void removerFuncionario(Funcionario func);
	void alterarFuncionario(Funcionario func);
	List<Funcionario> listarFuncionarios();
	
	//Encomenda
	void novaEncomenda(Encomenda encomenda);
	Encomenda buscaEncomenda(long codigoDaEncomenda);
	void atualizaEncomenda(Encomenda encomenda);
	void removeEncomenda(long codigoDaEncommenda);
	ArrayList<Encomenda> listaDeEncomendas();
	
	//Local
	void cadastrarLocal(Local l) throws LocalExisteException;
	Local procurarLocal(String nome);
	void atualizarLocal(Local l);
	void removerLocal(String nome);
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
