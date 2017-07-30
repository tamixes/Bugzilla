package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import br.ufrpe.bugzilla.negocio.beans.Local;

public class RepositorioEncomenda {
	private ArrayList<Encomenda> encomenda = new ArrayList<Encomenda>();
	private static RepositorioEncomenda instance = new RepositorioEncomenda();

	private RepositorioEncomenda() {

	}

	public static RepositorioEncomenda getInstance() {
		return instance;
	}

	public int indice(long codigoDaEncomenda) {

		int i = 0;
		boolean encontrou = false;
		while ((encontrou != true) && (i < this.encomenda.size())) {
			if (codigoDaEncomenda == this.encomenda.get(i).getCodigo()) {
				encontrou = true;
			} else {
				i++;
			}
		}

		return i;
	}

	public void novaEncomenda(Encomenda enc) {
		this.encomenda.add(enc);
	}

	public Encomenda buscaEncomenda(long codigoDaEncomenda) {
		int i = this.indice(codigoDaEncomenda);

		Encomenda resultado = null;

		if (i != this.encomenda.size()) {
			resultado = this.encomenda.get(i);
		}
		return resultado;
	}

	public void atualizaEncomenda(Encomenda codigoDaEncomenda) {
		int i = this.indice(codigoDaEncomenda.getCodigo());
		
		if (i != this.encomenda.size()) {
			 codigoDaEncomenda = this.encomenda.get(i);
		}
	}
	
	public boolean removeEncomenda(long codigoDaEncomenda){
		int i = this.indice(codigoDaEncomenda);
		boolean apagou = false;
		if(i != this.encomenda.size()){
			this.encomenda.remove(i);
			apagou = true;
		}
		
		return apagou;
				
	}
	
	public ArrayList<Encomenda> listaDeEncomendas(){
		return this.encomenda;
	}
	
}
