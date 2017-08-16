package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PesquisarClienteControllador implements Initializable{
	
	@FXML
	private JFXTextField nome_cliente;
	@FXML
	private Label aviso,sysout;
	@FXML
	private JFXButton pesquisar_cliente; 
	
	@FXML
	public void pesquisarCliente(ActionEvent event){
		
		if(this.nome_cliente.getText().isEmpty()){
			this.aviso.setText("Digite um nome para busca...");
		}else{
			try{
				Cliente c = Fachada.getInstance().procurarCliente(this.nome_cliente.getText());
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
