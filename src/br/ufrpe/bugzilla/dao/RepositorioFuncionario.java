package br.ufrpe.bugzilla.dao;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.bugzilla.negocio.beans.Funcionario;

public class RepositorioFuncionario{
	
	private List<Funcionario> funcionario = new ArrayList<Funcionario>();
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
	
	public void cadastrarFuncionario(Funcionario func) {
		this.funcionario.add(func);
		
	}

	public Funcionario buscarFuncionario(String cpf) {
		Funcionario fun = null;
		int id = this.indice(cpf);
		if(id != -1){
			fun = this.funcionario.get(id);
		}
		return fun;
		
	}

	public void removerFuncionario(String cpf) {
		int id = this.indice(cpf);
		if(id != -1){
			this.funcionario.remove(id);
		}
		
	}

	public void alterarFuncionario(Funcionario func) {
		int id = this.indice(func.getCpf());
		if(id != -1){
			this.funcionario.set(id, func);
		}
		
		
	}

	public List<Funcionario> mostrarFuncio() {
	
		return this.funcionario;
	}

	
	

}
