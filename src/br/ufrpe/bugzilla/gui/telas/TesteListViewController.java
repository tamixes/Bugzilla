package br.ufrpe.bugzilla.gui.telas;

import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.bugzilla.negocio.Fachada;
import br.ufrpe.bugzilla.negocio.beans.Local;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class TesteListViewController implements Initializable{
	@FXML
	private ComboBox<Local> combobox;
	@FXML
	private Button bt;
	
	@FXML
	public void printaValor(){
		System.out.println(combobox.getValue().getNome() + combobox.getValue().getLatitude());
	}
	

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//evita que apareça todo o toString do objeto
		Callback<ListView<Local>, ListCell<Local>> factory = new Callback<ListView<Local>, ListCell<Local>>() {
			public ListCell<Local> call(ListView<Local> lv) {
				return new ListCell<Local>() {

				    @Override
				    protected void updateItem(Local item, boolean empty) {
				        super.updateItem(item, empty);
				        setText(empty ? "" : item.getNome());
				    }

				};
			}
		};
		
		combobox.setItems(FXCollections.observableArrayList(Fachada.getInstance().listarLocais()));
		combobox.setCellFactory(factory);
		combobox.setButtonCell(factory.call(null));
		
		
	}

}
