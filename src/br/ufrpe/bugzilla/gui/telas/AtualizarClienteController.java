package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.colecoes.TipoCliente;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;



public class AtualizarClienteController implements Initializable{

	@FXML
	private JFXTextField nome_cliente, cnpj_cliente, cpf_cliente, telefone_cliente, rua_cliente;
	@FXML
	private JFXTextField bairro_cliente, cidade_cliente, numero_cliente, estado_cliente, cep_cliente;
	@FXML
	private Label aviso;
	@FXML
	private JFXButton enviar_cliente, remover_cliente; 
	@FXML
	private TableView<Cliente> tabela_cliente;
	@FXML
	private TableColumn<Cliente, String> nome;
	@FXML
	private TableColumn<Cliente, String> cpf;
	
	private ObservableList<Cliente> clientes;
	
	private Cliente c;
	
	private Fachada controller; 
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		controller = Fachada.getInstance();
		tabela_cliente.setEditable(false);
		clientes = FXCollections.observableArrayList(controller.listarClientes());
		
		
		nome = new TableColumn<Cliente, String>("nome");
		nome.setResizable(true);
		
		cpf = new TableColumn<Cliente, String>("cpf");
		cpf.setResizable(true);
		
		tabela_cliente.getColumns().addAll(nome, cpf);
		
		nome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
		cpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
		
		tabela_cliente.setItems(clientes);
		
		tabela_cliente.setOnMouseClicked(e -> {

			c = tabela_cliente.getSelectionModel().getSelectedItem();
			nome_cliente.setText(c.getNome());
			nome_cliente.setEditable(false);
			cpf_cliente.setText(c.getCpf());
			cpf_cliente.setEditable(false);
			cnpj_cliente.setText(c.getCnpj());
			cnpj_cliente.setEditable(false);
			rua_cliente.setText(c.getEndereco().getRua());
			cidade_cliente.setText(c.getEndereco().getCidade());
			bairro_cliente.setText(c.getEndereco().getBairro());
			estado_cliente.setText(c.getEndereco().getEstado());
			telefone_cliente.setText(c.getTelefone());
			telefone_cliente.setEditable(false);
		});

		
	}
	@FXML
	public void enviarCliente(ActionEvent event){
		String nome, cnpj, cpf, telefone, rua, bairro, cidade, cep, estado, numero;
		
		nome = nome_cliente.getText();
		cnpj = cnpj_cliente.getText();
		cpf = cpf_cliente.getText();
		telefone = telefone_cliente.getText();
		
		rua = rua_cliente.getText();
		bairro = bairro_cliente.getText();
		cidade = cidade_cliente.getText();
		numero = numero_cliente.getText();
		estado = estado_cliente.getText();
		cep = cep_cliente.getText();
		
		try {
			int num = Integer.parseInt(numero); 
			Endereco endereco = new Endereco(rua, bairro, cidade, estado, cep, num);
			Cliente cliente = new Cliente(nome, cnpj, cpf, telefone, endereco, TipoCliente.FIS);
			
			try {
				Fachada.getInstance().atualizarCliente(cliente);
			} catch (ObjectNaoExisteException e) {
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
	public void removerCliente(ActionEvent event){
		String nome, cnpj, cpf, telefone, rua, bairro, cidade, cep, estado, numero;
		
		nome = nome_cliente.getText();
		cnpj = cnpj_cliente.getText();
		cpf = cpf_cliente.getText();
		telefone = telefone_cliente.getText();
		
		rua = rua_cliente.getText();
		bairro = bairro_cliente.getText();
		cidade = cidade_cliente.getText();
		numero = numero_cliente.getText();
		estado = estado_cliente.getText();
		cep = cep_cliente.getText();
		
		try {
			int num = Integer.parseInt(numero); 
			Endereco endereco = new Endereco(rua, bairro, cidade, estado, cep, num);
			Cliente cliente = new Cliente(nome, cnpj, cpf, telefone, endereco, TipoCliente.FIS);
			
			try {
				Fachada.getInstance().removerCliente(cliente);;
			} catch (ObjectNaoExisteException e) {
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
	private void atualizarList(){
		
		tabela_cliente.getItems().clear();
		tabela_cliente.getItems().addAll(this.controller.listarClientes());
	}
	
	
}