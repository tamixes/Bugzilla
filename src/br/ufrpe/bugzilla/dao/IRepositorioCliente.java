package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.beans.Cliente;

public interface IRepositorioCliente {
	
	void cadastrarCliente(Cliente cliente);
	Cliente procurarCliente(String nome) throws ObjectNaoExisteException;
	void atualizarCliente(Cliente cliente) throws ObjectNaoExisteException;
	void removerCliente(String nome) throws ObjectNaoExisteException;
	ArrayList<Cliente> listarClientes();
	boolean existe(Cliente cliente);

}
