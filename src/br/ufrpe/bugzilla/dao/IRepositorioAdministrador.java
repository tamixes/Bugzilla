package br.ufrpe.bugzilla.dao;

import br.ufrpe.bugzilla.negocio.beans.Administrador;
import java.util.List;

public interface IRepositorioAdministrador {


	boolean existe(String cpf);
	void cadastrarAdministrador(Administrador adm);
	Administrador buscaAdministrador(String cpf);
	void removerAdministrador(String cpf);
	void alteraAdministrador(Administrador adm);
	List<Administrador> listaAdministrador();
	RepositorioAdministrador getInstance();







}
