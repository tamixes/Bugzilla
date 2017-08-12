package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Local;

public interface IRepositorioLocal {
	
	void cadastrarLocal(Local l);
	Local procurarLocal(String nome) throws ObjectNaoExisteException;
	void atualizarLocal(Local l) throws ObjectNaoExisteException, ErroAoAtualizarException;
	void removerLocal(String nome) throws ObjectNaoExisteException, ErroAoRemoverException;
	ArrayList<Local> listarLocais();
	boolean existe(Local l);
	
}
