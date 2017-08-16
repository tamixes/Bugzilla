package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PesquisarFuncionarioController implements Initializable{
	
	@FXML
	private JFXTextField cpf_func;
	@FXML
	private Label aviso,syso;
	@FXML
	private JFXButton pesquisar_func; 
	
	
	@FXML
	public void pesquisarFunc(ActionEvent event){
		if(this.cpf_func.getText().isEmpty()){
			this.aviso.setText("Informe um cpf!");
		}else{
			try {
				Funcionario f = Fachada.getInstance().buscarFuncionario(this.cpf_func.getText());
				this.aviso.setText("");
				this.syso.setText(f.toString());
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
