package br.ufrpe.bugzilla;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.ufrpe.bugzilla.colecoes.TipoCliente;
import br.ufrpe.bugzilla.colecoes.TipoDeFuncionario;
import br.ufrpe.bugzilla.exceptions.ErroAoAtualizarException;
import br.ufrpe.bugzilla.exceptions.ErroAoRemoverException;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.IFachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.bugzilla.negocio.beans.Rastreio;
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
								scan.nextLine(); //limpaBuffer
								System.out.println();
	
								System.out.println("Instruções:\nNo campo CPF, somente informe os numeros, não é necessário digitar pontos e hífem\n");
	
								System.out.println("Nome: ");
								String nomeFunc = scan.nextLine();
	
								System.out.println("CPF: ");
								String cpfFunc = scan.nextLine();
								
	
								System.out.print("Data de Nascimento:\n" + "Dia: ");
								String dataFunc = scan.nextLine();
	
								
								scan.nextLine(); //limpaBuffer
								System.out.println("Fone: ");
								String telefoneFunc = scan.nextLine();
								
								System.out.println("---Endereço");
								System.out.print("Rua: ");
								String rua = scan.nextLine();
								System.out.print("Numero: ");
								int num = scan.nextInt();
								scan.nextLine(); //limpaBuffer
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
								
								scan.nextLine(); //limpaBuffer
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
								Funcionario func = new Funcionario(nomeFunc, cpfFunc, dataFunc, telefoneFunc, enderecoFunc, salarioFunc, new Usuario(loginFunc,senhaFunc), TipoDeFuncionario.ADM);
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
							
						scan.nextLine(); //limpaBuffer
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
							
							scan.nextLine(); //limpaBuffer
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
							
							scan.nextLine(); //limpaBuffer
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

							scan.nextLine(); //limpaBuffer
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
							scan.nextLine(); //limpaBuffer
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
							scan.nextLine(); //limpaBuffer
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
							scan.nextLine(); //limpaBuffer
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
	
								if (cnpjCliente.length() != 14) {
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
								scan.nextLine();
							}

						} 
							
						}
						break;
						
						case 2:{
							scan.nextLine(); //limpaBuffer
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
											System.out.println("Cliente removido!");
										}
								}
								else {
									System.out.println("Cliente não existe!");
								}
						}
							
							
						break;
							
						case 3:{
							
							scan.nextLine(); //limpaBuffer
							System.out.println(" Pesquisar um cliente \n");
							System.out.println("Digite o id do Cliente: ");
							int busca = scan.nextInt();
							
							Cliente leitura = null;
							try {
								leitura = bugentregas.procurarCliente(busca);
								
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								e.printStackTrace();
								scan.nextLine();
							}
							if(leitura != null){
								System.out.println("Dados gerais de " + leitura.getNome());
								System.out.println(leitura);
							}
							else{
								
								System.out.println("Cliente não existe!");
							}
							
							
						break;
						}
						
						case 4:{
							
							scan.nextLine(); //limpaBuffer
							System.out.println("Atualizar Cliente");
							System.out.println("Informe o nome do cliente que deseja alterar: ");
							String busca = scan.nextLine();
							
							Cliente atualiza = null;
							try {
								atualiza = bugentregas.procurarCliente(busca);
								
								System.out.println("----Digite os novos dados");
								System.out.println("Nome: ");
								String nomeCliente = scan.nextLine();
								
								if(atualiza.getTipo() == TipoCliente.FIS) {
									System.out.println("CPF: ");
									String cpfCliente = scan.nextLine();
									atualiza.setCpf(cpfCliente);
								}
								else {
									System.out.println("CNPJ: ");
									String cnpjCliente = scan.nextLine();
									atualiza.setCnpj(cnpjCliente);
								}
																

								System.out.println("Telefone: ");
								String telCliente = scan.nextLine();

								System.out.println("---Endereço");
								System.out.print("Rua: ");
								String rua = scan.nextLine();
								System.out.print("Numero: ");
								int num = scan.nextInt();
								scan.nextLine(); //limpaBuffer
								System.out.print("Bairro: ");
								String bairro = scan.nextLine();
								System.out.print("Cidade: ");
								String cidade = scan.nextLine();
								System.out.print("Estado: ");
								String estado = scan.nextLine();
								System.out.print("CEP: ");
								String cep = scan.nextLine();

								Endereco enderecoClient = new Endereco(rua, bairro, cidade, estado, cep, num);

								atualiza.setNome(nomeCliente);
								atualiza.setTelefone(telCliente);
								atualiza.setEndereco(enderecoClient);
								
								
								try {
									bugentregas.atualizarCliente(atualiza);
									System.out.println("Atualizado com sucesso!");
									scan.nextLine();
								} catch (ErroAoAtualizarException e) {
									System.out.println(e.getMessage());
									scan.nextLine();
								}
								
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								scan.nextLine();
							}
							
							
						break;
						}
							
						case 5:{
							System.out.println("Voltando ao menu...");
							scan.nextLine();
							aux2 = 5;
						break;
						}
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
					
						case 1:{
							boolean ok = false;
							
							do{
								
								scan.nextLine(); //limpabuffer

								System.out.println("Para cadastrar uma central Bugzilla, é necessário ter as coordenadas do local\nLink para obter coordenadas: http://www.mapcoordinates.net/pt\n");

								System.out.println("Nome da Cidade: ");
								String nomeLocal = scan.nextLine();
								
								try{
									
									System.out.println("---Coordenadas Geográficas de " + nomeLocal);
									System.out.println("Latitude: ");
									String latitude = scan.nextLine();
									//converte a string para double, substituindo eventual '.' por ','
									double lt = Double.parseDouble(latitude.replace(',', '.'));
									
									
									System.out.println("Longitude: ");
									String longitude = scan.nextLine();
									//converte a string para double, substituindo eventual '.' por ','
									double lg = Double.parseDouble(longitude.replace(',', '.'));
									
									Local central = new Local(nomeLocal,lt,lg);
									
									try{
										bugentregas.cadastrarLocal(central);
										System.out.println("Cadastrado com sucesso!");
										scan.nextLine();
										ok = true;
									}catch(ObjectJaExisteException e){
										System.out.println(e.getMessage());
										scan.nextLine();
									}
									
								}catch(InputMismatchException e){
									e.printStackTrace();
									scan.nextLine();
								}
								
							}while(ok==false);	
							
						break;
					}
						
						case 2:{
							
							scan.nextLine(); //limpaBuffer
							System.out.println("Remover Central");
							System.out.println("Informe o nome da central que deseja remover: ");
							String busca = scan.nextLine();
								
							Local deleta = null;
							try {
								deleta = bugentregas.procurarLocal(busca);
								System.out.println("Você realmente deseja deletar " + deleta.getNome() +"?\n"
										+ "1 - Sim\n"
										+ "2 - Não\n"
										+ "Digite: ");
								int escolha = scan.nextInt();
								switch(escolha){
									case 1:
										try {
											bugentregas.removerLocal(deleta.getNome());
											System.out.println("Removido com sucesso!");
											scan.nextLine();
										} catch (ErroAoRemoverException e) {
											System.out.println(e.getMessage());
											scan.nextLine();
										}
									}
								
								
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								scan.nextLine();
							}
							
							
						break;
						}
							
						case 3:{
							
							scan.nextLine(); //limpaBuffer
							System.out.println(" ***Buscar uma Central***\n");
							System.out.println("Digite o nome do Local: ");
							String busca = scan.nextLine();
							
							Local leitura = null;
							try {
								leitura = bugentregas.procurarLocal(busca);
								System.out.println("\nInformações da central " + leitura.getNome());
								System.out.println(leitura);
								scan.nextLine();
								
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								scan.nextLine();
							}
							
						break;
						}
						
						case 4:{
							
							scan.nextLine(); //limpaBuffer
							System.out.println("Atualizar Central");
							System.out.println("Informe o nome da central que deseja alterar: ");
							String busca = scan.nextLine();
							
							Local atualiza = null;
							try {
								System.out.println("\nNão é possível alterar as coordenadas de uma central!");
								atualiza = bugentregas.procurarLocal(busca);
								System.out.println("Informe o novo nome: ");
								String nNome = scan.nextLine();
								atualiza.setNome(nNome);
								
								try {
									bugentregas.atualizarLocal(atualiza);
									System.out.println("Atualizado com sucesso!");
									scan.nextLine();
								} catch (ErroAoAtualizarException e) {
									System.out.println(e.getMessage());
									scan.nextLine();
								}
								
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								scan.nextLine();
							}
							
						break;
						}
							
							
						case 5:{
							System.out.println("Voltando ao menu...");
							scan.nextLine();
							aux3 = 5;
						break;
						}
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
									 + "4 - Atualizar Rastreio\n"
									 + "5 - Definir Tarifa Base\n"
									 + "6 - Sair\n"
									 + "Opção: ");
					int op = scan.nextInt();
					
					switch(op){
					
						case 1:{
							
							boolean ok = false;
							
							do{
								
								scan.nextLine(); //limpabuffer

								System.out.println("Para registrar uma encomenda, é necessário ter cadastrado ao menos 2 centrais e 2 clientes\n");
								
								Cliente leituraCliente1 = null;
								Cliente leituraCliente2 = null;
								
								do{
									System.out.println("Digite o id do Cliente remetente: ");
									int busca = scan.nextInt();
									
									
									try {
										leituraCliente1 = bugentregas.procurarCliente(busca);
										
									} catch (ObjectNaoExisteException e) {
										System.out.println(e.getMessage());
										scan.nextLine();
									}
								}while(leituraCliente1==null);
								
								do{
									System.out.println("Digite o id do Cliente destinatário: ");
									int busca = scan.nextInt();
									
									
									try {
										leituraCliente2 = bugentregas.procurarCliente(busca);
										
									} catch (ObjectNaoExisteException e) {
										System.out.println(e.getMessage());
										scan.nextLine();
									}
								}while(leituraCliente2==null);
								
								scan.nextLine(); //limpaBuffer
								System.out.println("Digite o tipo/nome do produto: ");
								String tipo = scan.nextLine();
								System.out.println("Digite o peso: ");
								double peso = scan.nextDouble();
								System.out.println("Digite o prazo: ");
								int prazo = scan.nextInt();
								scan.nextLine(); //limpaBuffer
								
								Local leituraLocal1 = null;
								Local leituraLocal2 = null;
								
								while(leituraLocal1==null){
									System.out.println("Digite o nome do Local de origem: ");
									String busca = scan.nextLine();
									
									
									try {
										leituraLocal1 = bugentregas.procurarLocal(busca);
										
									} catch (ObjectNaoExisteException e) {
										System.out.println(e.getMessage());
										scan.nextLine();
									}
								}
								
								while(leituraLocal2==null){
									System.out.println("Digite o nome do Local de destino: ");
									String busca = scan.nextLine();
									
									
									try {
										leituraLocal2 = bugentregas.procurarLocal(busca);
										
									} catch (ObjectNaoExisteException e) {
										System.out.println(e.getMessage());
										scan.nextLine();
									}
								}
								
								Encomenda encomenda = new Encomenda(leituraCliente1,leituraCliente2,peso,tipo,leituraLocal1,leituraLocal2,prazo);
								
								try{
									
									bugentregas.novaEncomenda(encomenda);
									System.out.println("Encomenda cadastrada com sucesso, código: " + encomenda.getCodigo());
									ok=true;
									scan.nextLine();
									
								}catch(ObjectJaExisteException e){
									System.out.println(e.getMessage());
								}
								
								
							}while(ok==false);
							
							
						break;
						}
						
						case 2:{
							
							scan.nextLine(); //limpabuffer
							System.out.println("Remover Encomenda");
							System.out.println("Informe o codigo da encomenda que deseja remover: ");
							String busca = scan.nextLine();
								
							Encomenda deleta = null;
							try {
								deleta = bugentregas.buscaEncomenda(busca);
								System.out.println("Você realmente deseja deletar " + deleta.getCodigo() +"?\n"
										+ "1 - Sim\n"
										+ "2 - Não\n"
										+ "Digite: ");
								int escolha = scan.nextInt();
								switch(escolha){
									case 1:
										try {
											bugentregas.removeEncomenda(deleta.getCodigo());
											System.out.println("Removido com sucesso!");
											scan.nextLine();
										} catch (ErroAoRemoverException e) {
											System.out.println(e.getMessage());
											scan.nextLine();
										} catch(ObjectNaoExisteException e){
											System.out.println(e.getMessage());
											scan.nextLine();
										}
									}
								
								
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								scan.nextLine();
							}
							
							
						break;
						}
						
						case 3:{
							
							scan.nextLine(); //limpaBuffer
							System.out.println(" ***Buscar uma Encomenda***\n");
							System.out.println("Digite o código da Encomenda: ");
							String busca = scan.nextLine();
							
							Encomenda leitura = null;
							try {
								leitura = bugentregas.buscaEncomenda(busca);
								System.out.println("\nInformações da Encomenda " + leitura.getCodigo());
								System.out.println();
								System.out.println(leitura);
								System.out.println();
								System.out.println(leitura.getRastreamento());
								scan.nextLine();
								
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								scan.nextLine();
							}
							
							
						break;
						}
						
						case 4:{
							
							scan.nextLine(); //limpaBuffer
							System.out.println("***Atualizar Rastreio de uma Encomenda***\n");
							System.out.println("Digite o código da Encomenda: ");
							String busca = scan.nextLine();
							
							Encomenda leitura = null;
							try {
								leitura = bugentregas.buscaEncomenda(busca);
								System.out.println("Digite a situação: ");
								String situacao = scan.nextLine();
								System.out.println("Digite o Local atual: ");
								String local = scan.nextLine();
								LocalDateTime dataHora = LocalDateTime.now();
								
								Rastreio rastreamento = new Rastreio(situacao,local,dataHora);
								
								try{
									
									leitura.atualizaRelatorio(rastreamento);
									bugentregas.atualizaEncomenda(leitura);
									System.out.println("Rastreio atualizado com sucesso!");
									scan.nextLine();
									
								}catch(ObjectNaoExisteException e){
									System.out.println(e.getMessage());
								}catch(ErroAoAtualizarException e){
									System.out.println(e.getMessage());
								}
								
								
							} catch (ObjectNaoExisteException e) {
								System.out.println(e.getMessage());
								scan.nextLine();
							}
							
							
						break;
						}
						
						case 5:{
							boolean ok = false;
							
							do{
								
								try{
									System.out.println("Digite o valor da nova Tarifa base: ");
									double valor = scan.nextDouble();
									bugentregas.defineTarifaBase(valor);
									System.out.println("Tarifa definida com sucesso!");
									ok = true;
								}catch(InputMismatchException e){
									System.out.println(e.getMessage());
								}
								
							}while(ok==false);
							
							
							
						break;
						}
							
						case 6:{
							System.out.println("Voltando ao menu...");
							scan.nextLine();
							aux4 = 5;
						break;
						}
					}
				}
				
				
			break;
				
				
			case 0:
				scan.close();
				System.out.println("Saindo...");
				System.exit(0);
			break;
			
			default:
				System.out.println("Opção Inválida");
			break;
		
		}
			
			
		}
	}	

}
