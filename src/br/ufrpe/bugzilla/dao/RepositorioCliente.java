package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.exceptions.ObjectNaoExisteException;

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

	public void atualizarCliente(Cliente cliente) {
		
		int indice = procurarIndice(cliente.getNomeEmpresa());
		
		if(indice>=0){
			
			clientes.set(indice, cliente);
		}
		else{
			//throw new
		}
	}

	public void removerCliente(String nome) {
		
		int indice = procurarIndice(nome);
		
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
			if(clientes.get(j).getNomeEmpresa().equalsIgnoreCase(nome)){
				i = j;
			}
		}
		
		return i;
	}
	
}
