package br.ufrpe.bugzilla.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuAdministrador extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		      Parent r = FXMLLoader.load(getClass().getResource("MenuAdministrador.fxml"));
		      Scene scene = new Scene(r);
		      primaryStage.setScene(scene);
		      primaryStage.setTitle("Bugzilla Encomendas"); 
		      primaryStage.show();
		    } catch (Exception e) {
		      System.out.println("Erro");
		      System.out.println(e.getMessage());
		    
		    }
		
	}

	public static void main(String[] args) {
	    launch(args);
	  }
}
