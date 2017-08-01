package br.ufrpe.bugzilla.dao;

import java.util.ArrayList;

import br.ufrpe.bugzilla.negocio.beans.Cliente;

public interface IRepositorioCliente {
	
	void cadastrarCliente(Cliente cliente);
	Cliente procurarCliente(String nome);
	void atualizarCliente(Cliente cliente);
	void removerCliente(String nome);
	ArrayList<Cliente> listarClientes();
	boolean existe(Cliente cliente);

}
