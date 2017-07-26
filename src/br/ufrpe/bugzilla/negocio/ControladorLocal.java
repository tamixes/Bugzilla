package br.ufrpe.bugzilla.negocio;

import java.util.ArrayList;

import br.ufrpe.bugzilla.dao.IRepositorioLocal;
import br.ufrpe.bugzilla.dao.RepositorioLocal;
import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.bugzilla.negocio.beans.Tarifa;
import br.ufrpe.exceptions.LocalExisteException;
import br.ufrpe.exceptions.LocalNaoEncontradoException;

public class ControladorLocal {

	private static ControladorLocal instance;
	private IRepositorioLocal repositorio;
	
	private ControladorLocal(){
		
		this.repositorio = RepositorioLocal.getinstance();
	}
	
	public static ControladorLocal getInstance(){
		
		if(instance == null){
			instance = new ControladorLocal();
		}
		return instance;
	}

	public void cadastrarLocal(Local l) throws LocalExisteException {

		if(l!=null){
			if(this.repositorio.existe(l) == false){
				this.repositorio.cadastrarLocal(l);
			}
			else{
				throw new LocalExisteException(l.getNome());
			}
		}
		else{
			//exception
		}
		
	}

	public Local procurarLocal(String nome) throws LocalNaoEncontradoException {

		if(nome != null){
			return this.repositorio.procurarLocal(nome);
		}
		else{
			return null;
		}
	}

	public void atualizarLocal(Local l) throws LocalNaoEncontradoException {
		
		if(l!=null){
			repositorio.atualizarLocal(l);
		}
		
	}

	public void removerLocal(String nome) throws LocalNaoEncontradoException {

		if(nome!=null){
			repositorio.removerLocal(nome);
		}
		
	}

	public ArrayList<Local> listarLocais() {

		return this.repositorio.listarLocais();
	}

	public void defineTarifa(Tarifa t) {

		if(t!=null){
			this.repositorio.defineTarifa(t);
		}
		
	}

	public void atualizaTarifa(Tarifa t) {
		
		if(t!=null){
			this.repositorio.atualizaTarifa(t);
		}
		
	}

	public void atualizaTarifa(int preco, String entrega) {

		this.atualizaTarifa(new Tarifa(preco,entrega));
	}

	public int getTarifa(Local l) {
		int t=0;
		
		if(l!=null){
			t = this.repositorio.getTarifa(l);
		}
		return t;
	}

	public int getPrazo(Local l) {
		int p=0;
		
		if(l!=null){
			p = this.repositorio.getPrazo(l);
		}
		return p;
	}

	public int getTarifaDois(Local l1, Local l2) {
		int t=0;
		
		if(l1!=null && l2!=null){
			t = this.repositorio.getTarifaDois(l1, l2);
		}
		return t;
	}

	public int getPrazoDois(Local l1, Local l2) {
		int p=0;
		
		if(l1!=null && l2!=null){
			p = this.repositorio.getPrazoDois(l1, l2);
		}
		return p;
	}
	
}
