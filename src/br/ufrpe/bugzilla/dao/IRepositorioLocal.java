package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.exceptions.LocalNaoEncontradoException;

public interface IRepositorioLocal {
	
	void cadastrarLocal(Local l);
	Local procurarLocal(String nome) throws LocalNaoEncontradoException;
	void atualizarLocal(Local l) throws LocalNaoEncontradoException;
	void removerLocal(String nome) throws LocalNaoEncontradoException;
	ArrayList<Local> listarLocais();
	boolean existe(Local l);
	
}
