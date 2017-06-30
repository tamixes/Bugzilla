package br.ufrpe.bugzilla.negocio;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.bugzilla.negocio.beans.Tarifa;

public interface IControladorLocal {

	public void cadastrarLocal(Local l);
	public Local procurarLocal(String nome);
	public void atualizarLocal(Local l);
	public void removerLocal(String nome);
	public ArrayList<Local> listarLocais();
	
	// Tarifa e Tempo
	
	public void defineTarifa(Tarifa t);
	public void atualizaTarifa(Tarifa t);
	public void atualizaTarifa(int preco, String entrega);
	public int getTarifa(Local l);
	public int getPrazo(Local l);
	public int getTarifaDois(Local l1, Local l2);
	public int getPrazoDois(Local l1, Local l2);

}
