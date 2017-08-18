package br.ufrpe.bugzilla.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.ufrpe.bugzilla.gui.login.LoginAdministradorController;
import br.ufrpe.bugzilla.gui.login.LoginFuncionarioController;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaEncomendaController implements Initializable{
	@FXML
	private ImageView home;
	@FXML
	private ImageView funcBtn;
	@FXML
	private ImageView encBtn;
	@FXML
	private ImageView centralBtn;
	@FXML
	private ImageView clienteBtn;
	@FXML
	private Label nomeFuncOuAdm;
	@FXML
	private JFXButton buscar_enc;
	@FXML
	private JFXButton remover_enc;
	@FXML
	private JFXButton listar_enc;
	@FXML
	private JFXButton add_enc;

	// Event Listener on ImageView[#home].onMouseClicked
	@FXML
	public void home(MouseEvent event) {

		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
			Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.setResizable(false);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on ImageView[#funcBtn].onMouseClicked
	@FXML
	public void funcOpcoes(MouseEvent event) {

		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("TelaFuncionario.fxml"));
			Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.setResizable(false);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on ImageView[#centralBtn].onMouseClicked
	@FXML
	public void centralOpcoes(MouseEvent event) {

		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("TelaCentral.fxml"));
			Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.setResizable(false);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on ImageView[#clienteBtn].onMouseClicked
	@FXML
	public void clienteOpcoes(MouseEvent event) {
		
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("TelaCliente.fxml"));
			Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.setResizable(false);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on JFXButton[#buscar_enc].onAction
	@FXML
	public void buscarEnc(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("PesquisaEncomenda.fxml"));
			Stage stage = new Stage();
			
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			Image icon = new Image("bug.png");
		    stage.getIcons().add(icon);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on JFXButton[#remover_enc].onAction
	@FXML
	public void removerEnc(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("RemoveEncomenda.fxml"));
			Stage stage = new Stage();
			
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			Image icon = new Image("bug.png");
		    stage.getIcons().add(icon);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on JFXButton[#listar_enc].onAction
	@FXML
	public void listarEnc(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("ListaEncomendas.fxml"));
			Stage stage = new Stage();
			
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			Image icon = new Image("bug.png");
		    stage.getIcons().add(icon);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on JFXButton[#add_enc].onAction
	@FXML
	public void addEnc(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("CadastroEncomenda.fxml"));
			Stage stage = new Stage();
			
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			Image icon = new Image("bug.png");
		    stage.getIcons().add(icon);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		
		this.nomeFuncOuAdm.setText(LoginAdministradorController.getNome());
	}
}
