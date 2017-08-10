package br.ufrpe.bugzilla.dao;
import java.util.ArrayList;
import br.ufrpe.bugzilla.negocio.beans.Usuario;

import java.util.List;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario{
	
	private ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
	private static RepositorioFuncionario instance; 
	
	public static RepositorioFuncionario getInstance() {
		if(instance == null ){
			instance = new RepositorioFuncionario();
		}
		return instance;
	}
	
	private int indice(String cpf){
		int indice = -1;
		for(int i = 0; i<funcionario.size(); i++){
			if(this.funcionario.get(i).getCpf().equals(cpf)){
				indice = i;
			}
		}
		return indice;
	}
	public boolean existe(String cpf){
		boolean existe = false; 
		int id = this.indice(cpf);
		if(id != -1){
			existe = true;
		}
		return existe; 
	}
	
	public void cadastrarFuncionario(Funcionario func) throws ObjectJaExisteException  {
		this.funcionario.add(func);
		}
	

	public Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException {
		Funcionario fun = null;
		int id = this.indice(cpf);
		if(id != -1){
			fun = this.funcionario.get(id);
		}
		else{
			throw new ObjectNaoExisteException();
		}
		return fun;
		
	}

	public void removerFuncionario(String cpf) throws ErroAoRemoverException {
		int id = this.indice(cpf);
		if(id != -1){
			this.funcionario.remove(id);
		}
		else{
			throw new ErroAoRemoverException();
		}
		
	}

	public void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException{
		int id = this.indice(func.getCpf());
		if(id != -1){
			this.funcionario.set(id, func);
		}
		else{
			throw new ErroAoAtualizarException();
		}
		
		
	}

	public List<Funcionario> mostrarFuncio() {
	
		return this.funcionario;
	}

	public boolean checarLogin(Usuario u) {
		boolean resultado = false;
		for(int i = 0; i < funcionario.size();i++){
			if(this.funcionario.get(i) instanceof Funcionario){
				if (((Funcionario) this.funcionario.get(i)).getUsuario().equals(u)) {
					resultado =  true;
				}
			}
		}
		return resultado;
	
	}
}
