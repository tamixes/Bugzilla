package br.ufrpe.bugzilla.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.ufrpe.bugzilla.gui.login.LoginFuncionarioController;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaCentralPraFuncionarioController implements Initializable{
	@FXML
	private ImageView home;
	@FXML
	private ImageView encBtn;
	@FXML
	private ImageView clienteBtn;
	@FXML
	private Label nomeFuncOuAdm;
	@FXML
	private JFXButton add_central;
	@FXML
	private JFXButton remover_central;
	@FXML
	private JFXButton alterar_central;
	@FXML
	private JFXButton buscar_central;

	// Event Listener on ImageView[#home].onMouseClicked
	@FXML
	public void home(MouseEvent event) {

		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("TelaInicialFuncionario.fxml"));
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
			p1 = FXMLLoader.load(getClass().getResource("TelaEncomendaPraFuncionario.fxml"));
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
			p1 = FXMLLoader.load(getClass().getResource("TelaClientePraFuncionario.fxml"));
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
	// Event Listener on JFXButton[#add_central].onAction
	@FXML
	public void addCentral(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("CadastroLocal.fxml"));
			Stage stage = new Stage();
			//bloqueia outras janelas
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			Image icon = new Image("bug.png");
		    stage.getIcons().add(icon);
			stage.setResizable(false);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on JFXButton[#remover_central].onAction
	@FXML
	public void removerCentral(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("RemoveCentral.fxml"));
			Stage stage = new Stage();
			//bloqueia outras janelas
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			Image icon = new Image("bug.png");
		    stage.getIcons().add(icon);
			stage.setResizable(false);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on JFXButton[#alterar_central].onAction
	@FXML
	public void alterarCentral(ActionEvent event) {

		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("AtualizarLocais.fxml"));
			Stage stage = new Stage();
			//bloqueia outras janelas
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			Image icon = new Image("bug.png");
		    stage.getIcons().add(icon);
			stage.setResizable(false);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on JFXButton[#buscar_central].onAction
	@FXML
	public void buscarCentral(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("BuscarLocal.fxml"));
			Stage stage = new Stage();
			//bloqueia outras janelas
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			Image icon = new Image("bug.png");
		    stage.getIcons().add(icon);
			stage.setResizable(false);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		
		this.nomeFuncOuAdm.setText(LoginFuncionarioController.getNome());
	}
}
