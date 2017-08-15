package br.ufrpe.bugzilla.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.bugzilla.colecoes.TipoCliente;
import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.bugzilla.negocio.beans.Endereco;

public class RepositorioCliente implements IRepositorioCliente, Serializable{

	
	private static final long serialVersionUID = 5720207618632548503L;
	private ArrayList<Cliente> clientes;
	private static RepositorioCliente instance;
	
	private RepositorioCliente(){
		
		clientes = new ArrayList<Cliente>();
	}
	
	public static RepositorioCliente getInstance(){
		
		if(instance == null){
			instance = RepositorioCliente.lerArquivo();
		}
		return instance;
	}

	public void cadastrarCliente(Cliente cliente) {
		
		clientes.add(cliente);
	}

	public Cliente procurarCliente(String nome) throws ObjectNaoExisteException {
		
		int indice = procurarIndice(nome);
		Cliente resultado = new Cliente();
		
		if(indice>=0){
			resultado = clientes.get(indice);
		}
		else{
			throw new ObjectNaoExisteException();
		}
		
		return resultado;
	}
	
	public Cliente procurarCliente(int id) throws ObjectNaoExisteException {
		
		int i = -1;
		Cliente resultado = new Cliente();
		for (int j = 0; j < clientes.size(); j++) {
			if (clientes.get(j).getId() == id) {
				i = j;
			}
		}

		if(i >= 0) {
			resultado = clientes.get(i);
		}
		
		else {
			throw new ObjectNaoExisteException();
		}
		return resultado;
	}
	
	public void atualizarCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoAtualizarException{
		
		int indice = procurarIndice(cliente.getNome());
		
		if(indice>=0){
			
			clientes.set(indice, cliente);
		}
		else{
			throw new ErroAoAtualizarException();
		}
	}

	public void removerCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoRemoverException{
		
		int indice = procurarIndice(cliente.getId());
		
		if(indice>=0){
			
			clientes.remove(indice);
		}
		else{
			throw new ErroAoRemoverException();
		}
	}

	public ArrayList<Cliente> listarClientes() {
		
		return clientes;
	}

	public boolean existe(Cliente cliente) {

		boolean i = false;
		
		for(Cliente c : clientes){
			if(c.equals(cliente)){
				i = true;
			}
		}
		
		return i;
		
	}
	
	public int procurarIndice(String nome){
		
		int i = -1;
		
		for(int j=0;j<clientes.size();j++){
			if(clientes.get(j).getNome().equalsIgnoreCase(nome)){
				i = j;
			}
		}
		
		return i;
	}

	public int procurarIndice(int id) {
		int i = -1;
		for (int j = 0; j < clientes.size(); j++) {
			if (clientes.get(j).getId() == id) {
				i = j;
			}
		}
		return i;
		
	}
	
	public long contadorCliente() {
    	
    	long contador=0;
    	
    	for(Cliente c : clientes) {
    		if(c instanceof Cliente)
    			contador++;
    	}
    	
    	return contador;
    }
	
	
	// PERSISTÊNCIA DE DADOS
	
	
		private static RepositorioCliente lerArquivo(){
		RepositorioCliente instanciaLocal = null;
			
		File arquivo = new File("repositorioCliente.dat");
			
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			try{
				
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				
				Object o = ois.readObject();
				
				instanciaLocal = (RepositorioCliente) o;
				
			}catch(Exception e){
				instanciaLocal = new RepositorioCliente();
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
			
			File arquivo = new File("repositorioCliente.dat");
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
