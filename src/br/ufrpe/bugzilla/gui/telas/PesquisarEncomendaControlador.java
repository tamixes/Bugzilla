package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import br.ufrpe.bugzilla.negocio.beans.Encomenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PesquisarEncomendaControlador implements Initializable{
	
	@FXML
	private JFXTextField cod_encomenda;
	@FXML
	private Label aviso,sysout;
	@FXML
	private JFXButton pesquisar_encomenda; 
	
	@FXML
	public void pesquisarCliente(ActionEvent event){
		
		if(this.cod_encomenda.getText().isEmpty()){
			this.aviso.setText("Digite um nome para busca...");
		}else{
			try{
				Encomenda c = Fachada.getInstance().buscaEncomenda(this.cod_encomenda.getText());
				this.aviso.setText("");
				this.sysout.setText(c.toString());
			}catch(ObjectNaoExisteException e){
				System.out.println(e.getMessage());
				this.aviso.setText("Não encontrado!");
			}
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
