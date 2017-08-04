package br.ufrpe.bugzilla.negocio;

import java.util.ArrayList;

import br.ufrpe.bugzilla.dao.IRepositorioLocal;
import br.ufrpe.bugzilla.dao.RepositorioLocal;
import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.exceptions.ObjectJaExisteException;
import br.ufrpe.exceptions.ObjectNaoExisteException;

public class ControladorLocal {

	private static ControladorLocal instance;
	private IRepositorioLocal repositorio;

	private ControladorLocal(){

		this.repositorio = RepositorioLocal.getinstance();
	}

	public static ControladorLocal getInstance(){

		if(instance == null){
			instance = new ControladorLocal();
		}
		return instance;
	}

	public void cadastrarLocal(Local l) throws ObjectJaExisteException {

		if(l!=null){
			if(this.repositorio.existe(l) == false){
				this.repositorio.cadastrarLocal(l);
			}
			else{
				throw new ObjectJaExisteException();
			}
		}
		else{
			throw new IllegalArgumentException("Inválido!");
		}

	}

	public Local procurarLocal(String nome) throws ObjectNaoExisteException {

		if(nome != null){
			return this.repositorio.procurarLocal(nome);
		}
		else{
			throw new IllegalArgumentException("Inválido!");
		}
	}

	public void atualizarLocal(Local l) throws ObjectNaoExisteException {

		if(l!=null){
			repositorio.atualizarLocal(l);
		}
		else{
			throw new IllegalArgumentException("Inválido!");
		}

	}

	public void removerLocal(String nome) throws ObjectNaoExisteException {

		if(nome!=null){
			repositorio.removerLocal(nome);
		}
		else{
			throw new IllegalArgumentException("Inválido!");
		}

	}

	public ArrayList<Local> listarLocais() {

		return this.repositorio.listarLocais();
	}

}
