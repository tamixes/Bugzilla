package br.ufrpe.bugzilla.gui;


import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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

public class LoginAdministradorController implements Initializable{

	@FXML
	private JFXTextField login_adm;
	@FXML
	private JFXPasswordField senha_adm;
	@FXML 
	private JFXButton entrar_adm, voltar_adm;
	@FXML
	private Label erro;
	
	@FXML
	private void entrarAdm(ActionEvent event){
		String login, senha;
		login = login_adm.getText();
		senha = senha_adm.getText();
		if(login.equalsIgnoreCase("") || senha.equals("")){
			erro.setText("Preencha os campos corretamente!");
		}
		else if(login.equalsIgnoreCase("tamixes") && senha.equals("1234")){
			erro.setText("");
			((Node) (event.getSource())).getScene().getWindow().hide();
			Parent p = null;
			try {
				p = FXMLLoader.load(getClass().getResource("MenuAdministrador.fxml"));
				Scene scene = new Scene(p);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setTitle("Bugzilla Encomendas");
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			erro.setText("Inválido!\nTente Novamente!");
		}
	}
	
	@FXML
	private void voltarAdm(ActionEvent event){
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
		
		
	}

}
