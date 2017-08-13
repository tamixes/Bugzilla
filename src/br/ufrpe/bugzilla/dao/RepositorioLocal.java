package br.ufrpe.bugzilla.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.*;

public class RepositorioLocal implements IRepositorioLocal, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6264891378800798523L;
	private ArrayList<Local> locais;
	private static RepositorioLocal instance;
	
	private RepositorioLocal(){
		
		locais = new ArrayList<Local>();
	}
	
	public static RepositorioLocal getinstance(){
		
		if(instance == null){
			instance = RepositorioLocal.lerArquivo();
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
	
	// PERSISTÊNCIA DE DADOS
	
	
	private static RepositorioLocal lerArquivo(){
		RepositorioLocal instanciaLocal = null;
		
		File arquivo = new File("repositorioLocal.dat");
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			
			fis = new FileInputStream(arquivo);
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject();
			
			instanciaLocal = (RepositorioLocal) o;
			
		}catch(Exception e){
			instanciaLocal = new RepositorioLocal();
		}finally{
			
			if(ois!=null){
				try{
					ois.close();
					
				}catch(IOException e){
					
				}
			}
		}
		
		
		
		
		
		return instanciaLocal;
	}
	
	
	

	public void salvaArquivo() {

		if(instance==null){
			return;
		}
		
		File arquivo = new File("repositorioLocal.dat");
		FileOutputStream fos = null;
	    ObjectOutputStream oos = null;
	    
	    try{
	    	if(!arquivo.exists())
	    		arquivo.createNewFile();
	    	
	    	fos = new FileOutputStream(arquivo);
	    	oos = new ObjectOutputStream(fos);
	    	oos.writeObject(instance);
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }finally{
	    	if(oos!=null){
	    		
	    		try{
	    			oos.close();
	    		}catch(IOException e){
	    			
	    		}
	    	}
	    	
	    }		
	}

}
