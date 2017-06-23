package br.ufrpe.bugzilla.negocio;

import java.util.List;

import br.ufrpe.bugzilla.negocio.beans.*;
import br.ufrpe.bugzilla.dao.*;

public class CadastroAdministrador implements ICadastroAdministrador{
	
	private ICadastroAdministrador repositorio;
	private CadastroAdministrador instance;
	
	private CadastroAdministrador(){
		repositorio.getInstance();
	}
	
	public CadastroAdministrador getInstance() {
		if(instance == null){
			instance = new CadastroAdministrador();
		}

		return instance;
	}
	
	public void cadastrarAdministrador(Administrador adm) {
		if(adm != null){
			this.repositorio.cadastrarAdministrador(adm);
		}
		
	}
	
	public void alterarAdministrador(Administrador adm) {
		if(adm != null){
		
			this.repositorio.alterarAdministrador(adm);
		}
	}
	public void removerAdminstrador(Administrador adm) {
		if(adm != null){
			this.repositorio.removerAdminstrador(adm);
		}
		
	}
	public List<Administrador> mostraAdministrador() {
		
		return this.repositorio.mostraAdministrador();
	
	}
	
	public Administrador buscaAdministrador(String cpf) {
		Administrador resultado = null; 
		if(cpf != null){
			resultado = this.repositorio.buscaAdministrador(cpf);
		}
		return resultado; 
	}


	
	
	
	
	
	
	
}
