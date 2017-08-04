package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.exceptions.ObjectNaoExisteException;

public interface IRepositorioLocal {
	
	void cadastrarLocal(Local l);
	Local procurarLocal(String nome) throws ObjectNaoExisteException;
	void atualizarLocal(Local l) throws ObjectNaoExisteException;
	void removerLocal(String nome) throws ObjectNaoExisteException;
	ArrayList<Local> listarLocais();
	boolean existe(Local l);
	
}
