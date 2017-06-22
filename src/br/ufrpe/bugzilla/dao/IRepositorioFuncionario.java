package br.ufrpe.bugzilla.dao;

import java.util.List;

import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.bugzilla.negocio.CadastroFuncionario;;

public interface IRepositorioFuncionario {
	
	void cadastrarFuncionario(Funcionario func);
	Funcionario buscarFuncionario(String cpf);
	void removerFuncionario(String cpf);
	void alterarFuncionario(Funcionario func);
	boolean existe(String cpf);
	List<Funcionario> mostrarFuncio();
	RepositorioFuncionario getInstance();

}
