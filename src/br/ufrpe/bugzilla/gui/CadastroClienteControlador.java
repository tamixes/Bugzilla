package br.ufrpe.bugzilla.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CadastroClienteControlador implements Initializable {

	@FXML
	private JFXTextField nome_cliente, cnpj_cliente, cpf_cliente, telefone_cliente, rua_cliente;
	@FXML
	private JFXTextField bairro_cliente, cidade_cliente, numero_cliente, estado_cliente;
	@FXML
	private Label aviso;
	@FXML
	private JFXButton enviar_cliente, voltar_cliente; 
	
	@FXML
	public void enviarCliente(ActionEvent event){
		
	}
	
	@FXML
	public void voltarCliente(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(p);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
}
