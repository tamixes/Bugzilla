package br.ufrpe.bugzilla.negocio;

import java.util.List;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;


public interface ICadastroFuncionario {
	
	void cadastrarFuncionario(Funcionario func);
	Funcionario buscarFuncionario(String cpf);
	void removerFuncionario(Funcionario func);
	void alterarFuncionario(Funcionario func);
	public List<Funcionario> mostrarfunc();
	CadastroFuncionario getInstance();
}
