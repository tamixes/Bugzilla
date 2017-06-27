package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.*;

public class RepositorioLocal {
	
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
		
		if(procurarIndice(l.getNome()) >= 0){
			//...existe
		}
		else{
			locais.add(l);
		}
		
	}
	
	public Local procurarLocal(String nome){
		
		int indice = procurarIndice(nome);
		Local resultado = new Local();
		
		if(indice>=0){
			resultado = locais.get(indice);
		}
		else{
			//...
		}
		
		return resultado;
	}
	
	public void atualizarLocal(Local l){
		
		int indice = procurarIndice(l.getNome());
		
		if(indice>=0){
			
			locais.set(indice, l);
		}
		else{
			//...
		}
		
	}
	
	public void removerLocal(String nome){
		
		int indice = procurarIndice(nome);
		
		if(indice>=0){
			
			locais.remove(indice);
		}
		else{
			//...
		}
		
	}
	
	public int procurarIndice(String nome){
	
		int i = -1;
		
		for(int j=0;j<locais.size();j++){
			if(locais.get(j).getNome().equals(nome)){
				i = j;
			}
		}
		
		
		return i;
	}
	
	public ArrayList<Local> listarLocais(){
		return locais;
	}
	
	//TODO comparar dois locais para obter tarifa e tempo.

}
