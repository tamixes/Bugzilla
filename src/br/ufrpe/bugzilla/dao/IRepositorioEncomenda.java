package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;

public interface IRepositorioEncomenda {
	
	public int indice(String codigoDaEncomenda);

	public void novaEncomenda(Encomenda enc) throws ObjectJaExisteException;

	public Encomenda buscaEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException;

	public void atualizaEncomenda(Encomenda codigoDaEncomenda) throws ObjectNaoExisteException, ErroAoAtualizarException;
	
	public boolean removeEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException, ErroAoRemoverException;
	
	public ArrayList<Encomenda> listaDeEncomendas();
	
	public void defineTarifaBase(double tarifa);
	
	public boolean existe(Encomenda e);
	
	void salvaArquivo();

}
