package br.ufrpe.bugzilla.negocio;

import java.util.ArrayList;

import br.ufrpe.bugzilla.dao.RepositorioEncomenda;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;


public class ControladorEncomenda {
	private static ControladorEncomenda instance;
	private RepositorioEncomenda repositorio;
	
	private ControladorEncomenda(){
		this.repositorio = RepositorioEncomenda.getInstance();
	}
	
	public static ControladorEncomenda getInstance(){
		if(instance == null){
			instance = new ControladorEncomenda();
		}
		return instance;
	}
	
	public void novaEncomenda(Encomenda encomenda){
		
		if((encomenda == null) || (this.repositorio.buscaEncomenda(encomenda.getCodigo()) != null)){
			if (encomenda == null)
				System.out.println("Não é possivel cadastrar essa encomenda!");

			else if (this.repositorio.buscaEncomenda(encomenda.getCodigo()) != null) {
				System.out.println("Essa encomenda já existe!");
			}
		} else {
			repositorio.novaEncomenda(encomenda);
			System.out.println("Encomenda Cadastrada com sucesso!");
		}
	}
	
	public Encomenda buscaEncomenda(long codigoDaEncomenda){
		if(this.repositorio.buscaEncomenda(codigoDaEncomenda) != null){
			return this.repositorio.buscaEncomenda(codigoDaEncomenda);
		} else {
			System.out.println("Não existe alguma encomenda com o numero" + codigoDaEncomenda);
			return this.repositorio.buscaEncomenda(codigoDaEncomenda);
		}
		
	}
	
	public void atualizaEncomenda(Encomenda encomenda){
		if((encomenda == null) || (this.repositorio.buscaEncomenda(encomenda.getCodigo()) != null)){
			if (encomenda == null)
				System.out.println("Não é possivel cadastrar essa encomenda!");

			else if (this.repositorio.buscaEncomenda(encomenda.getCodigo()) != null) {
				this.repositorio.atualizaEncomenda(encomenda);
				System.out.println("Dados da encomenda atualizados!");
			}
		}
	}
	
	public void removeEncomenda(long codigoDaEncommenda){
		if(this.repositorio.removeEncomenda(codigoDaEncommenda) == true){
			System.out.println("Registro de encomenda removido com sucesso");
		} else {
			System.out.println("Código de encomenda inválido!");
		}
	}
	
	public ArrayList<Encomenda> listaDeEncomendas(){
		return this.repositorio.listaDeEncomendas();
	}
}
