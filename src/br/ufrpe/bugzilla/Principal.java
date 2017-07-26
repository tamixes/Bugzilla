package br.ufrpe.bugzilla;

import br.ufrpe.bugzilla.gui.TelaTextual;
import br.ufrpe.bugzilla.gui.TesteLocal;

public class Principal {

	public static void main(String[] args) {
		
		/*TelaTextual tela = new TelaTextual();
		tela.MenuPrincipal();*/
		
		TesteLocal teste = new TesteLocal();
		teste.Menu();
	}

}
