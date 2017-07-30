package br.ufrpe.bugzilla.gui;

import java.time.LocalDate;
import java.util.Scanner;

import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.IFachada;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.bugzilla.negocio.beans.Pessoa;
import br.ufrpe.bugzilla.negocio.beans.Tarifa;
import br.ufrpe.exceptions.*;

public class TesteLocal {
	
	private IFachada bugentregas = Fachada.getInstance();
	
	public void Menu(){
		int opcao=5;
		
		Scanner scan = new Scanner(System.in);
		
		do{
			
			System.out.println("MENU");
			System.out.println("");
			System.out.println("(1) Cadastrar Encomenda");
			System.out.println("(2) Consultar Encomenda");
			System.out.println("(3) Consultar Valor e Tarifa");
			System.out.println("(5) Sair");
			System.out.println("");
			System.out.println("Digite a opção desejada: ");
			opcao = scan.nextInt();

			switch(opcao){
			
				case 1:{
					String limpa = scan.nextLine();
							
					LocalDate dataPessoa1 = LocalDate.of(1999, 01, 06);
					Endereco endPessoa1 = new Endereco("Dois Rios", "Ibura", "Recife", "PE", "51345370", 2);
					Pessoa pessoa1 = new Pessoa("Jonata", "15632465798", dataPessoa1, "988733337", endPessoa1);
					Encomenda encomenda1 = new Encomenda(pessoa1, 5.0, "pacote", new Tarifa(2), new Local("Paulista",50));
					bugentregas.novaEncomenda(encomenda1);
					
					break;
				}
				case 2:{
					String limpa = scan.nextLine();
					
					System.out.println(bugentregas.buscaEncomenda(1));
					
					break;
				}
				case 3:{
					String limpa = scan.nextLine();
					
					Encomenda encomenda = bugentregas.buscaEncomenda(1);
					System.out.println(encomenda.getPreço());
					System.out.println(encomenda.getPrazo());
					
					break;
				}
				case 5:{
					String limpa = scan.nextLine();
					
					
					System.out.println("Saindo...");
					scan.close();
					System.exit(0);
					break;
				}
				default:{
					System.out.println("Opção inválida, tente novamente...");
				}
			
			}
		}while(opcao != 5);
		
	}

}
