package br.ufrpe.bugzilla.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Usuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
		
		/*Funcionario Definido para Testes j� salvo em arquivo
		Endereco endereco  = new Endereco();
		Funcionario func = new Funcionario("Tamires", "12581069490", LocalDate.now(), "88664646",
				endereco, 1.800, new Usuario("tamires","12345"), TipoDeFuncionario.FUNC);
		try {
			Fachada.getInstance().addFuncionario(func);
			RepositorioFuncionario.getInstance().salvaArquivo();
		} catch (ObjectJaExisteException e1) {
			
			e1.printStackTrace();
		}*/
		
		if(login.equals("") || senha.equals("")){
			erro_func.setText("Preencha os campos corretamente!");
		
		}else if(Fachada.getInstance().verificaLoginFuncionario(new Usuario(login,senha))){
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
			erro_func.setText("Inv�lido!\nTente Novamente!");
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
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	public void close(MouseEvent event){
		Platform.exit();
	}
	
	
	
	
	
	
	
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
