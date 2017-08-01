package br.ufrpe.bugzilla.dao;

import java.util.List;

import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.bugzilla.negocio.beans.Usuario;
import br.ufrpe.exceptions.ErroAoAtualizarException;
import br.ufrpe.exceptions.ErroAoRemoverException;
import br.ufrpe.exceptions.ObjectJaExisteException;
import br.ufrpe.exceptions.ObjectNaoExisteException;

public interface IRepositorioFuncionario {
	
	void cadastrarFuncionario(Funcionario func) throws ObjectJaExisteException;
	Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException;
	void removerFuncionario(String cpf) throws ErroAoRemoverException;
	void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException;
	boolean existe(String cpf);
	boolean checarLogin(Usuario u);
	List<Funcionario> mostrarFuncio();
	
}
