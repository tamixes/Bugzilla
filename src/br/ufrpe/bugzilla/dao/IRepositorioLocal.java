package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.bugzilla.negocio.beans.Tarifa;
import br.ufrpe.exceptions.LocalNaoEncontradoException;

public interface IRepositorioLocal {
	
	void cadastrarLocal(Local l);
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
	boolean existe(Local l);

}
