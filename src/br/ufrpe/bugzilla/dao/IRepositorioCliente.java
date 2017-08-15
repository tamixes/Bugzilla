package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Cliente;

public interface IRepositorioCliente {
	
	void cadastrarCliente(Cliente cliente) throws ObjectJaExisteException;
	Cliente procurarCliente(int id) throws ObjectNaoExisteException;
	Cliente procurarCliente(String nome) throws ObjectNaoExisteException;
	void atualizarCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoAtualizarException;
	void removerCliente(Cliente cliente) throws ObjectNaoExisteException, ErroAoRemoverException;
	ArrayList<Cliente> listarClientes();
	boolean existe(Cliente cliente);
	long contadorCliente();
	void salvaArquivo();

}
