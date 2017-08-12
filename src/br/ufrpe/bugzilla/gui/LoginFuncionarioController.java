package br.ufrpe.bugzilla.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginFuncionarioController implements Initializable{

	@FXML
	private JFXPasswordField senha_func;
	@FXML
	private JFXTextField login_func;
	@FXML
	private JFXButton entrar_func, voltar_func;
	@FXML
	private Label erro_func;
	
	
	@FXML
	private void entrarFunc(ActionEvent event){
		String login, senha;
		
		login = login_func.getText();
		senha = senha_func.getText();
		
		if(login_func.getText().equals("") || senha_func.getText().equals("")){
			erro_func.setText("Preencha os campos corretamente!");
		
		}else if(login.equalsIgnoreCase("funcionario") && senha.equals("4321")){
			erro_func.setText("Foi");
			((Node) (event.getSource())).getScene().getWindow().hide();
			Parent p = null;			
			try {
				p = FXMLLoader.load(getClass().getResource("MenuFuncionario.fxml"));
				Scene scene = new Scene(p);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setTitle("Bugzilla Encomendas");
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			erro_func.setText("Inválido!\nTente Novamente!");
		}
	}
	
	@FXML
	private void voltarFunc(ActionEvent event){
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
