package crud;

import java.time.LocalDate;

public class Funcionario {

	private static int nextId = 1;
	private int id;
	private Pessoa pessoa;
	private String login;
	private String senha;

	public Funcionario(Pessoa pessoa, String login, String senha) {
		this.id = nextId;
		nextId++;

		this.pessoa = pessoa;
		this.login = login;
		this.senha = senha;
	}

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco end, String login,
			String senha) {
		this.id = nextId;
		nextId++;

		this.pessoa = new Pessoa(nome, cpf, dataNascimento, telefone, end);
		this.login = login;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public String toString() {

		String resultado;

		resultado = "Nome: " + this.pessoa.getNome() + "\nId: " + this.id;
		return resultado;
	}

	public boolean equals(Funcionario func) {

		if (func != null && this.pessoa.equals(func.pessoa) && this.login.equals(func.login)
				&& this.senha.equals(func.senha)) {
			return true;
		} else
			return false;
	}
	
	public Produto CadastraProduto(int pedido, String tipo, double peso, int codigo){
		Produto novoProduto = new Produto(pedido, tipo, peso, codigo);
		return novoProduto;
	}
	
	public void VisualizaProduto(Produto prod){
		System.out.println(prod.toString());
	}
}