package br.ufrpe.bugzilla.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;

public class RepositorioEncomenda implements IRepositorioEncomenda, Serializable{
	
	private static final long serialVersionUID = 5938245483505711821L;
	private ArrayList<Encomenda> encomendas = new ArrayList<Encomenda>();
	private static RepositorioEncomenda instance;

	private RepositorioEncomenda() {

	}

	public static RepositorioEncomenda getInstance() {
		if(instance==null){
			instance = RepositorioEncomenda.lerArquivo();
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
	
	public boolean removeEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException, ErroAoRemoverException {
		int i = this.indice(codigoDaEncomenda);
		boolean apagou = false;
		if(i != this.encomendas.size()){
			this.encomendas.remove(i);
			apagou = true;
		}
		else{
			throw new ErroAoRemoverException();
		}
		
		return apagou;
				
	}
	
	public ArrayList<Encomenda> listaDeEncomendas(){
		return this.encomendas;
	}
	
	public void defineTarifaBase(double tarifa){
		
		Encomenda.setTarifaBase(tarifa);
	}
	
	// PERSISTÊNCIA DE DADOS
	
	
	private static RepositorioEncomenda lerArquivo(){
		RepositorioEncomenda instanciaLocal = null;
			
		File arquivo = new File("repositorioEncomenda.dat");
			
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			try{
				
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				
				Object o = ois.readObject();
				
				instanciaLocal = (RepositorioEncomenda) o;
				
			}catch(Exception e){
				instanciaLocal = new RepositorioEncomenda();
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
			
			File arquivo = new File("repositorioEncomenda.dat");
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
