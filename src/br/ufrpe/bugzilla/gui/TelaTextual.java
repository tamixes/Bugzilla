package br.ufrpe.bugzilla.gui;

import java.time.LocalDate;
import java.util.Scanner;

import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Administrador;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.bugzilla.negocio.beans.Pessoa;

public class TelaTextual {

	public void iniciar(){
		
		Fachada bugentregas = Fachada.getInstance();
		
		Scanner ler = new Scanner(System.in);
		int user;
		
		do{
		
			System.out.println("------------MENU------------");
			System.out.println("(1) Criar Administrador");
			System.out.println("(2) Criar Funcionário");
			System.out.println("(3) Remover Funcionário");
			System.out.println("(4) Criar encomenda");
			System.out.println("(5) Remover Encomenda");
			System.out.println("(6) Sair");
			System.out.println("----------------------------");
			System.out.println();
			System.out.println("Digite a opção desejada: ");
			
			user = ler.nextInt();
			
			Administrador adm1 = new Administrador("Ivete", "15842695847", 
					LocalDate.of(2017, 06, 23), "8457-2214",
					new Endereco("Madalena", "Lua", "Recife", "RS",
							"54874-652", 40));
			
			Funcionario func1 = new Funcionario("Ivete", "15842695847", 
					LocalDate.of(2017, 06, 23), "8457-2214",
					new Endereco("Madalena", "Lua", "Recife", "RS",
							"54874-652", 40), 400.2);
			
			Endereco end1 = new Endereco("Espera", 
							"Gera", "Paudalho", "PE",
							"45236-583", 100);
			
			Encomenda enc1 = new Encomenda( new Pessoa("Irene", "51236584751",
							LocalDate.of(2017, 06, 25), "8745-8452", end1), 
							500.32, "Bola", 4786);
			
			switch(user){
			
			case 1:
				bugentregas.cadastrarAdministrador(adm1);
				break;
				
			case 2:
				bugentregas.addFuncionario(func1);
				break;
				
			case 3:
				bugentregas.removerFuncionario(func1);
				break;
				
			case 4:
				bugentregas.novaEncomenda(enc1);
				break;
				
			case 5:
				bugentregas.removeEncomenda(enc1.getCodigo());
				
			default:
				if(user!=6)
				System.out.println("\nErro...");
			}
		
		}while(user!= 6);
		
		ler.close();
		System.out.println("\nSaindo...");
	}
}
