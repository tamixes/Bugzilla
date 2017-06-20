package old;

import java.time.LocalDate;

import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.Pessoa;

public class ClasseTeste {

	public static void main(String [] args){
		
		// eae vamo testa
		
		Endereco end = new Endereco("Rua Porto Gau", "Boa Vista", "Recife", "PE","54332-345", 30);
		LocalDate tst = LocalDate.of(2017, 1, 15);
		Pessoa p1 = new Pessoa("Tarcisio", "155.365.847-80", tst, "8374746", end);
		Pessoa p2= new Pessoa("Tamires", "522.165.847-50", tst, "8312546", end);
		Administrador adm = new Administrador(p1, 12345, "admin", "admin");
		Funcionario func =  new Funcionario(p2, "func", "func");
		adm.criaFuncionario(func);
		
		//...
		
	}
}
