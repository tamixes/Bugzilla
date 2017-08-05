package br.ufrpe.bugzilla.negocio;

import java.util.List;

import br.ufrpe.bugzilla.negocio.beans.*;
import br.ufrpe.bugzilla.dao.*;
import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;

public class CadastroAdministrador{
	
	private IRepositorioAdministrador repositorio;
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
	
		
	
	public void cadastrarAdministrador(Administrador adm) throws ObjectJaExisteException{
		if(adm == null){
			throw new IllegalArgumentException("Inválido!");
		}else{
			try {
				boolean buscado = repositorio.existe(adm.getCpf());
				if(buscado != false){
					throw new ObjectJaExisteException();
				}
			} catch (Exception e) {
				this.repositorio.cadastrarAdministrador(adm);
			}
		}
		
	}
	
	public void alterarAdministrador(Administrador adm) throws ErroAoAtualizarException{
		if(adm != null){
		
			this.repositorio.alteraAdministrador(adm);
		}
	}
	public void removerAdminstrador(String cpf) throws ErroAoRemoverException{
		if(cpf != null){
			this.repositorio.removerAdministrador(cpf);
		}
		
	}
	public List<Administrador> listaAdministrador() {
		
		return this.repositorio.listaAdministrador();
	
	}
	
	public Administrador buscaAdministrador(String cpf) throws ObjectNaoExisteException{
		Administrador resultado = null; 
		if(cpf != null){
			resultado = this.repositorio.buscaAdministrador(cpf);
		}
		return resultado; 
	}

	public boolean verificaLogin(Usuario usuario){
		boolean resultado = false;
		
		if(usuario != null)
			resultado = this.repositorio.verificaLogin(usuario);
		
		return resultado;
	}

}
