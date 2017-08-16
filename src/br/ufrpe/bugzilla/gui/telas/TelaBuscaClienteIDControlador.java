package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.colecoes.TipoCliente;
import br.ufrpe.bugzilla.dao.RepositorioCliente;
import br.ufrpe.bugzilla.dao.RepositorioEncomenda;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.gui.login.Login;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaBuscaClienteIDControlador implements Initializable {
	private String guardaId;
	@FXML
	private JFXTextField txt_busca;
	@FXML
	private Label aviso, pega_id;
	@FXML
	private JFXButton btn_buscar, btn_cancela, btn_cadastra; 
	
	
	@FXML
	public void buscaID(ActionEvent event) {
		int id = 0;
		Cliente cliente = new Cliente();
		String idd = txt_busca.getText();
		guardaId = txt_busca.getText();
		if(!txt_busca.getText().equals("")) {
			id = Integer.parseInt(txt_busca.getText());
			try {
			cliente = Fachada.getInstance().procurarCliente(id);
			aviso.setText(cliente.toString());
			btn_cadastra.setVisible(true);
			} catch(ObjectNaoExisteException e) {
				System.out.println(e.getMessage());
				aviso.setText("Cliente não Existe!");
				btn_cadastra.setVisible(false);
			}
			catch(NullPointerException e) {
				System.out.println(e.getMessage());
				aviso.setText("Cliente não Existe!");
				btn_cadastra.setVisible(false);
			}
			catch(NumberFormatException e) {
				System.out.println(e.getMessage());
				aviso.setText("ID inválido!");
				btn_cadastra.setVisible(false);
			}
		} else {
			aviso.setText("ID Inválido");
			btn_cadastra.setVisible(false);
		}
		
	}
	
	@FXML
	public void iniciaCadastro(ActionEvent event){
		Parent p1 = null;
		CadastroEncomendaControlador controle = new CadastroEncomendaControlador();
		//controle.setID(guardaId);
			
		try{		
			p1 =FXMLLoader.load(getClass().getResource("CadastroEncomenda.fxml"));
			Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			
			stage.setTitle("Bugzilla Encomendas");
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public void voltarEncomenda(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(Login.class.getResource("Login.fxml"));
			Scene scene = new Scene(p);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void pegaId(String id) {
		this.pega_id.setText(id);
	}
	public void initialize(URL location, ResourceBundle resources) {		
		btn_cadastra.setVisible(false);
	}

	
}