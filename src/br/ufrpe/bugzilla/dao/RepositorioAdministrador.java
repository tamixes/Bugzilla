package br.ufrpe.bugzilla.dao;

import java.util.List;
import java.util.ArrayList;
import br.ufrpe.bugzilla.negocio.beans.Administrador;

public class RepositorioAdministrador{
	
	private List<Administrador> administrador = new ArrayList<Administrador>();
	private static RepositorioAdministrador instance; 
	
	private RepositorioAdministrador(){

		
	}

	public static RepositorioAdministrador getInstance(){
		
		if(instance == null){
			instance = new RepositorioAdministrador();
		}
		
		return instance;
	}
	
	public boolean existe(String cpf){
		boolean existe = false; 
		int id = this.indice(cpf);
		if(id != -1){
			existe = true;
		}
		return existe; 
	}
	
	private int indice(String cpf){
		
		int indice = -1;
		for(int i = 0; i<administrador.size(); i++){
			if(this.administrador.get(i).getCpf().equals(cpf)){
				indice = i;
			}
		}
		return indice;
	}

	
	public void cadastrarAdministrador(Administrador adm) {
		this.administrador.add(adm);
		
	}

	public Administrador buscaAdministrador(String cpf) {
		Administrador adm = null;
		int idc = this.indice(cpf);
		if(idc != -1){
			adm = this.administrador.get(idc);
		}
		
		return adm;
	}

	public void removerAdministrador(String cpf) {
		int idc = this.indice(cpf);
		if(idc != -1){
			this.administrador.remove(idc);
		}
	}

	public void alteraAdministrador(Administrador adm) {
		int idc = this.indice(adm.getCpf());
		if(idc != -1){
			this.administrador.set(idc, adm);
		}
		
	}
	

	public List<Administrador> listaAdministrador() {
		return this.administrador;
	}

	

	

}
