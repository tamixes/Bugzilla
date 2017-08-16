package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Local;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PesquisarLocalController implements Initializable {


	@FXML
	private JFXTextField nome_local;
	@FXML
	private Label aviso,syso;
	@FXML
	private JFXButton pesquisar_local; 
	
	
	@FXML
	public void pesquisarLocal(ActionEvent event){
		if(this.nome_local.getText().isEmpty()){
			this.aviso.setText("Informe um nome!");
		}else{
			try {
				Local l = Fachada.getInstance().procurarLocal(this.nome_local.getText());
				this.aviso.setText("");
				this.syso.setText(l.toString());
				
			} catch (ObjectNaoExisteException e) {
				System.out.println(e.getMessage());
				this.aviso.setText("Não encontrado!");
			}
		}
	}
	
	
	
	
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
