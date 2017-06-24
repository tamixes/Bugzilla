package br.ufrpe.bugzilla.negocio;
import java.util.ArrayList;
import java.util.List;
import br.ufrpe.bugzilla.negocio.beans.*;

public interface IFachada {
	
	void cadastrarAdministrador(Administrador adm);
	Administrador buscarAdministrador(String cpf);
	void removerAdministrador(Administrador adm);
	void alterarAdministrador(Administrador adm);
	List<Administrador> listarAdministradores();

	void addFuncionario(Funcionario func);
	Funcionario buscarFuncionario(String cpf);
	void removerFuncionario(Funcionario func);
	void alterarFuncionario(Funcionario func);
	List<Funcionario> listarFuncionarios();
	
	void novaEncomenda(Encomenda encomenda);
	Encomenda buscaEncomenda(long codigoDaEncomenda);
	void atualizaEncomenda(Encomenda encomenda);
	void removeEncomenda(long codigoDaEncommenda);
	ArrayList<Encomenda> listaDeEncomendas();
	
}
