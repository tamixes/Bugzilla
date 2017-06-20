package old;

import br.ufrpe.bugzilla.negocio.beans.Pessoa;

public class Administrador {
	
	private Pessoa pessoa;
	private Funcionario funcionarios[] = new Funcionario[100];
	private int proxima = 0;
	private int id; 
	private String login; 
	private String senha;
	
	public Administrador(Pessoa pessoa, int id, String login, String senha) {
		this.pessoa = pessoa;
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void criaFuncionario(Funcionario func){
		
		this.funcionarios[this.proxima] = func;
        this.proxima = this.proxima + 1;
	}

	public boolean equals(Administrador outro){
		boolean resultado = false; 
		
		if(outro != null && this.login != null){
			resultado =  this.id == outro.getId()
						&& this.login.equals(outro.getLogin())
						&& this.senha.equals(outro.getSenha());
		}
		
		return resultado; 
	}

	public String toString() {
		return "Administrador [pessoa=" + pessoa + ", id=" + id + ", login=" + login + "]";
	}
	
	
}
