package br.ufrpe.bugzilla.gui.telas;

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
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CadastroEncomendaControlador implements Initializable {
	private static String id_cliente;
	@FXML
	private JFXTextField nome_destinatario, telefone_dest, rua_dest, numero_dest, cep_dest, bairro_dest, cidade_dest,
			estado_dest, peso_enc, tipo_enc, prazo_enc;
	@FXML
	private Label aviso, dados, info_dest, end_dest, dados_enc;
	@FXML
	private JFXButton enviar_encomenda, volta_encomenda2;
	@FXML
	private JFXDatePicker prazo;
	

	@FXML
	public void enviarEncomenda(ActionEvent event) {
		
		String nomeDest = nome_destinatario.getText();
		String telefoneDest = telefone_dest.getText();

		String rua = rua_dest.getText();
		String num = numero_dest.getText();
		String cep = cep_dest.getText();
		String bairro = bairro_dest.getText();
		String cidade = cidade_dest.getText();
		String estado = estado_dest.getText();

		String peso = peso_enc.getText();
		String prazo = prazo_enc.getText();
		String tipo = tipo_enc.getText();

		if (!nomeDest.equals("") && !telefoneDest.equals("") && !rua.equals("") && !num.equals("") && !cep.equals("")
				&& !bairro.equals("") && !cidade.equals("") && !estado.equals("") && !peso.equals("")
				&& !prazo.equals("") && !tipo.equals("")) {
			try {
				double pesoDouble = Double.parseDouble(peso);
				int numero = Integer.parseInt(num);
				int idRemetente = Integer.parseInt(id_cliente);
				int prazoDias = Integer.parseInt(prazo);
				Endereco end = new Endereco(rua, bairro, cidade, estado, cep, numero);
				Fachada.getInstance().procurarCliente(idRemetente);
				
				
				Cliente destinatario = new Cliente(nomeDest, null, null, telefoneDest, end, TipoCliente.FIS);
				Cliente remetente = Fachada.getInstance().procurarCliente(idRemetente);
				
				//TODO Colocar o local no constrututor da encomenda
				Encomenda encomenda = new Encomenda(remetente, destinatario, pesoDouble, tipo, null, null, prazoDias);
				try {
					Fachada.getInstance().novaEncomenda(encomenda);
					//teste
					RepositorioEncomenda.getInstance().salvaArquivo();
					System.out.println("Salvo");
					((Node) (event.getSource())).getScene().getWindow().hide();
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
	
	public void setID(String id) {
		this.id_cliente = id;
	}

	public void initialize(URL location, ResourceBundle resources) {
		//
	}

}
