package br.ufrpe.bugzilla.negocio;

import java.util.ArrayList;

import br.ufrpe.bugzilla.dao.IRepositorioLocal;
import br.ufrpe.bugzilla.dao.RepositorioLocal;
import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.exceptions.LocalExisteException;
import br.ufrpe.exceptions.LocalNaoEncontradoException;

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

	public void cadastrarLocal(Local l) throws LocalExisteException {

		if(l!=null){
			if(this.repositorio.existe(l) == false){
				this.repositorio.cadastrarLocal(l);
			}
			else{
				throw new LocalExisteException(l.getNome());
			}
		}
		else{
			throw new IllegalArgumentException("Inválido!");
		}

	}

	public Local procurarLocal(String nome) throws LocalNaoEncontradoException {

		if(nome != null){
			return this.repositorio.procurarLocal(nome);
		}
		else{
			return null;
		}
	}

	public void atualizarLocal(Local l) throws LocalNaoEncontradoException {

		if(l!=null){
			repositorio.atualizarLocal(l);
		}

	}

	public void removerLocal(String nome) throws LocalNaoEncontradoException {

		if(nome!=null){
			repositorio.removerLocal(nome);
		}

	}

	public ArrayList<Local> listarLocais() {

		return this.repositorio.listarLocais();
	}

}
