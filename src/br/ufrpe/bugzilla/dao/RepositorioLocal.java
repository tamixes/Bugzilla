package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.*;

public class RepositorioLocal implements IRepositorioLocal {
	
	private ArrayList<Local> locais;
	private static RepositorioLocal instance;
	
	private RepositorioLocal(){
		
		locais = new ArrayList<Local>();
	}
	
	public static RepositorioLocal getinstance(){
		
		if(instance == null){
			instance = new RepositorioLocal();
		}
		
		return instance;
	}
	
	public void cadastrarLocal(Local l){
		
		locais.add(l);
	}
	
	public Local procurarLocal(String nome) throws ObjectNaoExisteException{
		
		int indice = procurarIndice(nome);
		Local resultado = new Local();
		
		if(indice>=0){
			resultado = locais.get(indice);
		}
		else{
			throw new ObjectNaoExisteException();
		}
		
		return resultado;
	}
	
	public void atualizarLocal(Local l) throws ObjectNaoExisteException, ErroAoAtualizarException{
		
		int indice = procurarIndice(l.getNome());
		
		if(indice>=0){
			
			locais.set(indice, l);
		}
		else{
			throw new ErroAoAtualizarException();
		}
		
	}
	
	public void removerLocal(String nome) throws ObjectNaoExisteException, ErroAoRemoverException{
		
		int indice = procurarIndice(nome);
		
		if(indice>=0){
			
			locais.remove(indice);
		}
		else{
			throw new ErroAoRemoverException();
		}
		
	}
	
	public boolean existe(Local l){
		
		boolean i = false;
		
		for(Local c : locais){
			if(c.equals(l)){
				i = true;
			}
		}
		
		return i;
	}
	
	public int procurarIndice(String nome){
	
		int i = -1;
		
		for(int j=0;j<locais.size();j++){
			if(locais.get(j).getNome().equalsIgnoreCase(nome)){
				i = j;
			}
		}
		
		
		return i;
	}
	
	public ArrayList<Local> listarLocais(){
		return locais;
	}

}
