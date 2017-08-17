package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import br.ufrpe.bugzilla.dao.RepositorioEncomenda;
import br.ufrpe.bugzilla.exceptions.ObjectNaoExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Rastreio;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;

public class RastreioEncomendaController implements Initializable{
	
	@FXML
	private JFXTextField situacao,local;
	@FXML
	private ListView<Rastreio> lista;
	@FXML
	private JFXButton adicionar, remover;
	@FXML
	private CheckBox entregue;
	
	@FXML
	public void adicionar(ActionEvent event){
		
		try {
			Fachada.getInstance().buscaEncomenda(PesquisarEncomendaControlador.getCodigo()).atualizaRelatorio(situacao.getText(), local.getText(), LocalDateTime.now());
			if(entregue.isSelected()){
				Fachada.getInstance().buscaEncomenda(PesquisarEncomendaControlador.getCodigo()).setEntregue();
			}
			RepositorioEncomenda.getInstance().salvaArquivo();
			try {
				lista.setItems(FXCollections.observableArrayList(Fachada.getInstance().buscaEncomenda(PesquisarEncomendaControlador.getCodigo()).getRastreio()));
			} catch (ObjectNaoExisteException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} catch (ObjectNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void remover(ActionEvent event){
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			lista.setItems(FXCollections.observableArrayList(Fachada.getInstance().buscaEncomenda(PesquisarEncomendaControlador.getCodigo()).getRastreio()));
		} catch (ObjectNaoExisteException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
