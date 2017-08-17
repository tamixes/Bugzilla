package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.dao.RepositorioLocal;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.bugzilla.negocio.beans.Local;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class AtualizarLocaisController implements Initializable {
	@FXML
	private JFXTextField nome_local, latitude_local, longitude_local;
	@FXML
	private TableView<Local> tabela_local;
	@FXML
	private JFXButton atualizar_local, remover_local;
	@FXML
	private TableColumn<Local, String> nome;
	@FXML
	private TableColumn<Local, String> latitude;
	@FXML
	private TableColumn<Local, String> longitude;
	
	private ObservableList<Local> locais;
	private Local l;
	private Fachada controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controller = Fachada.getInstance();
		tabela_local.setEditable(false);
		locais = FXCollections.observableArrayList(controller.listarLocais());
		
		nome = new TableColumn<>("nome");
		nome.setResizable(true);
		
		latitude = new TableColumn<>("latitude");
		latitude.setResizable(true);
		
		longitude = new TableColumn<>("longitude");
		longitude.setResizable(true);
		
		tabela_local.getColumns().addAll(nome, latitude, longitude);
		
		nome.setCellValueFactory(new PropertyValueFactory<Local, String>("nome"));
		latitude.setCellValueFactory(new PropertyValueFactory<Local, String>("latitude"));
		longitude.setCellValueFactory(new PropertyValueFactory<Local, String>("longitude"));
		
		tabela_local.setItems(locais);
		
		tabela_local.setOnMouseClicked(e ->{
			l = tabela_local.getSelectionModel().getSelectedItem();
			nome_local.setText(l.getNome());
			nome_local.setEditable(true);
		//	latitude_local.setText(l.getLatitude());
		//	latitude_local.setEditable(true);
		//	longitude_local.setText(l.getLongitude());
		//	longitude_local.setEditable(true);
		});
	}
	
	@FXML
	public void atualizarLocal(ActionEvent event){
		String nome, latitude, longitude; 
		nome = nome_local.getText();
		latitude = latitude_local.getText();
		longitude = longitude_local.getText();
		
		try {
			double lat, log; 
			lat = Double.parseDouble(latitude);
			log = Double.parseDouble(longitude);
			
			Local local = new Local(nome, lat, log);
			try {
				Fachada.getInstance().atualizarLocal(local);
				RepositorioLocal.getinstance().salvaArquivo();
				this.atualizarLista();
				
			} catch (ObjectNaoExisteException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a ação");
				alert.setContentText("Local ja existe!");
				alert.showAndWait();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@FXML 
	public void removerLocal(ActionEvent event){
		
		String nome;
		nome = nome_local.getText();
		
		try {
			
			try {
				Fachada.getInstance().removerLocal(nome);
				this.atualizarLista();
				RepositorioLocal.getinstance().salvaArquivo();
			} catch (ObjectNaoExisteException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Impossivel realizar a ação");
				alert.setContentText("Local ja existe!");
				alert.showAndWait();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	public void atualizarLista(){
		tabela_local.getItems().clear();
		tabela_local.getItems().addAll(this.controller.listarLocais());
	}

}
