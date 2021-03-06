package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;


import br.ufrpe.bugzilla.gui.login.LoginAdministradorController;
import br.ufrpe.bugzilla.negocio.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable {
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
	private Label numFunc;
	@FXML
	private Label numCliente;
	@FXML
	private Label numCentral;
	@FXML
	private Label numEnc;

	// Event Listener on ImageView[#home].onMouseClicked
	@FXML
	public void home(MouseEvent event) {
		//faz nada
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
	// Event Listener on ImageView[#encBtn].onMouseClicked
	@FXML
	public void encOpcoes(MouseEvent event) {

		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("TelaEncomenda.fxml"));
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
	@FXML
	public void info(MouseEvent event){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Diego Patrik\nTamires Carvalho\nThyerry Nunes");
		alert.setTitle("Cr�ditos");
		alert.showAndWait();
	}
	
	
	public void initialize(URL location, ResourceBundle resources) {
		
		
		this.numCentral.setText(String.valueOf(Fachada.getInstance().contadorCentral()));
		this.numCliente.setText(String.valueOf(Fachada.getInstance().contadorCliente()));
		this.numEnc.setText(String.valueOf(Fachada.getInstance().contadorEncomenda()));
		this.numFunc.setText(String.valueOf(Fachada.getInstance().contadorFuncionario()));
		
		this.nomeFuncOuAdm.setText(LoginAdministradorController.getNome());
		
	}
}
