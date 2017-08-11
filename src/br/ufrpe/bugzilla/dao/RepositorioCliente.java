package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Cliente;

public class RepositorioCliente implements IRepositorioCliente{

	private ArrayList<Cliente> clientes;
	private static RepositorioCliente instance;
	
	private RepositorioCliente(){
		
		clientes = new ArrayList<Cliente>();
	}
	
	public static RepositorioCliente getInstance(){
		
		if(instance == null){
			instance = new RepositorioCliente();
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

		if(i >= clientes.size()) {
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
			//throw new
		}
	}

	public void removerCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoRemoverException{
		
		int indice = procurarIndice(cliente.getId());
		
		if(indice>=0){
			
			clientes.remove(indice);
		}
		else{
			//throw new 
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

	
}
