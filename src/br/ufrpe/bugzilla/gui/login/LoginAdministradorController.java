package br.ufrpe.bugzilla.gui.login;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.colecoes.TipoDeFuncionario;
import br.ufrpe.bugzilla.dao.RepositorioFuncionario;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.gui.telas.TelaInicial;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
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

public class LoginAdministradorController implements Initializable{
	
	//guarda o nome de quem logou
		private static String nome;

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
		
		//Admin Definido para Testes já salvo em arquivo
				/*Endereco endereco  = new Endereco();
				Funcionario func = new Funcionario("Diego", "12145847512", "15/08/2120", "88664646",
						endereco, 1.800, new Usuario("diego","admin"), TipoDeFuncionario.ADM);
				try {
					Fachada.getInstance().addFuncionario(func);
					RepositorioFuncionario.getInstance().salvaArquivo();
				} catch (ObjectJaExisteException e1) {
					
					e1.printStackTrace();
				}*/
		
		if(login.equals("") || senha.equals("")){
			erro.setText("Preencha os campos corretamente!");
		}
		else if(Fachada.getInstance().verificaLoginADM(new Usuario(login,senha))){
			erro.setText("");
			//recebe o nome de quem logou
			nome = Fachada.getInstance().nomePorLoginADM(new Usuario(login,senha));
			((Node) (event.getSource())).getScene().getWindow().hide();
			Parent p = null;
			try {
				p = FXMLLoader.load(TelaInicial.class.getResource("TelaInicial.fxml"));
				Scene scene = new Scene(p);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setTitle("Bugzilla Encomendas");
				stage.setResizable(false);
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
		//((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(p);
			Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();;
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
	
	//get do nome de quem logou
	public static String getNome() {
		return nome;
	}

	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
