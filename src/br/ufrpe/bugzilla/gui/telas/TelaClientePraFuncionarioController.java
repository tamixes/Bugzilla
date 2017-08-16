package br.ufrpe.bugzilla.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.ufrpe.bugzilla.gui.login.LoginFuncionarioController;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.Node;

import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaClientePraFuncionarioController implements Initializable{
	@FXML
	private ImageView home;
	@FXML
	private ImageView encBtn;
	@FXML
	private ImageView centralBtn;
	@FXML
	private Label nomeFuncOuAdm;
	@FXML
	private JFXButton listar_cliente;
	@FXML
	private JFXButton remover_cliente;
	@FXML
	private JFXButton alterar_cliente;
	@FXML
	private JFXButton buscar_cliente;
	@FXML
	private JFXButton add_cliente;

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
			p1 = FXMLLoader.load(getClass().getResource("TelaCentralPraFuncionario.fxml"));
			Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Event Listener on JFXButton[#listar_cliente].onAction
	@FXML
	public void listarCliente(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on JFXButton[#remover_cliente].onAction
	@FXML
	public void removerCliente(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on JFXButton[#alterar_cliente].onAction
	@FXML
	public void alterarCliente(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on JFXButton[#buscar_cliente].onAction
	@FXML
	public void buscarCliente(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on JFXButton[#add_cliente].onAction
	@FXML
	public void addCliente(ActionEvent event) {
		
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("CadastroCliente.fxml"));
			Stage stage = new Stage();
			//bloqueia outras janelas
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		
		this.nomeFuncOuAdm.setText(LoginFuncionarioController.getNome());
	}
}
