package br.ufrpe.bugzilla.gui.telas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaCliente extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		try{
			Parent r = FXMLLoader.load(getClass().getResource("TelaCliente.fxml"));
			Scene scene = new Scene(r);
			
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.show();
			
		}catch (Exception e) {
			System.out.println("Erro!");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
