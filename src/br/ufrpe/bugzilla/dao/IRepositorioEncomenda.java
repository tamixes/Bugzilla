package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Encomenda;

public interface IRepositorioEncomenda {
	
	public int indice(long codigoDaEncomenda);

	public void novaEncomenda(Encomenda enc);

	public Encomenda buscaEncomenda(long codigoDaEncomenda);

	public void atualizaEncomenda(Encomenda codigoDaEncomenda);
	
	public boolean removeEncomenda(long codigoDaEncomenda);
	
	public ArrayList<Encomenda> listaDeEncomendas();

}
