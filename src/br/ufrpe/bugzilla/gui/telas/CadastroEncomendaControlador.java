package br.ufrpe.bugzilla.gui.telas;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.colecoes.TipoCliente;
import br.ufrpe.bugzilla.dao.RepositorioCliente;
import br.ufrpe.bugzilla.dao.RepositorioEncomenda;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.gui.login.Login;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import br.ufrpe.bugzilla.negocio.beans.Local;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.GeraPDF;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CadastroEncomendaControlador implements Initializable {
	
	@FXML
	private JFXTextField peso_enc, tipo_enc, prazo_enc;
	@FXML
	private Label aviso, dados, info_dest, end_dest, dados_enc;
	@FXML
	private JFXButton enviar_encomenda, volta_encomenda2;
	@FXML
	private JFXDatePicker prazo;
	@FXML
	private ComboBox<Local> destino, partida;
	@FXML
	private ComboBox<Cliente> remetente, destinatario;
	

	@FXML
	public void enviarEncomenda(ActionEvent event) {
		

		String peso = peso_enc.getText();
		String prazo = prazo_enc.getText();
		String tipo = tipo_enc.getText();

		if (!peso.equals("")
				&& !prazo.equals("") && !tipo.equals("") && remetente.getValue()!=null && remetente.getValue()!=null 
				&& destinatario.getValue()!=null && partida.getValue()!=null && destino.getValue()!=null ) {
			try {
				double pesoDouble = Double.parseDouble(peso);
				int prazoDias = Integer.parseInt(prazo);
				
				
				//TODO Colocar o local no constrututor da encomenda
				Encomenda encomenda = new Encomenda(remetente.getValue(), destinatario.getValue(), pesoDouble, tipo, partida.getValue(), destino.getValue(), prazoDias);
				try {
					Fachada.getInstance().novaEncomenda(encomenda);
					//teste
					RepositorioEncomenda.getInstance().salvaArquivo();
					System.out.println("Salvo");
					((Node) (event.getSource())).getScene().getWindow().hide();
					
					//gera pdf
					try{
					GeraPDF.geradorPDF(encomenda);
					
					}catch(Exception e){
						System.out.println("Erro ao salvar PDF: " + e.getMessage());
					}
					
				} catch(ObjectJaExisteException e) {
					
				}
			} catch(Exception e) {
				
			}
		} else {
			aviso.setText("Preencha todos os campos!");
		}

	}

	@FXML
	public void voltarEncomenda(ActionEvent event) {
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

	public void initialize(URL location, ResourceBundle resources) {
		//
		
		//evita que apareça todo o toString do objeto
			Callback<ListView<Local>, ListCell<Local>> factory = new Callback<ListView<Local>, ListCell<Local>>() {
				public ListCell<Local> call(ListView<Local> lv) {
					return new ListCell<Local>() {

					    @Override
					    protected void updateItem(Local item, boolean empty) {
					        super.updateItem(item, empty);
					        setText(empty ? "" : item.getNome());
					    }

					};
				}
			};
			
			partida.setItems(FXCollections.observableArrayList(Fachada.getInstance().listarLocais()));
			partida.setCellFactory(factory);
			partida.setButtonCell(factory.call(null));
			
			destino.setItems(FXCollections.observableArrayList(Fachada.getInstance().listarLocais()));
			destino.setCellFactory(factory);
			destino.setButtonCell(factory.call(null));
			
			//evita que apareça todo o toString do objeto
			Callback<ListView<Cliente>, ListCell<Cliente>> factory2 = new Callback<ListView<Cliente>, ListCell<Cliente>>() {
				public ListCell<Cliente> call(ListView<Cliente> lv) {
					return new ListCell<Cliente>() {

					    @Override
					    protected void updateItem(Cliente item, boolean empty) {
					        super.updateItem(item, empty);
					        setText(empty ? "" : item.getNome());
					    }

					};
				}
			};
			
			remetente.setItems(FXCollections.observableArrayList(Fachada.getInstance().listarClientes()));
			remetente.setCellFactory(factory2);
			remetente.setButtonCell(factory2.call(null));
			
			destinatario.setItems(FXCollections.observableArrayList(Fachada.getInstance().listarClientes()));
			destinatario.setCellFactory(factory2);
			destinatario.setButtonCell(factory2.call(null));
		
	}

}
