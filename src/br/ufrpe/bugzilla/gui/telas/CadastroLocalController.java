package br.ufrpe.bugzilla.gui.telas;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.dao.RepositorioLocal;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.gui.login.Login;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Local;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CadastroLocalController implements Initializable{
	
	@FXML
	private JFXTextField nome_local, lat_local, long_local;
	@FXML
	private Label aviso;
	@FXML
	private JFXButton voltar_local, enviar_local, site;
	
	
	@FXML
	public void enviarLocal(ActionEvent event){
		String nome, latitude, longitude;
		
		nome = nome_local.getText();
		latitude = lat_local.getText();
		longitude = long_local.getText();
		
		if(!nome.equals("") && !latitude.equals("") && !longitude.equals("")){
			try {
				double lat = Double.parseDouble(latitude);
				double longi = Double.parseDouble(longitude);
				
				Local local = new Local(nome, lat, longi);
				
				try {
					Fachada.getInstance().cadastrarLocal(local);
					RepositorioLocal.getinstance().salvaArquivo();
					System.out.println("Salvo");
					((Node) (event.getSource())).getScene().getWindow().hide();
				} catch (ObjectJaExisteException e) {
					
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao cadastrar!");
					alert.setContentText("Local já existe!");
					alert.showAndWait();
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else{
			aviso.setText("Preencha todos os campos!");
		}
	}
	
	
	@FXML
	public void voltarLocal(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(Login.class.getResource("TelaCentral.fxml"));
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
	public void entrar_site(ActionEvent event){
		
		URI link = null;
		try {
			link = new URI("www.mapcoordinates.net/pt");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			Desktop.getDesktop().browse(link);
		} catch (IOException e) {
			System.out.println("Erro ao abrir link");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
