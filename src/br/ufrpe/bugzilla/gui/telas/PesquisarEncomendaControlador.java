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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PesquisarEncomendaControlador implements Initializable{
	
	public static String codigo;
	
	public static String getCodigo() {
		return codigo;
	}

	@FXML
	private JFXTextField cod_encomenda;
	@FXML
	private Label aviso,sysout;
	@FXML
	private JFXButton pesquisar_encomenda, rastrear; 
	
	@FXML
	public void pesquisarEncomenda(ActionEvent event){
		
		if(this.cod_encomenda.getText().isEmpty()){
			this.aviso.setText("Digite um código para busca...");
		}else{
			try{
				Encomenda c = Fachada.getInstance().buscaEncomenda(this.cod_encomenda.getText());
				codigo = cod_encomenda.getText();
				this.aviso.setText("");
				this.sysout.setText(c.toString());
				rastrear.setVisible(true);
			}catch(ObjectNaoExisteException e){
				System.out.println(e.getMessage());
				this.aviso.setText("Não encontrado!");
			}
		}
	}
	
	@FXML
	public void rastrear(ActionEvent event){
		Parent p1 = null;
		
		try{
			p1 = FXMLLoader.load(getClass().getResource("RastreioEncomenda.fxml"));
			Stage stage = new Stage();
			//bloqueia outras janelas
			stage.initModality(Modality.APPLICATION_MODAL);
			Scene scene = new Scene(p1);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.setResizable(false);
			stage.show();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		rastrear.setVisible(false);
	}

}
