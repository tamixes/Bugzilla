package br.ufrpe.bugzilla.dao;

import java.util.List;
import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Administrador;
import br.ufrpe.bugzilla.negocio.beans.Usuario;

public class RepositorioAdministrador implements IRepositorioAdministrador{
	
	private List<Administrador> administrador = new ArrayList<Administrador>();
	private static RepositorioAdministrador instance; 
	
	private RepositorioAdministrador(){}

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

	
	public void cadastrarAdministrador(Administrador adm) throws ObjectJaExisteException {
		this.administrador.add(adm);
		
	}

	public Administrador buscaAdministrador(String cpf) throws ObjectNaoExisteException{
		Administrador adm = null;
		int idc = this.indice(cpf);
		if(idc != -1){
			adm = this.administrador.get(idc);
		}
		else{
			throw new ObjectNaoExisteException();
		}
		
		return adm;
	}

	public void removerAdministrador(String cpf) throws ErroAoRemoverException {
		int idc = this.indice(cpf);
		if(idc != -1){
			this.administrador.remove(idc);
		}
		else{
			throw new ErroAoRemoverException();
		}
	}

	public void alteraAdministrador(Administrador adm) throws ErroAoAtualizarException{
		int idc = this.indice(adm.getCpf());
		if(idc != -1){
			this.administrador.set(idc, adm);
		}
		else{
			throw new ErroAoAtualizarException();
		}
	}
	
	public boolean verificaLogin(Usuario usuario){
		boolean resultado = false; 
		for(int i = 0; i<this.administrador.size(); i++){
			if(usuario.equals(this.administrador.get(i).getUsuario())){
				resultado = true;
			}
		}
		return resultado;
	}

	public List<Administrador> listaAdministrador() {
		return this.administrador;
	}

}
