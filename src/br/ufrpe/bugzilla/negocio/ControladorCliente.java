package br.ufrpe.bugzilla.negocio;

import java.util.ArrayList;

import br.ufrpe.bugzilla.dao.IRepositorioCliente;
import br.ufrpe.bugzilla.dao.RepositorioCliente;
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
	
	public void cadastrarCliente(Cliente cliente){
		
		if (cliente == null) {
            throw new IllegalArgumentException("Parâmetro inválido");
		}
        else{
        	repositorio.cadastrarCliente(cliente);
        }
         	
	}
	
	public void removerLocal(String nome){
		
		if(nome!=null){
			repositorio.removerCliente(nome);
		}
		
	}
	
	public Cliente procurarCliente(String nome){

		if(nome != null){
			return this.repositorio.procurarCliente(nome);
		}
		else{
			return null;
		}
	}

	public void atualizarCliente(Cliente cliente){
			
		if(cliente!=null){
			repositorio.atualizarCliente(cliente);
		}
			
	}

	public void removerCliente(String nome){

		if(nome!=null){
			repositorio.removerCliente(nome);
		}
			
	}

	public ArrayList<Cliente> listarClientes() {

		return this.repositorio.listarClientes();
	}

}
