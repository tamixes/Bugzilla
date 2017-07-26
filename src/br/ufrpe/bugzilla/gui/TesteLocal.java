package br.ufrpe.bugzilla.gui;

import java.util.Scanner;

import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.IFachada;
import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.exceptions.*;

public class TesteLocal {
	
	private IFachada bugentregas = Fachada.getInstance();
	
	public void Menu(){
		int opcao=5;
		
		Scanner scan = new Scanner(System.in);
		
		do{
			
			System.out.println("MENU");
			System.out.println("");
			System.out.println("(1) Cadastrar Local");
			System.out.println("(2) Consultar Local");
			System.out.println("(3) Remover Local");
			System.out.println("(4) Atualizar Local");
			System.out.println("(5) Sair");
			System.out.println("");
			System.out.println("Digite a opção desejada: ");
			opcao = scan.nextInt();

			switch(opcao){
			
				case 1:{
					String limpa = scan.nextLine();
							
					System.out.println("Digite o nome do local: ");
					String nome = scan.nextLine();
					System.out.println("Digite a localização: ");
					int localiz = scan.nextInt();
					
					try {
						bugentregas.cadastrarLocal(new Local(nome,localiz));
					} catch (LocalExisteException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
					
					break;
				}
				case 2:{
					String limpa = scan.nextLine();
					
					System.out.println("Digite o nome do Local para consulta: ");
					String nome = scan.nextLine();
					
					try {
						System.out.println(bugentregas.procurarLocal(nome));
					} catch (LocalNaoEncontradoException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
					
					
					break;
				}
				case 3:{
					String limpa = scan.nextLine();
					
					System.out.println("Digite o nome do Local que deseja remover: ");
					String nome = scan.nextLine();
					
					try {
						bugentregas.removerLocal(nome);
					} catch (LocalNaoEncontradoException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
					
					break;
				}
				case 4:{
					String limpa = scan.nextLine();
					
					//refazer função atualizar no repositorio
					System.out.println("Digite o nome do Local que deseja atualizar: ");
					String nome = scan.nextLine();
					
					try {
						bugentregas.procurarLocal(nome);
						
						System.out.println("Digite o novo nome: ");
						String nNome = scan.nextLine();
						System.out.println("Digite a nova localização: ");
						int nl = scan.nextInt();
						
						try{
							bugentregas.atualizarLocal(new Local(nNome,nl));
						}catch(LocalNaoEncontradoException e){
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
						
					} catch (LocalNaoEncontradoException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
					
					
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
