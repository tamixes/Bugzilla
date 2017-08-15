package br.ufrpe.bugzilla.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import br.ufrpe.bugzilla.negocio.beans.Usuario;

import java.util.List;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario, Serializable{
	
	private static final long serialVersionUID = -6109366189477609681L;
	private ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
	private static RepositorioFuncionario instance; 
	
	public static RepositorioFuncionario getInstance() {
		if(instance == null ){
			instance = RepositorioFuncionario.lerArquivo();
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
	
	public boolean checarLoginADM(Usuario u) {
		boolean resultado = false;
		for(int i=0; i<funcionario.size(); i++){
				if (this.funcionario.get(i).getUsuario().equals(u) && this.funcionario.get(i).isAdm()) {
					resultado =  true;
				}
			}
		
		return resultado;
	}
	
	public long contadorFuncionario() {
    	
    	long contador=0;
    	
    	for(Funcionario f : funcionario) {
    		if(f instanceof Funcionario)
    			contador++;
    	}
    	
    	return contador;
    }
	
	// PERSISTÊNCIA DE DADOS
	
	
		private static RepositorioFuncionario lerArquivo(){
		RepositorioFuncionario instanciaLocal = null;
			
		File arquivo = new File("repositorioFuncionario.dat");
			
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			
			try{
				
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				
				Object o = ois.readObject();
				
				instanciaLocal = (RepositorioFuncionario) o;
				
			}catch(Exception e){
				instanciaLocal = new RepositorioFuncionario();
			}finally{
				
				if(ois!=null){
					try{
						ois.close();
						
					}catch(IOException e){
						
					}
				}
			}			
			
			return instanciaLocal;
		}
		
		
		
	
		public void salvaArquivo() {
	
			if(instance==null){
				return;
			}
			
			File arquivo = new File("repositorioFuncionario.dat");
			FileOutputStream fos = null;
		    ObjectOutputStream oos = null;
		    
		    try{
		    	if(!arquivo.exists())
		    		arquivo.createNewFile();
		    	
		    	fos = new FileOutputStream(arquivo);
		    	oos = new ObjectOutputStream(fos);
		    	oos.writeObject(instance);
		    }catch(Exception e){
		    	e.printStackTrace();
		    	
		    }finally{
		    	if(oos!=null){
		    		
		    		try{
		    			oos.close();
		    		}catch(IOException e){
		    			
		    		}
		    	}
		    	
		    }		
		}
	
	
	
}
