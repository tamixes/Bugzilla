package br.ufrpe.bugzilla.negocio;

import java.util.ArrayList;

import br.ufrpe.bugzilla.dao.IRepositorioEncomenda;
import br.ufrpe.bugzilla.dao.RepositorioEncomenda;
import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;


public class ControladorEncomenda {
	private static ControladorEncomenda instance;
	private IRepositorioEncomenda repositorio;
	
	private ControladorEncomenda(){
		this.repositorio = RepositorioEncomenda.getInstance();
	}
	
	public static ControladorEncomenda getInstance(){
		if(instance == null){
			instance = new ControladorEncomenda();
		}
		return instance;
	}
	
	public void novaEncomenda(Encomenda encomenda) throws ObjectJaExisteException{
		
		if((encomenda == null)){
			
			throw new IllegalArgumentException("Inválido!");
		}
		else if(this.repositorio.existe(encomenda) == true){
			
			throw new ObjectJaExisteException();
		}
		else {
			repositorio.novaEncomenda(encomenda);
		}
	}
	
	public Encomenda buscaEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException{
		if(codigoDaEncomenda == null){
			
			throw new IllegalArgumentException("Inválido!");
		}
		else {
			
			return this.repositorio.buscaEncomenda(codigoDaEncomenda);
		}
		
	}
	
	public void atualizaEncomenda(Encomenda encomenda) throws ObjectNaoExisteException, ErroAoAtualizarException{
		
		if((encomenda == null) || (this.repositorio.buscaEncomenda(encomenda.getCodigo()) != null)){
			
			throw new IllegalArgumentException("Inválido!");
		}
		else{
			
			this.repositorio.atualizaEncomenda(encomenda);
		}
	}
	
	public void removeEncomenda(String codigoDaEncomenda) throws ObjectNaoExisteException, ErroAoRemoverException{
		if(codigoDaEncomenda != null){
			this.repositorio.removeEncomenda(codigoDaEncomenda);
		} else {
			throw new IllegalArgumentException("Inválido!");
		}
	}
	
	public ArrayList<Encomenda> listaDeEncomendas(){
		return this.repositorio.listaDeEncomendas();
	}
	
	public void defineTarifaBase(double tarifa){
		
		this.repositorio.defineTarifaBase(tarifa);
	}
	
	public long contadorEncomenda(){
		
		return this.repositorio.contadorEncomenda();
	}
}