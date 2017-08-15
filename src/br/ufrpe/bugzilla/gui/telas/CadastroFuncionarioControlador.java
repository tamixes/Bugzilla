package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
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

public class CadastroFuncionarioControlador implements Initializable{

	@FXML
	private JFXButton voltar_cadastro, enviar_cadastro; 
	@FXML
	private JFXTextField nome_func, cpf_func, nascimento_func, telefone_func, rua_func, bairro_func;
	@FXML
	private JFXTextField cidade_func, estado_func, cep_func, numero_func, salario_func, login_func;
	@FXML
	private JFXCheckBox seta_adm;
	@FXML
	private Label aviso;
	
	@FXML
	private void voltarCadastro(ActionEvent event){
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
			System.out.println(e.getMessage());
		}
		
	}
	
	@FXML
	private void enviarCadastro(ActionEvent event){
		
	}
	
	
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
