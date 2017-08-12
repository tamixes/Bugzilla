package br.ufrpe.bugzilla.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuFuncionarioController implements Initializable{

	
	@FXML
	private JFXButton add_cliente, buscar_cliente, alterar_cliente, listar_cliente, remover_cliente;
	@FXML
	private JFXButton add_enc, buscar_enc, alterar_enc, listar_enc, remover_enc;
	@FXML
	private JFXButton add_central, buscar_central, alterar_central, listar_central, remover_central;
	@FXML
	private JFXButton voltar_login;
	@FXML
	private Label erro_menu;
	
	
	//CLIENTE
	
	@FXML
	public void addCliente(ActionEvent event){
		
	}
	
	@FXML
	public void buscarCliente(ActionEvent event){
		
	}
	
	@FXML
	public void alterarCliente(ActionEvent event){
		
	}
	@FXML
	public void listarCliente(ActionEvent event){
		
	}
	
	@FXML
	public void removerCliente(ActionEvent event){
		
	}
	
	
	
	//ENCOMENDA
	
	@FXML
	public void addEnc(ActionEvent event){
		
	}
	
	@FXML
	public void buscarEnc(ActionEvent event){
		
	}
	
	@FXML
	public void alterarEnc(ActionEvent event){
		
	}
	@FXML
	public void listarEnc(ActionEvent event){
		
	}
	
	@FXML
	public void removerEnc(ActionEvent event){
		
	}
	
	
	
	//CENTRAIS
	
	
	@FXML
	public void addCentral(ActionEvent event){
		
	}
	
	@FXML
	public void buscarCentral(ActionEvent event){
		
	}
	
	@FXML
	public void alterarCentral(ActionEvent event){
		
	}
	@FXML
	public void listarCentral(ActionEvent event){
		
	}
	
	@FXML
	public void removerCentral(ActionEvent event){
		
	}
	
	
	@FXML
	public void voltarLogin(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(getClass().getResource("LoginFuncionario.fxml"));
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
		
		
	}

}
