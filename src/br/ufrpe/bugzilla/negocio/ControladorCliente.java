package br.ufrpe.bugzilla.negocio;

import java.util.ArrayList;

import br.ufrpe.bugzilla.dao.IRepositorioCliente;
import br.ufrpe.bugzilla.dao.RepositorioCliente;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Cliente;

public class ControladorCliente {
	
	private static ControladorCliente instance;
	private IRepositorioCliente repositorio;
	
	private ControladorCliente(){
		this.repositorio = RepositorioCliente.getInstance();
	}
	
	public static ControladorCliente getInstance(){
		
		if(instance == null){
			instance = new ControladorCliente();
		}
		return instance;
	}
	
	public void cadastrarCliente(Cliente cliente) throws ObjectJaExisteException{
		
		if (cliente == null) {
            throw new IllegalArgumentException("Par�metro inv�lido");
		}
		else if(this.repositorio.existe(cliente)){
			throw new ObjectJaExisteException();
		}
        else{
        	repositorio.cadastrarCliente(cliente);
        }
         	
	}
	
	public void removerLocal(String nome) throws ObjectNaoExisteException{
		
		if(nome!=null){
			repositorio.removerCliente(nome);
		}
		else{
			throw new IllegalArgumentException("Par�metro inv�lido");
		}
		
	}
	
	public Cliente procurarCliente(String nome) throws ObjectNaoExisteException{

		if(nome != null){
			return this.repositorio.procurarCliente(nome);
		}
		else{
			throw new IllegalArgumentException("Par�metro inv�lido");
		}
	}

	public void atualizarCliente(Cliente cliente) throws ObjectNaoExisteException{
			
		if(cliente!=null){
			repositorio.atualizarCliente(cliente);
		}
		else{
			throw new IllegalArgumentException("Par�metro inv�lido");
		}
			
	}

	public void removerCliente(String nome) throws ObjectNaoExisteException{

		if(nome!=null){
			repositorio.removerCliente(nome);
		}
		else{
			throw new IllegalArgumentException("Par�metro inv�lido");
		}
			
	}
	
	public boolean existe(Cliente cliente){
		if(cliente==null){
			throw new IllegalArgumentException("Inv�lido!");
		}
		else{
			return this.repositorio.existe(cliente);
		}
	}

	public ArrayList<Cliente> listarClientes() {

		return this.repositorio.listarClientes();
	}

}
