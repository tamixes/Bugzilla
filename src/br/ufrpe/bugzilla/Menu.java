package br.ufrpe.bugzilla;

import java.time.LocalDate;
import java.util.Scanner;

import br.ufrpe.bugzilla.colecoes.TipoCliente;
import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.IFachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.bugzilla.negocio.beans.Usuario;

public class Menu {
	
	private IFachada bugentregas = Fachada.getInstance();
	private Scanner scan = new Scanner(System.in);;
	
	public void borda(){
		System.out.println("------------------BUGZILLA-----------------\n");
	}
	
	public void login() throws Exception{
		
		this.borda();
	
		System.out.println("Login: ");
		String login = scan.nextLine();
		System.out.println("Senha: ");
		String senha = scan.nextLine();
		
		//temporário
		if(login.equalsIgnoreCase("admin") && senha.equals("admin")){
			this.menuPrincipal();
		}
		
	}

	private void menuPrincipal() throws Exception{
		
		while(true){
			
			this.borda();
			System.out.println("MENU PRINCIPAL\n");
			System.out.println("1 - Funcionários\n"
							 + "2 - Clientes\n"
							 + "3 - Centrais\n"
							 + "4 - Encomendas\n"
							 + "0 - Sair\n"
							 + "Opção: ");
			int opcao = scan.nextInt();
			
		switch(opcao){
		
			case 1:
				
				int aux1 = 0;
				
				while(aux1!=5){
					
					this.borda();
					System.out.println("MENU FUNCIONÁRIOS\n");
					System.out.println("1 - Cadastrar\n"
									 + "2 - Remover\n"
									 + "3 - Pesquisar\n"
									 + "4 - Atualizar\n"
									 + "5 - Sair\n"
									 + "Opção: ");
					int op = scan.nextInt();
					
					switch(op){
					
						case 1:{
							
							boolean ok = false;
							
							do{
								String limpaBuffer = scan.nextLine();
								System.out.println();
	
								System.out.println("Instruções:\nNo campo CPF, somente informe os numeros, não é necessário digitar pontos e hífem\n");
	
								System.out.println("Nome: ");
								String nomeFunc = scan.nextLine();
	
								System.out.println("CPF: ");
								String cpfFunc = scan.nextLine();
								
	
								System.out.print("Data de Nascimento:\n" + "Dia: ");
								int diaNascimento = scan.nextInt();
								System.out.print("Mês: ");
								int mesNascimento = scan.nextInt();
								System.out.print("Ano: ");
								int anoNascimento = scan.nextInt();
								LocalDate dataFunc = LocalDate.of(anoNascimento, mesNascimento, diaNascimento);
	
								
								limpaBuffer = scan.nextLine();
								System.out.println("Fone: ");
								String telefoneFunc = scan.nextLine();
								
								System.out.println("---Endereço");
								System.out.print("Rua: ");
								String rua = scan.nextLine();
								System.out.print("Numero: ");
								int num = scan.nextInt();
								String limpaBuffer2 = scan.nextLine();
								System.out.print("Bairro: ");
								String bairro = scan.nextLine();
								System.out.print("Cidade: ");
								String cidade = scan.nextLine();
								System.out.print("Estado: ");
								String estado = scan.nextLine();
								System.out.print("CEP: ");
								String cep = scan.nextLine();
	
								Endereco enderecoFunc = new Endereco(rua,bairro,cidade,estado,cep,num);
								
								System.out.println("Salário: ");
								double salarioFunc = scan.nextDouble();
								
								String limpaBuffer3 = scan.nextLine();
								System.out.println("Login: ");
								String loginFunc = scan.nextLine();
								
								System.out.println("Senha: ");
								String senhaFunc = scan.nextLine();
	
							if ((cpfFunc.length() != 11) || 
									(senhaFunc.length() < 8) ||
									(bugentregas.existeFunc(cpfFunc))) {
	
								String erro = "O cadastro possui os campos inválidos: \n";
	
								if (cpfFunc.length() != 11) {
									erro = erro + "CPF inválido\n";
								}
								
								if(bugentregas.existeFunc(cpfFunc)){
									erro = erro + "O CPF inserido já está cadastrado no sistema";
								}
	
								if (senhaFunc.length() < 8) {
									erro = erro + "Senha muito curta\n";
								}
								System.out.println(erro);
							} else {
								Funcionario func = new Funcionario(nomeFunc, cpfFunc, dataFunc, telefoneFunc, enderecoFunc, salarioFunc, new Usuario(loginFunc,senhaFunc));
								try {
									bugentregas.addFuncionario(func);
								} catch (ObjectJaExisteException e) {
									System.out.println(e.getMessage());
									e.printStackTrace();
								}
								ok = true;
								System.out.println("Cadastro realizado com sucesso!");
							}
							}while(ok==false);
	
							break;
						}
						
						case 2:{
							
						String limpaBuffer = scan.nextLine();
						System.out.println("Remover funcionário");
						System.out.println("Informe o cpf do funcionario que deseja remover: ");
						String busca = scan.nextLine();
							
						Funcionario deleta = null;
						try {
							deleta = bugentregas.buscarFuncionario(busca);
						} catch (ObjectNaoExisteException e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
							if(deleta != null){
								System.out.println("Você realmente deseja deletar os dados de " + deleta.getNome() +"?\n"
										+ "1 - Sim\n"
										+ "2 - Não\n"
										+ "Digite: ");
								int escolha = scan.nextInt();
								switch(escolha){
									case 1:
									try {
										bugentregas.removerFuncionario(deleta);
									} catch (ErroAoRemoverException e) {
										System.out.println(e.getMessage());
										e.printStackTrace();
									}
										System.out.println("Funcionário removido!");
									}
							}
							else {
								System.out.println("Funcionário não existe!");
							}
							
							break;
						}
							
						case 3:{
							
							String limpaBuffer = scan.nextLine();
							System.out.println("Visualizar dados de um funcionário");
							System.out.println("Buscar por cpf: ");
							String busca = scan.nextLine();
							
							Funcionario leitura = null;
							try {
								leitura = bugentregas.buscarFuncionario(busca);
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								e.printStackTrace();
							}
							if(leitura != null){
								System.out.println("Dados gerais de " + leitura.getNome());
								System.out.println(leitura.toString());
							}
							else{
								
								System.out.println("Funcionário não existe!");
							}
								
							break;
						}
						
						case 4:{
							
							String limpaBuffer = scan.nextLine();
							System.out.println("Atualizar dados de um funcionário");
							System.out.println("Informe o cpf do funcionario que deseja: ");
							String busca = scan.nextLine();
							
							Funcionario atualiza = null;
							try {
								atualiza = bugentregas.buscarFuncionario(busca);
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								e.printStackTrace();
							}
							if(atualiza != null){
								System.out.println("Informe os campos que deseja atualizar abaixo");
								System.out.println("---Endereço");
								System.out.print("Rua: ");
								String ruaAtt = scan.nextLine();
								System.out.print("Numero: ");
								int numAtt = scan.nextInt();
								System.out.print("Bairro: ");
								String bairroAtt = scan.nextLine();
								System.out.print("Cidade: ");
								String cidadeAtt = scan.nextLine();
								System.out.print("Estado: ");
								String estadoAtt = scan.nextLine();
								System.out.print("CEP: ");
								String cepAtt = scan.nextLine();
								Endereco endAtt = new Endereco(ruaAtt, bairroAtt, cidadeAtt, estadoAtt, cepAtt, numAtt);
								
								
								System.out.println("Telefone: ");
								String telefoneAtt = scan.nextLine();
								
								System.out.println("Salário: ");
								double salarioAtt = scan.nextDouble();
								
								System.out.println("Login: ");
								String loginAtt = scan.nextLine();
								System.out.println("Senha: ");
								String senhaAtt = scan.nextLine();
								
								atualiza.setEnd(endAtt);
								atualiza.setSalario(salarioAtt);
								atualiza.getUsuario().setLogin(loginAtt);
								atualiza.getUsuario().setSenha(senhaAtt);
								atualiza.setTelefone(telefoneAtt);
								
								try {
									bugentregas.alterarFuncionario(atualiza);
								} catch (ErroAoAtualizarException e) {
									System.out.println(e.getMessage());
									e.printStackTrace();
								}
								
							}
							else{
								System.out.println("Funcionario não existe!");
							}
							
							break;
						}
						
						case 5:{
							System.out.println("Voltando ao menu...");
							scan.nextLine();
							aux1 = 5;
					
							break;
						}
					
					}
					
				}
				
				
			break;
				
			case 2:
				
				int aux2 = 0;
				
				while(aux2!=5){
					
					this.borda();
					System.out.println("MENU CLIENTES\n");
					System.out.println("1 - Cadastrar\n"
									 + "2 - Remover\n"
									 + "3 - Pesquisar\n"
									 + "4 - Atualizar\n"
									 + "5 - Sair\n"
									 + "Opção: ");
					int op = scan.nextInt();
					
					switch(op){
					
						case 1:{
							int opClient = 0;
							do{
								System.out.println("Escolha o tipo de cliente para ser cadastrado:\n 1 - Pessoa Física\n 2 - Pessoa Jurídica\n");
							}while (opClient == 1 || opClient == 2);
							
						opClient = scan.nextInt();
						if (opClient == 1) {

							String limpaBuffer = scan.nextLine();
							System.out.println();

							System.out.println(
									"Instruções:\nNo campo CPF, somente informe os numeros, não é necessário digitar pontos e hífem\n");

							System.out.println("Nome: ");
							String nomeCliente = scan.nextLine();

							System.out.println("CPF: ");
							String cpfCliente = scan.nextLine();

							System.out.println("Telefone: ");
							String telCliente = scan.nextLine();

							System.out.println("---Endereço");
							System.out.print("Rua: ");
							String rua = scan.nextLine();
							System.out.print("Numero: ");
							int num = scan.nextInt();
							String limpaBuffer2 = scan.nextLine();
							System.out.print("Bairro: ");
							String bairro = scan.nextLine();
							System.out.print("Cidade: ");
							String cidade = scan.nextLine();
							System.out.print("Estado: ");
							String estado = scan.nextLine();
							System.out.print("CEP: ");
							String cep = scan.nextLine();

							Endereco enderecoClient = new Endereco(rua, bairro, cidade, estado, cep, num);
							Cliente cliente = new Cliente(nomeCliente, null, cpfCliente, telCliente, enderecoClient, TipoCliente.FIS);
							
							if ((cpfCliente.length() != 11) || 
									(bugentregas.existeCliente(cliente))) {
	
								String erro = "O cadastro possui os campos inválidos: \n";
	
								if (cpfCliente.length() != 11) {
									erro = erro + "CPF inválido\n";
								}
								
								if(bugentregas.existeCliente(cliente)){
									erro = erro + "O cliente" + nomeCliente + " inserido já está cadastrado no sistema";
								}
								
								System.out.println(erro);
							} else {
								 
								try {
									bugentregas.cadastrarCliente(cliente);
								} catch (ObjectJaExisteException e) {
									System.out.println(e.getMessage());
									e.printStackTrace();
								}
								
								System.out.println("Cadastro realizado com sucesso!");
							}

						} else if (opClient == 2) {
							String limpaBuffer = scan.nextLine();
							System.out.println();

							System.out.println(
									"Instruções:\nNo campo CNPJ, somente informe os numeros, não é necessário digitar pontos, barra e hífem\n");

							System.out.println("Nome: ");
							String nomeCliente = scan.nextLine();

							System.out.println("CNPJ: ");
							String cnpjCliente = scan.nextLine();

							System.out.println("Telefone: ");
							String telCliente = scan.nextLine();

							System.out.println("---Endereço");
							System.out.print("Rua: ");
							String rua = scan.nextLine();
							System.out.print("Numero: ");
							int num = scan.nextInt();
							String limpaBuffer2 = scan.nextLine();
							System.out.print("Bairro: ");
							String bairro = scan.nextLine();
							System.out.print("Cidade: ");
							String cidade = scan.nextLine();
							System.out.print("Estado: ");
							String estado = scan.nextLine();
							System.out.print("CEP: ");
							String cep = scan.nextLine();

							Endereco enderecoClient = new Endereco(rua, bairro, cidade, estado, cep, num);
							Cliente cliente = new Cliente(nomeCliente, cnpjCliente, null, telCliente, enderecoClient, TipoCliente.JUR);
							
							if ((cnpjCliente.length() != 14) || 
									(bugentregas.existeCliente(cliente))) {
	
								String erro = "O cadastro possui os campos inválidos: \n";
	
								if (cnpjCliente.length() != 11) {
									erro = erro + "CNPJ inválido\n";
								}
								
								if(bugentregas.existeCliente(cliente)){
									erro = erro + "O cliente" + nomeCliente +" já está cadastrado no sistema";
								}
								
								System.out.println(erro);
							} else {
								 
								try {
									bugentregas.cadastrarCliente(cliente);
								} catch (ObjectJaExisteException e) {
									System.out.println(e.getMessage());
									e.printStackTrace();
								}
								
								System.out.println("Cadastro realizado com sucesso!");
							}

						} 
							
						}
						break;
						
						case 2:{
							String limpaBuffer = scan.nextLine();
							System.out.println("Remover Cliente");
							System.out.println("Informe o ID do cliente que deseja remover: ");
							int busca = scan.nextInt();
								
							Cliente deleta = null;
							try {
								deleta = bugentregas.procurarCliente(busca);
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								e.printStackTrace();
							}
								if(deleta != null){
									System.out.println("Você realmente deseja deletar os dados de " + deleta.getNome() +"?\n"
											+ "1 - Sim\n"
											+ "2 - Não\n"
											+ "Digite: ");
									int escolha = scan.nextInt();
									switch(escolha){
										case 1:
										try {
											bugentregas.removerCliente(deleta);
										} catch (ErroAoRemoverException e) {
											System.out.println(e.getMessage());
											e.printStackTrace();
										}
											System.out.println("Funcionário removido!");
										}
								}
								else {
									System.out.println("Funcionário não existe!");
								}
						}
							
							
						break;
							
						case 3:
							
							
						break;
						
						case 4:
							
							
						break;
							
							
						case 5:
							System.out.println("Voltando ao menu...");
							scan.nextLine();
							aux1 = 5;
						break;
					}
				}
				
			break;
				
			case 3:
				
				int aux3 = 0;
				
				while(aux3!=5){
					
					this.borda();
					System.out.println("MENU CENTRAIS\n");
					System.out.println("1 - Cadastrar\n"
									 + "2 - Remover\n"
									 + "3 - Pesquisar\n"
									 + "4 - Atualizar\n"
									 + "5 - Sair\n"
									 + "Opção: ");
					int op = scan.nextInt();
					
					switch(op){
					
						case 1:
							
							
						break;
						
						case 2:
							
							
						break;
							
						case 3:
							
							
						break;
						
						case 4:
							
							
						break;
							
							
						case 5:
							System.out.println("Voltando ao menu...");
							scan.nextLine();
							aux1 = 5;
						break;
					}
				}
				
				
			break;
			
			case 4:
				
				int aux4 = 0;
				
				while(aux4!=5){
					
					this.borda();
					System.out.println("MENU ENCOMENDAS\n");
					System.out.println("1 - Cadastrar\n"
									 + "2 - Remover\n"
									 + "3 - Pesquisar\n"
									 + "4 - Atualizar\n"
									 + "5 - Sair\n"
									 + "Opção: ");
					int op = scan.nextInt();
					
					switch(op){
					
						case 1:
							
							
						break;
						
						case 2:
							
							
						break;
							
						case 3:
							
							
						break;
						
						case 4:
							
							
						break;
							
							
						case 5:
							System.out.println("Voltando ao menu...");
							scan.nextLine();
							aux1 = 5;
						break;
					}
				}
				
				
			break;
				
				
			case 0:
				scan.close();
				System.out.println("Saindo...");
				scan.nextLine();
				System.exit(0);
			break;
			
			default:
				System.out.println("Opção Inválida");
			break;
		
		}
			
			
		}
	}	

}
