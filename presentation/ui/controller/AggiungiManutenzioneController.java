package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Auto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.TipoManutenzione;

public class AggiungiManutenzioneController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
ChoiceBox<String> auto;
@FXML
DatePicker data;
@FXML
ChoiceBox<String> tipo;
@FXML
TextField costo;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ArrayList<Auto> tutteAuto = (ArrayList<Auto>) fc.handleRequest("TutteAuto");
		Iterator<Auto> it1 = tutteAuto.iterator();
		while(it1.hasNext()){
			auto.getItems().add(it1.next().getTarga());
		}
		tipo.getItems().add(TipoManutenzione.ORDINARIA.toString());
		tipo.getItems().add(TipoManutenzione.STRAORDINARIA.toString());
		
		
	}
	@FXML
	public void quit(){
		vd.quit();
	}
	@FXML
	public void indietro(){
		vd.indietro();
	}
	@FXML
	public void aggiungi(){
		if(auto.getValue().isEmpty() || data.getValue() == null || tipo.getValue().isEmpty() || costo.getText().isEmpty()){
			vd.showMessage("Compilare tutti i campi");
		}
		if(!ic.isDouble(costo.getText())){
			vd.showMessage("Importo inserito non valido");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String> ();
			parameters.add(auto.getValue());
			parameters.add(data.getValue().toString());
			parameters.add(tipo.getValue());
			parameters.add(costo.getText());
			boolean eseguito = (boolean) fc.handleRequest("AggiungiManutenzione",parameters);
			if(eseguito){ vd.showMessage("Completato");vd.indietro();}
			else vd.showMessage("Si è verificato un errore");
		}
	}

}
