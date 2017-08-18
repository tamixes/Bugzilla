package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.dao.RepositorioEncomenda;
import br.ufrpe.bugzilla.dao.RepositorioFuncionario;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Local;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class RemoveFuncionarioController implements Initializable{
	
	@FXML
	private JFXTextField cpf;
	@FXML
	private Label aviso,sysout;
	@FXML
	private JFXButton pesquisar, remover; 
	
	@FXML
	public void pesquisar(ActionEvent event){
		
		if(this.cpf.getText().isEmpty()){
			this.aviso.setText("Digite um nome para busca...");
		}else{
			try{
				Local l = Fachada.getInstance().procurarLocal(this.cpf.getText());
				this.aviso.setText("");
				this.sysout.setText(l.toString());
				this.remover.setVisible(true);
				
			}catch(ObjectNaoExisteException e){
				System.out.println(e.getMessage());
				this.aviso.setText("Não encontrado!");
			}
		}
	}
	
	@FXML
	public void remover(ActionEvent event) {
		
		try {
			Fachada.getInstance().removerFuncionario(this.cpf.getText());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Funcionário Removido com sucesso!");
			alert.setTitle("Funcionário Removido");
			alert.showAndWait();
			RepositorioFuncionario.getInstance().salvaArquivo();
			((Node) (event.getSource())).getScene().getWindow().hide();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erro: " + e.getMessage());
		}
		
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		remover.setVisible(false);
	}


}
