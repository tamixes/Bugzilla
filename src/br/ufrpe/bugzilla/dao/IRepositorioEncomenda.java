package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Encomenda;

public interface IRepositorioEncomenda {
	
	public int indice(String codigoDaEncomenda);

	public void novaEncomenda(Encomenda enc);

	public Encomenda buscaEncomenda(String codigoDaEncomenda);

	public void atualizaEncomenda(Encomenda codigoDaEncomenda);
	
	public boolean removeEncomenda(String codigoDaEncomenda);
	
	public ArrayList<Encomenda> listaDeEncomendas();

}
