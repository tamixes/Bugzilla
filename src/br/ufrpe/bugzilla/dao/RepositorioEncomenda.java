package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;

public class RepositorioEncomenda implements IRepositorioEncomenda{
	private ArrayList<Encomenda> encomendas = new ArrayList<Encomenda>();
	private static RepositorioEncomenda instance;

	private RepositorioEncomenda() {

	}

	public static RepositorioEncomenda getInstance() {
		if(instance==null){
			instance = new RepositorioEncomenda();
		}
		return instance;
	}

	public int indice(String codigoDaEncomenda) {

		int i = 0;
		boolean encontrou = false;
		while ((encontrou != true) && (i < this.encomendas.size())) {
			if (this.encomendas.get(i).getCodigo().equalsIgnoreCase(codigoDaEncomenda)) {
				encontrou = true;
			} else {
				i++;
			}
		}

		return i;
	}
	
	public boolean existe(Encomenda e){
		
		boolean encontrou = false;
		for(int i = 0; i<encomendas.size(); i++) {
			if (this.encomendas.get(i).getCodigo().equalsIgnoreCase(e.getCodigo())) {
				encontrou = true;
			}
		}

		return encontrou;
			
	}

	public void novaEncomenda(Encomenda enc) {
		this.encomendas.add(enc);
	}

	public Encomenda buscaEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException {
		int i = this.indice(codigoDaEncomenda);

		Encomenda resultado = null;

		if (i != this.encomendas.size()) {
			resultado = this.encomendas.get(i);
			return resultado;
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}

	public void atualizaEncomenda(Encomenda encomenda) throws ObjectNaoExisteException {
		int i = this.indice(encomenda.getCodigo());
		
		if (i != this.encomendas.size()) {
			this.encomendas.set(i, encomenda);
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
	
	public boolean removeEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException {
		int i = this.indice(codigoDaEncomenda);
		boolean apagou = false;
		if(i != this.encomendas.size()){
			this.encomendas.remove(i);
			apagou = true;
		}
		
		return apagou;
				
	}
	
	public ArrayList<Encomenda> listaDeEncomendas(){
		return this.encomendas;
	}
	
	public void defineTarifaBase(double tarifa){
		
		Encomenda.setTarifaBase(tarifa);
	}
	
}
