package br.ufrpe.bugzilla.dao;

import java.util.List;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.bugzilla.negocio.beans.Usuario;

public interface IRepositorioFuncionario {
	
	void cadastrarFuncionario(Funcionario func) throws ObjectJaExisteException;
	Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException;
	void removerFuncionario(String cpf) throws ErroAoRemoverException;
	void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException;
	boolean existe(String cpf);
	boolean checarLogin(Usuario u);
	List<Funcionario> mostrarFuncio();
	
}
