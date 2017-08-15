package br.ufrpe.bugzilla.gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.*;

public class Login extends Application{
 
	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent r = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(r);
			stage.setScene(scene);
			stage.setTitle("Bugzilla Encomendas");
			stage.initStyle(StageStyle.TRANSPARENT);
			stage.show();
			
			
		} catch (Exception e) {
			System.out.println("Erro!");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	public static void main(String[] args){
		launch(args);
	}

}
