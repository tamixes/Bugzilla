package br.ufrpe.bugzilla.negocio;

import java.util.ArrayList;

import br.ufrpe.bugzilla.dao.IRepositorioCliente;
import br.ufrpe.bugzilla.dao.RepositorioCliente;
import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
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
            throw new IllegalArgumentException("Parâmetro inválido");
		}
		else if(this.repositorio.existe(cliente)){
			throw new ObjectJaExisteException();
		}
        else{
        	repositorio.cadastrarCliente(cliente);
        }
         	
	}
	
//	public void removerLocal(String nome) throws ObjectNaoExisteException{
//		
//		if(nome!=null){
//			repositorio.removerCliente(nome);
//		}
//		else{
//			throw new IllegalArgumentException("Parâmetro inválido");
//		}
//		
//	}
	
	public Cliente procurarCliente(String nome) throws ObjectNaoExisteException{

		if(nome != null){
			return this.repositorio.procurarCliente(nome);
		}
		else{
			throw new IllegalArgumentException("Parâmetro inválido");
		}
	}
	
	public Cliente procurarCliente(int id) throws ObjectNaoExisteException{
		Cliente resultado = new Cliente();
		
		try {
			resultado = this.repositorio.procurarCliente(id);
		}
		catch(ObjectNaoExisteException e){
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		
		return resultado;
	}

	public void atualizarCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoAtualizarException{
			
		if(cliente!=null){
			repositorio.atualizarCliente(cliente);
		}
		else{
			throw new IllegalArgumentException("Parâmetro inválido");
		}
			
	}

	public void removerCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoRemoverException{

		if(cliente!=null){
			repositorio.removerCliente(cliente);
		}
		else{
			throw new IllegalArgumentException("Parâmetro inválido");
		}
			
	}
	
	public boolean existe(Cliente cliente){
		if(cliente==null){
			throw new IllegalArgumentException("Inválido!");
		}
		else{
			return this.repositorio.existe(cliente);
		}
	}

	public ArrayList<Cliente> listarClientes() {

		return this.repositorio.listarClientes();
	}

}
