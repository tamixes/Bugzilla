package br.ufrpe.bugzilla.negocio;
import java.util.List;

import br.ufrpe.bugzilla.negocio.beans.*;
import br.ufrpe.bugzilla.dao.*;
import br.ufrpe.bugzilla.exceptions.*;
public class CadastroFuncionario{

	private static CadastroFuncionario instance;
	private IRepositorioFuncionario repositorio;
	
	private CadastroFuncionario(){
		this.repositorio = RepositorioFuncionario.getInstance();
	}
	
	public static CadastroFuncionario getInstance() {
		if(instance == null){
			instance = new CadastroFuncionario();
		}
		return instance; 
	}
	
	public void cadastrarFuncionario(Funcionario func) throws ObjectJaExisteException{
		if(func == null){
			throw new IllegalArgumentException("Inválido!");
		}
		else if(repositorio.existe(func.getCpf())){
			throw new ObjectJaExisteException();
		}
		else{
			this.repositorio.cadastrarFuncionario(func);
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
	
	public long contadorFuncionario(){
		return this.repositorio.contadorFuncionario();
	}

	public boolean login(String login, String senha) {
		Usuario usuario = new Usuario(login, senha);
		boolean resultado = false;
		if(this.repositorio.checarLogin(usuario)){
			resultado = true;
		}
		return resultado;
	}
	
	public boolean loginADM(Usuario usuario) {
		
		return this.repositorio.checarLoginADM(usuario);
	}
	
	public boolean existe(String cpf){
		if(cpf==null){
			throw new IllegalArgumentException("Inválido!");
		}
		else{
			return this.repositorio.existe(cpf);
		}
	}

}