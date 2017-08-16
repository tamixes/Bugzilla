package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.itextpdf.text.log.SysoCounter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class RemoverEncomendaControlador implements Initializable{
	
	@FXML
	private JFXTextField cod_encomenda;
	@FXML
	private Label aviso,sysout;
	@FXML
	private JFXButton pesquisar_encomenda, remover_encomenda; 
	
	@FXML
	public void pesquisarEncomenda(ActionEvent event){
		
		if(this.cod_encomenda.getText().isEmpty()){
			this.aviso.setText("Digite um código para busca...");
		}else{
			try{
				Encomenda c = Fachada.getInstance().buscaEncomenda(this.cod_encomenda.getText());
				this.aviso.setText("");
				this.sysout.setText(c.toString());
				this.remover_encomenda.setVisible(true);
				
			}catch(ObjectNaoExisteException e){
				System.out.println(e.getMessage());
				this.aviso.setText("Não encontrado!");
			}
		}
	}
	
	@FXML
	public void removerEncomenda(ActionEvent event) {
		
		try {
			Fachada.getInstance().removeEncomenda(cod_encomenda.getText());
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Encomenda Removida!");
			alert.setTitle("Encomenda Removida");
			alert.showAndWait();
			
			((Node) (event.getSource())).getScene().getWindow().hide();
		} catch(Exception e) {
			e.getStackTrace();//
		}
		
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		remover_encomenda.setVisible(false);
		
	}

}
