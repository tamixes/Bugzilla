package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import br.ufrpe.exceptions.ObjectNaoExisteException;

public interface IRepositorioEncomenda {
	
	public int indice(String codigoDaEncomenda);

	public void novaEncomenda(Encomenda enc);

	public Encomenda buscaEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException;

	public void atualizaEncomenda(Encomenda codigoDaEncomenda) throws ObjectNaoExisteException;
	
	public boolean removeEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException;
	
	public ArrayList<Encomenda> listaDeEncomendas();
	
	public void defineTarifaBase(double tarifa);
	
	public boolean existe(Encomenda e);

}
