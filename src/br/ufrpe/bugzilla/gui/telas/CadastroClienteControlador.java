package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.dao.RepositorioCliente;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.gui.login.Login;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Cliente;
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

public class CadastroClienteControlador implements Initializable {

	@FXML
	private JFXTextField nome_cliente, cnpj_cliente, cpf_cliente, telefone_cliente, rua_cliente;
	@FXML
	private JFXTextField bairro_cliente, cidade_cliente, numero_cliente, estado_cliente, cep_cliente;
	@FXML
	private Label aviso;
	@FXML
	private JFXButton enviar_cliente, voltar_cliente; 
	
	@FXML
	public void enviarCliente(ActionEvent event){
		String nome, cnpj, cpf, telefone, rua, bairro, cidade, cep, estado, numero;
		
		nome = nome_cliente.getText();
		cnpj = cnpj_cliente.getText();
		cpf = cpf_cliente.getText();
		telefone = telefone_cliente.getText();
		
		rua = rua_cliente.getText();
		bairro = bairro_cliente.getText();
		cidade = cidade_cliente.getText();
		numero = numero_cliente.getText();
		estado = estado_cliente.getText();
		cep = cep_cliente.getText();
		
		if(!nome.equals("") && !cnpj.equals("") && !cpf.equals("") && !telefone.equals("") && !rua.equals("")
				&& !bairro.equals("") && !cidade.equals("") && !numero.equals("") && !estado.equals("")){
			try {
				int num = Integer.parseInt(numero); 
				Endereco end = new Endereco(rua, bairro, cidade, estado, cep, num);
				Cliente cliente = new Cliente(nome, cnpj, cpf, telefone, end, null);
				try {
					Fachada.getInstance().cadastrarCliente(cliente);
					//teste
					RepositorioCliente.getInstance().salvaArquivo();
					((Node) (event.getSource())).getScene().getWindow().hide();;
				} catch (ObjectJaExisteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao cadastrar!");
					alert.setContentText("Cliente já existe!");
					alert.showAndWait();
				}
				
				} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else{
			aviso.setText("Preencha todos os campos!");
		}
	}
	
	@FXML
	public void voltarCliente(ActionEvent event){
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
		// TODO Auto-generated method stub
		
	}

	
}
