package br.ufrpe.bugzilla.dao;

import br.ufrpe.bugzilla.negocio.beans.Administrador;
import br.ufrpe.bugzilla.negocio.beans.Usuario;
import br.ufrpe.exceptions.ErroAoAtualizarException;
import br.ufrpe.exceptions.ErroAoRemoverException;
import br.ufrpe.exceptions.ObjectJaExisteException;
import br.ufrpe.exceptions.ObjectNaoExisteException;

import java.util.List;

public interface IRepositorioAdministrador {

	boolean existe(String cpf);
	void cadastrarAdministrador(Administrador adm) throws ObjectJaExisteException;
	Administrador buscaAdministrador(String cpf) throws ObjectNaoExisteException;
	void removerAdministrador(String cpf) throws ErroAoRemoverException;
	void alteraAdministrador(Administrador adm) throws ErroAoAtualizarException;
	boolean verificaLogin(Usuario usuario);
	List<Administrador> listaAdministrador();

}
