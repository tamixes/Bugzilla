package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class ListaEncomendasControlador implements Initializable{
	
	@FXML
	private Label aviso;
	@FXML
	private TableView<Encomenda> lista_enc;
	@FXML
	private TableColumn<Encomenda, String> remetente;
	@FXML
	private TableColumn<Encomenda, String> destinatario;
//	@FXML
//	private TableColumn<Encomenda, String> codigo;
	@FXML
	private ObservableList<Encomenda> encomenda;
	
	private Encomenda enc;
	private Fachada controller;

	public void initialize(URL arg0, ResourceBundle arg1) {
		controller = Fachada.getInstance();
		lista_enc.setEditable(false);
		encomenda = FXCollections.observableArrayList(controller.listaDeEncomendas());
		
		remetente =  new TableColumn<>("Remetente");
		remetente.setResizable(true);
		
		destinatario =  new TableColumn<>("Destinatario");
		destinatario.setResizable(true);
		
		lista_enc.getColumns().addAll(remetente, destinatario);
		
		remetente.setCellValueFactory(new PropertyValueFactory<Encomenda, String>("Remetente"));
		destinatario.setCellValueFactory(new PropertyValueFactory<Encomenda, String>("Destinatario"));

		
		lista_enc.setItems(encomenda);
	}

}
