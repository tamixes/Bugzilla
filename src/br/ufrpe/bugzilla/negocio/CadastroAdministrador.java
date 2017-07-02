package br.ufrpe.bugzilla.negocio;

import java.util.List;

import br.ufrpe.bugzilla.negocio.beans.*;
import br.ufrpe.bugzilla.dao.*;

public class CadastroAdministrador{
	
	private RepositorioAdministrador repositorio;
	private static CadastroAdministrador instance;
	
	private CadastroAdministrador(){
		this.repositorio = RepositorioAdministrador.getInstance();
	}
	
	public static CadastroAdministrador getInstance() {
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
		
			this.repositorio.alteraAdministrador(adm);
		}
	}
	public void removerAdminstrador(String cpf) {
		if(cpf != null){
			this.repositorio.removerAdministrador(cpf);
		}
		
	}
	public List<Administrador> listaAdministrador() {
		
		return this.repositorio.listaAdministrador();
	
	}
	
	public Administrador buscaAdministrador(String cpf) {
		Administrador resultado = null; 
		if(cpf != null){
			resultado = this.repositorio.buscaAdministrador(cpf);
		}
		return resultado; 
	}

	public boolean verificaLogin(Login login){
		boolean resultado = false;
		
		if(login != null)
			resultado = this.repositorio.verificaLogin(login);
		
		return resultado;
	}

}
