package br.ufrpe.bugzilla.negocio;
import java.util.List;
import br.ufrpe.bugzilla.negocio.beans.Administrador;
import br.ufrpe.bugzilla.negocio.beans.Usuario;

public interface ICadastroAdministrador {
		
		CadastroAdministrador getInstance();
		void cadastrarAdministrador(Administrador adm);
		void alterarAdministrador(Administrador adm);
		void removerAdminstrador(Administrador adm);
		public List<Administrador> mostraAdministrador();
		Administrador buscaAdministrador(String cpf);
		boolean verificaLogin(Usuario usuario);
		
	
}
