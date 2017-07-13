package br.ufrpe.bugzilla.gui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.IFachada;
import br.ufrpe.bugzilla.negocio.beans.Administrador;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.bugzilla.negocio.beans.Pessoa;
import br.ufrpe.bugzilla.negocio.beans.Rastreio;

public class TelaTextual {
	private IFachada bugentregas = Fachada.getInstance();

	public void borda(){
		System.out.println("------------------BUGZILLA-----------------");

	}
	
	public void MenuPrincipal(){
		this.borda();
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		boolean fecha = false; 
		
		LocalDate dataAdmin1 = LocalDate.of(2000, 07, 19);
		Endereco endAdmin1 = new Endereco("Aurora", "Boa vista", "Recife", "PE", "51345374", 157);
		Administrador admin1 = new Administrador("João","09894131441", dataAdmin1, "32539393", endAdmin1, "glubnotrim");
		bugentregas.cadastrarAdministrador(admin1);
		
		LocalDate dataFunc1 = LocalDate.of(1995, 12, 26);
		Endereco endFunc1 = new Endereco("Rosa e Silva", "Graças", "Recife", "PE", "51798654", 256);
		Funcionario func1 = new Funcionario("Janaína", "32734797447", dataFunc1, "88428996", endFunc1, 1400.58, "samsunga");
		bugentregas.addFuncionario(func1);
		
		LocalDate dataFunc2 = LocalDate.of(1988, 01, 06);
		Endereco endFunc2 = new Endereco("Concelheiro Aguiar", "Boa Viagem", "Recife", "PE", "51011030", 854);
		Funcionario func2 = new Funcionario("Joana", "11194986845", dataFunc2, "88428996", endFunc2, 2350.00, "fuguetao");
		bugentregas.addFuncionario(func2);
		
		LocalDate dataPessoa1 = LocalDate.of(1999, 01, 06);
		Endereco endPessoa1 = new Endereco("Dois Rios", "Ibura", "Recife", "PE", "51345370", 2);
		Pessoa pessoa1 = new Pessoa("Jonata", "15632465798", dataPessoa1, "988733337", endPessoa1);
		Encomenda encomenda1 = new Encomenda(pessoa1, 5.0, "pacote");
		bugentregas.novaEncomenda(encomenda1);
		
		do{
			System.out.println("MENU PRINCIPAL");
			System.out.println("1 - Adicionar novo funcionário\n"
							 + "2 - Alterar dados de um funcionário\n"
							 + "3 - Remover dados de um funcionário\n"
							 + "4 - Visualizar dados de um funcionário\n"
							 + "5 - Nova encomenda\n"
							 + "6 - Atualiza Status de uma encomenda\n"
							 + "7 - Dados de uma encomenda\n"
							 + "8 - Sair\n" + "Opção: ");
			opcao = sc.nextInt();
			
			switch(opcao){
			case 1:{
				boolean aceitoFunc = false;
				do {
					String limpaBuffer = sc.nextLine();
					System.out.println();

					System.out.println(
							"Instruções:\nNo campo CPF, somente informe os numeros, não é necessário digitar pontos e hífem\n"
									+ "No campo Endereço, informe od itens nessa exata ordem: Rua, numero, bairo, cidade, UF e cep. Todos tem que estar separados com vírgula e espaço.\n"
									+ "\tExemplo: Rua Manoel de Medeiros, 55, Dois Irmãos, Recife, PE, 52171900\n"
									+ "O seu login é automaticamente criado usando o seu cpf\n");

					System.out.println("Nome: ");
					String nomeFunc = sc.nextLine();

					System.out.println("CPF: ");
					String cpfFunc = sc.nextLine();

					System.out.print("Data de Nascimento:\n" + "Dia: ");
					int diaNascimento = sc.nextInt();
					System.out.print("Mês: ");
					int mesNascimento = sc.nextInt();
					System.out.print("Ano: ");
					int anoNascimento = sc.nextInt();
					LocalDate dataFunc = LocalDate.of(anoNascimento, mesNascimento, diaNascimento);

					
					limpaBuffer = sc.nextLine();
					System.out.println("Fone: ");
					String telefoneFunc = sc.nextLine();

					System.out.println("Endereço: ");
					String endereco = sc.nextLine();
					Endereco enderecoFunc = (StringParaEndereco(endereco));
					
					System.out.println("Salário: ");
					double salarioFunc = sc.nextDouble();
					
					System.out.println("Senha: ");
					String senhaFunc = sc.nextLine();

					if ((cpfFunc.length() != 11) || 
							(senhaFunc.length() < 8) ||
							(bugentregas.buscarAdministrador(cpfFunc)) != null) {

						String erro = "O cadastro possui os campos inválidos: \n";

						if (cpfFunc.length() != 11) {
							erro = erro + "CPF inválido\n";
						}
						
						if(bugentregas.buscarAdministrador(cpfFunc) != null){
							erro = erro + "O CPF inserido já está cadastrado no sistema";
						}

						if (senhaFunc.length() < 8) {
							erro = erro + "Senha muito curta\n";
						}
						System.out.println(erro);
					} else {
						Funcionario func = new Funcionario(nomeFunc, cpfFunc, dataFunc, telefoneFunc, enderecoFunc, salarioFunc, senhaFunc);
						bugentregas.addFuncionario(func);
						System.out.println("Cadastro realizado com sucesso!");
						aceitoFunc = true;
					}

				} while (aceitoFunc != true);
				break;
			}
			
			
			
			case 2:{
				String limpaBuffer = sc.nextLine();
				System.out.println("Atualizar dados de um funcionário");
				System.out.println("Informe o cpf do funcionario que deseja: ");
				String busca = sc.nextLine();
				
				Funcionario atualiza = bugentregas.buscarFuncionario(busca);
				if(atualiza != null){
					System.out.println("Informe os campos que deseja atualizar abaixo");
					System.out.println("Endereço: ");
					System.out.print("Rua: ");
					String ruaAtt = sc.nextLine();
					System.out.print("Numero: ");
					int numAtt = sc.nextInt();
					System.out.print("Bairro: ");
					String bairroAtt = sc.nextLine();
					System.out.print("Cidade: ");
					String cidadeAtt = sc.nextLine();
					System.out.print("Estado: ");
					String estadoAtt = sc.nextLine();
					Endereco endAtt = new Endereco(ruaAtt, bairroAtt, cidadeAtt, estadoAtt, estadoAtt, numAtt);
					
					
					System.out.println("Telefone: ");
					String telefoneAtt = sc.nextLine();
					
					System.out.println("Salário: ");
					double salarioAtt = sc.nextDouble();
					
					System.out.println("Senha: ");
					String senhaAtt = sc.nextLine();
					
					atualiza.setEnd(endAtt);
					atualiza.setSalario(salarioAtt);
					atualiza.getLog().setSenha(senhaAtt);
					atualiza.setTelefone(telefoneAtt);
					
					bugentregas.alterarFuncionario(atualiza);
					
				}
				else{
					System.out.println("Funcionario não existe!");
					MenuPrincipal();
				}
				break;
			}
			
			case 3:{
				String limpaBuffer = sc.nextLine();
				System.out.println("Remover funcionário");
				System.out.println("Informe o cpf do funcionario que deseja remover: ");
				String busca = sc.nextLine();
				
				Funcionario deleta = bugentregas.buscarFuncionario(busca);
				if(deleta != null){
					System.out.println("Você realmente deseja deletar os dados de " + deleta.getNome() +"?\n"
							+ "1 - Sim\n"
							+ "2 - Não");
					int escolha = sc.nextInt();
					switch(escolha){
					case 1:
						bugentregas.removerFuncionario(deleta);
						System.out.println("Funcionário removido!");
						MenuPrincipal();
					}
				} else {
					System.out.println("Funcionário não existe!");
					MenuPrincipal();
				}
				
			}
			
			case 4:{
				String limpaBuffer = sc.nextLine();
				System.out.println("Visualizar dados de um funcionário");
				System.out.println("Buscar por cpf: ");
				String busca = sc.nextLine();
				
				Funcionario leitura = bugentregas.buscarFuncionario(busca);
				if(leitura != null){
					System.out.println("Dados gerais de " + leitura.getNome());
					System.out.println(leitura.toString());
					MenuPrincipal();
				}
				else{
					
					System.out.println("Funcionário não existe!");
					MenuPrincipal();
				}
				break;
			}
			
			case 5:{
				System.out.println(
						"Instruções:\nNo campo CPF, somente informe os numeros, não é necessário digitar pontos e hífem\n"
								+ "No campo Endereço, informe od itens nessa exata ordem: Rua, numero, bairo, cidade, UF e cep. Todos tem que estar separados com vírgula e espaço.\n"
								+ "\tExemplo: Rua Manoel de Medeiros, 55, Dois Irmãos, Recife, PE, 52171900\n"
								+ "O seu login é automaticamente criado usando o seu cpf\n");
				
				String limpaBuffer = sc.nextLine();
				System.out.println("Cadastrar nova encomenda");
				System.out.println();
				System.out.println("Informações sobre o destinatário:");
				System.out.println("Nome: ");
				String nomeDest = sc.nextLine();

				System.out.println("CPF: ");
				String cpfDest = sc.nextLine();

				System.out.print("Data de Nascimento:\n" + "Dia: ");
				int diaNascimento = sc.nextInt();
				System.out.print("Mês: ");
				int mesNascimento = sc.nextInt();
				System.out.print("Ano: ");
				int anoNascimento = sc.nextInt();
				LocalDate dataDest = LocalDate.of(anoNascimento, mesNascimento, diaNascimento);

				limpaBuffer = sc.nextLine();
				System.out.println("Fone: ");
				String telefoneDest = sc.nextLine();

				System.out.println("Endereço: ");
				String endereco = sc.nextLine();
				Endereco enderecoDest = (StringParaEndereco(endereco));
				
				Pessoa dest = new Pessoa(nomeDest, cpfDest, dataDest, telefoneDest, enderecoDest);
				
				
				System.out.println("Detalhes sobre o produto:");
				System.out.println("Tipo do produto: ");
				String tipoProduto = sc.nextLine();
						
				System.out.println("Peso do produto: ");
				double pesoEncomenda = sc.nextDouble();
				
				Encomenda encomenda = new Encomenda(dest, pesoEncomenda, tipoProduto);
				bugentregas.novaEncomenda(encomenda);
				System.out.println("Encomenda cadastrada com sucesso!");
				System.out.println(encomenda);
				MenuPrincipal();
				break;
			}
			
			
			case 6:{
				String limpaBuffer = sc.nextLine();
				System.out.println("Atualiza o status de uma encomenda");
				System.out.println("Selecione a encomenda pelo código: ");
				long busca = sc.nextLong();
				
				Encomenda atualiza = bugentregas.buscaEncomenda(busca);
				if(atualiza != null){
					System.out.println("Informe o status atual\n");
					System.out.println("Data de Atualização: ");
					System.out.print("Dia: ");
					int dia = sc.nextInt();
					System.out.print("Mês: ");
					int mes = sc.nextInt();
					System.out.print("Ano");
					int ano = sc.nextInt();
					System.out.print("Hora: ");
					int hora = sc.nextInt();
					System.out.print("Minuto");
					int min = sc.nextInt();
					
					LocalDateTime dataHora = LocalDateTime.of(ano, mes, dia, hora, min);
					
					System.out.println("\n");
					System.out.println("Local atual da encomenda\n");;
					System.out.print("Rua: ");
					String ruaEnc = sc.nextLine();
					System.out.print("Numero: ");
					int numEnc = sc.nextInt();
					System.out.print("Bairro: ");
					String bairroEnc = sc.nextLine();
					System.out.print("Cidade: ");
					String cidadeEnc = sc.nextLine();
					System.out.print("Estado: ");
					String estadoEnc = sc.nextLine();
					
					Endereco endEnc = new Endereco(ruaEnc, bairroEnc, cidadeEnc, estadoEnc, estadoEnc, numEnc);
					
					System.out.println("Situação da encomenda: ");
					String situacao = sc.nextLine();
					
					Rastreio rastreio = new Rastreio(situacao, endEnc, dataHora);
					
					atualiza.atualizaRelatorio(rastreio);
					bugentregas.atualizaEncomenda(atualiza);
					System.out.println("Status da encomenda atualizado!");
					MenuPrincipal();
				}
				break;
			}
			
			case 7:{
				String limpaBuffer = sc.nextLine();
				System.out.println("Visualizar rastreio de encomenda");
				System.out.println("Buscar pelo código de rastreio");
				long codigo = sc.nextLong();
				
				Encomenda verEncomenda = bugentregas.buscaEncomenda(codigo);
				if(verEncomenda != null){
					
					System.out.println("Detalhes da encomenda: ");
					System.out.println(verEncomenda);
					System.out.println("Status da encomenda: ");
					System.out.println(verEncomenda.getRastreio());
					MenuPrincipal();
				}
				else{
					System.out.println("Encomenda não existe!");
					MenuPrincipal();
				}
				break;
			}
			
			
			case 8:{
				
				sc.close();
				break;
			}
			}
		} while (fecha != true);

	}

	Endereco StringParaEndereco(String endereco) {
		String separa[] = new String[6];
		separa = endereco.split(", ");

		String rua = separa[0];
		int numero = Integer.parseInt(separa[1]);
		String bairro = separa[2];
		String cidade = separa[3];
		String estado = separa[4];
		String cep = separa[5];

		Endereco resultado = new Endereco(rua, bairro, cidade, estado, cep, numero);

		return resultado;
	}
}
