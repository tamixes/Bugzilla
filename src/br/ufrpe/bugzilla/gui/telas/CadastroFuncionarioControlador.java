package br.ufrpe.bugzilla.gui.telas;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import br.ufrpe.bugzilla.colecoes.TipoDeFuncionario;
import br.ufrpe.bugzilla.dao.RepositorioFuncionario;
import br.ufrpe.bugzilla.exceptions.ObjectJaExisteException;
import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Endereco;
import br.ufrpe.bugzilla.negocio.beans.Funcionario;
import br.ufrpe.bugzilla.negocio.beans.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CadastroFuncionarioControlador implements Initializable{

	@FXML
	private JFXButton voltar_cadastro, enviar_cadastro; 
	@FXML
	private JFXTextField nome_func, cpf_func, telefone_func, rua_func, bairro_func, nascimento_func;
	@FXML
	private JFXTextField cidade_func, estado_func, cep_func, numero_func, salario_func, login_func;
	@FXML
	private JFXCheckBox seta_adm;
	@FXML
	private Label aviso;
	@FXML
	private JFXPasswordField senha_func;
	@FXML
	private void voltarCadastro(ActionEvent event){
		((Node) (event.getSource())).getScene().getWindow().hide();
		Parent p = null;
		
		try {
			p = FXMLLoader.load(getClass().getResource("MenuAdministrador.fxml"));
			Scene scene = new Scene(p);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Bugzilla Encomendas");
			stage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@FXML
	private void enviarCadastro(ActionEvent event){
		String nome, cpf, telefone, login, senha, nascimento;
		String rua, bairro, cidade, estado, cep, numero, salario;
		
		
		nome = nome_func.getText();
		cpf = cpf_func.getText();
		telefone = telefone_func.getText();
		login = login_func.getText();
		senha = senha_func.getText();
		nascimento = nascimento_func.getText();
		
		rua = rua_func.getText();
		bairro = bairro_func.getText();
		cidade = cidade_func.getText();
		estado = estado_func.getText();
		cep = cep_func.getText();
		numero = numero_func.getText();
		salario = salario_func.getText();
		
		
		if(!nome.equals("") && !cpf.equals("") && !telefone.equals("") && !login.equals("") && !senha.equals("") && !nascimento.equals("") 
				&& !rua.equals("") && !bairro.equals("") && !cidade.equals("") && !numero.equals("") 
					&& !estado.equals("") && !cep.equals("") && !salario.equals("")){
			try {
				int num = Integer.parseInt(numero);
				double sal = Double.parseDouble(salario);
				Endereco end = new Endereco(rua, bairro, cidade, estado, cep, num);
				Usuario user = new Usuario(login, senha);
				Funcionario func = new Funcionario(nome, cpf, nascimento, telefone, end, sal, user, TipoDeFuncionario.FUNC);
				
				try {
					Fachada.getInstance().addFuncionario(func);
					//RepositorioFuncionario.getInstance().salvaArquivo();
					((Node) (event.getSource())).getScene().getWindow().hide();
					
					
				} catch (ObjectJaExisteException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Erro ao cadastrar!");
					alert.setContentText("Funcionario já existe!");
					alert.showAndWait();
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else{
			aviso.setText("Preencha todos os campos!");
		}
	}
	
	
	
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
