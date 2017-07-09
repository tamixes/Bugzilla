package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.*;

public class RepositorioLocal implements IRepositorioLocal {
	
	private ArrayList<Local> locais;
	private Tarifa tarifa;
	private static RepositorioLocal instance;
	
	private RepositorioLocal(){
		
		locais = new ArrayList<Local>();
		tarifa = new Tarifa(2);
	}
	
	public static RepositorioLocal getinstance(){
		
		if(instance == null){
			instance = new RepositorioLocal();
		}
		
		return instance;
	}
	
	public void cadastrarLocal(Local l){
		
		if(procurarIndice(l.getNome()) >= 0){
			//...existe
		}
		else{
			locais.add(l);
		}
		
	}
	
	public Local procurarLocal(String nome){
		
		int indice = procurarIndice(nome);
		Local resultado = new Local();
		
		if(indice>=0){
			resultado = locais.get(indice);
		}
		else{
			//...
		}
		
		return resultado;
	}
	
	public void atualizarLocal(Local l){
		
		int indice = procurarIndice(l.getNome());
		
		if(indice>=0){
			
			locais.set(indice, l);
		}
		else{
			//...
		}
		
	}
	
	public void removerLocal(String nome){
		
		int indice = procurarIndice(nome);
		
		if(indice>=0){
			
			locais.remove(indice);
		}
		else{
			//...
		}
		
	}
	
	public boolean existe(Local l){
		
		boolean i = false;
		
		for(int j=0;j<locais.size();j++){
			if(locais.get(j).equals(l)){
				i = true;
			}
		}
		
		return i;
	}
	
	public int procurarIndice(String nome){
	
		int i = -1;
		
		for(int j=0;j<locais.size();j++){
			if(locais.get(j).getNome().equals(nome)){
				i = j;
			}
		}
		
		
		return i;
	}
	
	public ArrayList<Local> listarLocais(){
		return locais;
	}
	
	// Tarifa e Tempo
	
	public void defineTarifa(Tarifa t){
		
		this.tarifa = t;
	}
	
	public void atualizaTarifa(Tarifa t){
		
		this.tarifa = t;
	}
	
	public void atualizaTarifa(int preco, String entrega){
		
		this.tarifa = new Tarifa(preco,entrega);
	}
	
	public int getTarifa(Local l){
		int t=0;
		
		t = l.getLocalizacao() * this.tarifa.getPreco();
		
		return t;
	}
	
	public int getPrazo(Local l){
		int prazo=0;
		
		prazo = l.getLocalizacao() / this.tarifa.getTempo();
		
		return prazo;
	}
	
	public int getTarifaDois(Local l1, Local l2){
		int t=0;
		int distancia=0;
		
		distancia = Math.abs(l1.getLocalizacao() - l2.getLocalizacao());
		
		t = distancia * this.tarifa.getPreco();
		
		return t;
	}
	
	public int getPrazoDois(Local l1, Local l2){
		int prazo=0;
		int distancia=0;
		
		distancia = Math.abs(l1.getLocalizacao() - l2.getLocalizacao());
		prazo = distancia / this.tarifa.getTempo();
		
		return prazo;
	}
	

}
