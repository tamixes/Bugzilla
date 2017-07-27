package br.ufrpe.bugzilla.negocio;

import java.util.List;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.exceptions.ErroAoAtualizarException;
import br.ufrpe.exceptions.ErroAoRemoverException;
import br.ufrpe.exceptions.ObjectJaExisteException;
import br.ufrpe.exceptions.ObjectNaoExisteException;


public interface ICadastroFuncionario {
	
	void cadastrarFuncionario(Funcionario func) throws ObjectJaExisteException;
	Funcionario buscarFuncionario(String cpf) throws ObjectNaoExisteException;
	void removerFuncionario(Funcionario func) throws ErroAoRemoverException;
	void alterarFuncionario(Funcionario func) throws ErroAoAtualizarException;
	public List<Funcionario> mostrarfunc();
	CadastroFuncionario getInstance();
}
