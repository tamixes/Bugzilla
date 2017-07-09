package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.bugzilla.negocio.beans.Tarifa;

public interface IRepositorioLocal {
	
	void cadastrarLocal(Local l);
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
	boolean existe(Local l);

}
