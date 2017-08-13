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

public class LoginController implements Initializable{

	@FXML
	private JFXButton adm_login;
	@FXML
	private JFXButton func_login;
	@FXML
	private Label erro_tela;
	
	
	@FXML
	public void loginAdm(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
        Parent p1 = null;
        try {
			p1 = FXMLLoader.load(getClass().getResource("LoginAdministrador.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void loginFunc(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p1 = null;
        try {
			p1 = FXMLLoader.load(getClass().getResource("LoginFuncionario.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void erro_tela(ActionEvent event){
		
	}
	
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}