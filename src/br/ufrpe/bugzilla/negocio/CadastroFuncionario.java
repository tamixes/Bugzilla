package br.ufrpe.bugzilla.negocio;
import java.util.List;

import br.ufrpe.bugzilla.negocio.beans.*;
import br.ufrpe.bugzilla.dao.*;
import br.ufrpe.exceptions.*;
public class CadastroFuncionario{

	private static CadastroFuncionario instance;
	private RepositorioFuncionario repositorio;
	
	private CadastroFuncionario(){
		this.repositorio = RepositorioFuncionario.getInstance();
	}
	
	public static CadastroFuncionario getInstance() {
		if(instance == null){
			instance = new CadastroFuncionario();
		}
		return instance; 
	}
	
	/*if(func != null){
		boolean existe = this.repositorio.existe(func.getCpf());
		if(existe != true){
			this.repositorio.cadastrarFuncionario(func);
		}
	*/
	
	public void cadastrarFuncionario(Funcionario func) throws ObjectJaExisteException{
		if(func == null){
			throw new IllegalArgumentException("Inválido!");
		}else{
			try {
				boolean buscado = repositorio.existe(func.getCpf());
				if(buscado != false){
					throw new ObjectJaExisteException();
				}
			} catch (Exception e) {
				this.repositorio.cadastrarFuncionario(func);
			}
		}
	}
		
	

	public Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException{
		Funcionario resultado = null; 
		if(cpf != null){
			resultado = this.repositorio.buscarFuncionario(cpf);
		}
		return resultado; 
	}

	public void removerFuncionario(Funcionario func) throws ErroAoRemoverException{
		if(func != null){
			if(this.repositorio.existe(func.getCpf()) != false){
				this.repositorio.removerFuncionario(func.getCpf());
			}
		}
		
	}

	public void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException{
		if(func != null){
			if(this.repositorio.existe(func.getCpf()) != false){
				this.repositorio.alterarFuncionario(func);
			}
		}
		
	}

	public List<Funcionario> mostrarfunc() {
		return this.repositorio.mostrarFuncio();
	}

	public boolean login(String login, String senha) {
		Usuario usuario = new Usuario(login, senha);
		boolean resultado = false;
		if(this.repositorio.checarLogin(usuario)){
			resultado = true;
		}
		return resultado;
	}

	
}
