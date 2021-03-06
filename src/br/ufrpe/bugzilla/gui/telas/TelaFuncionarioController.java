package br.ufrpe.bugzilla.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.ufrpe.bugzilla.gui.login.LoginAdministradorController;
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

public class TelaFuncionarioController implements Initializable{
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
	private JFXButton add_func;
	@FXML
	private JFXButton buscar_func;
	@FXML
	private JFXButton alterar_func;
	@FXML
	private JFXButton remover_func;

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
	// Event Listener on JFXButton[#add_func].onAction
	@FXML
	public void addFunc(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("CadastroFuncionario.fxml"));
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
	// Event Listener on JFXButton[#buscar_func].onAction
	@FXML
	public void buscarFunc(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("BuscarFuncionario.fxml"));
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
	// Event Listener on JFXButton[#alterar_func].onAction
	@FXML
	public void alterarFunc(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("AtualizarFuncionario.fxml"));
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
	// Event Listener on JFXButton[#remover_func].onAction
	@FXML
	public void removerFunc(ActionEvent event) {
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("RemoveFuncionario.fxml"));
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
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.nomeFuncOuAdm.setText(LoginAdministradorController.getNome());
	}
}
