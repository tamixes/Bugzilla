package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.colecoes.TipoDeFuncionario;
import br.ufrpe.bugzilla.dao.RepositorioFuncionario;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.bugzilla.negocio.beans.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class AtualizarFuncionarioController implements Initializable{

	@FXML
	private JFXButton atualizar_cadastro, remover_cadastro; 
	@FXML
	private JFXTextField nome_func, cpf_func, telefone_func, rua_func, bairro_func, nascimento_func;
	@FXML
	private JFXTextField cidade_func, estado_func, cep_func, numero_func, salario_func, login_func, senha_func;
	@FXML
	private TableView<Funcionario> tabela_func;
	@FXML
	private TableColumn<Funcionario, String> nome;
	@FXML
	private TableColumn<Funcionario, String> cpf;
	
	private ObservableList<Funcionario> funcionarios;
	private Funcionario f;
	private Fachada controller;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		controller = Fachada.getInstance();
		tabela_func.setEditable(false);
		funcionarios = FXCollections.observableArrayList(controller.listarFuncionarios());
		
		
		nome = new TableColumn<>("nome");
		nome.setResizable(true);
		
		cpf = new TableColumn<>("cpf");
		cpf.setResizable(true);
		
		tabela_func.getColumns().addAll(nome, cpf);
		
		nome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		cpf.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cpf"));
		
		tabela_func.setItems(funcionarios);
		
		tabela_func.setOnMouseClicked(e ->{
		f = tabela_func.getSelectionModel().getSelectedItem();
		
		cpf_func.setText(f.getCpf());
		cpf_func.setEditable(true);
		
		telefone_func.setText(f.getTelefone());
		telefone_func.setEditable(true);
		
		nome_func.setText(f.getNome());
		nome_func.setEditable(true);
		
		rua_func.setText(f.getEnd().getRua());
		rua_func.setEditable(true);

		bairro_func.setText(f.getEnd().getBairro());
		bairro_func.setEditable(true);
		
		nascimento_func.setText(f.getDataNascimento());
		nascimento_func.setEditable(true);
		
		cidade_func.setText(f.getEnd().getCidade());
		cidade_func.setEditable(true);
		
		estado_func.setText(f.getEnd().getEstado());
		estado_func.setEditable(true);
		
		cep_func.setText(f.getEnd().getCep());
		cep_func.setEditable(true);
		
		//numero_func.setText(f.getEnd().getNumero());
		numero_func.setEditable(true);
		
		//salario_func.setText(f.getSalario());
		salario_func.setEditable(true);
		
		login_func.setText(f.getUsuario().getLogin());
		login_func.setEditable(true);
		
		senha_func.setText(f.getUsuario().getSenha());
		senha_func.setEditable(true);
		
		});
		
	}
	
	@FXML
	public void atualizarCadastro(ActionEvent event){
		
		String nome, cpf, telefone, login, senha, nascimento;
		String rua, bairro, cidade, estado, cep, numero, salario;
		
		
		nome = nome_func.getText();
		cpf = cpf_func.getText();
		telefone = telefone_func.getText();
		login = login_func.getText();
		senha = senha_func.getText();
		nascimento = nascimento_func.getText();
		
		rua = rua_func.getText();
		bairro = bairro_func.getText();
		cidade = cidade_func.getText();
		estado = estado_func.getText();
		cep = cep_func.getText();
		numero = numero_func.getText();
		salario = salario_func.getText();
		
		try {
			
			int num = Integer.parseInt(numero);
			double sal = Double.parseDouble(salario);
			Endereco end = new Endereco(rua, bairro, cidade, estado, cep, num);
			Usuario user = new Usuario(login, senha);
			Funcionario func = new Funcionario(nome, cpf, nascimento, telefone, end, sal, user, TipoDeFuncionario.FUNC);
			
			try {
				Fachada.getInstance().alterarFuncionario(func);
				
			} catch (Exception e) {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a ação");
				alert.setContentText("Cliente ja existe");
				alert.showAndWait();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	public void removerCadastro(ActionEvent event){
		String nome, cpf, telefone, login, senha, nascimento;
		String rua, bairro, cidade, estado, cep, numero, salario;
		
		
		nome = nome_func.getText();
		cpf = cpf_func.getText();
		telefone = telefone_func.getText();
		login = login_func.getText();
		senha = senha_func.getText();
		nascimento = nascimento_func.getText();
		
		rua = rua_func.getText();
		bairro = bairro_func.getText();
		cidade = cidade_func.getText();
		estado = estado_func.getText();
		cep = cep_func.getText();
		numero = numero_func.getText();
		salario = salario_func.getText();
		
		try {
			
			int num = Integer.parseInt(numero);
			double sal = Double.parseDouble(salario);
			Endereco end = new Endereco(rua, bairro, cidade, estado, cep, num);
			Usuario user = new Usuario(login, senha);
			Funcionario func = new Funcionario(nome, cpf, nascimento, telefone, end, sal, user, TipoDeFuncionario.FUNC);
			
			try {
				Fachada.getInstance().removerFuncionario(func);
				RepositorioFuncionario.getInstance().salvaArquivo();
				
			} catch (Exception e) {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a ação");
				alert.setContentText("Cliente ja existe");
				alert.showAndWait();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
		
	@FXML
	public void atualizarLista(){
		
		tabela_func.getItems().clear();
		tabela_func.getItems().addAll(this.controller.listarFuncionarios());
	}
	
}
