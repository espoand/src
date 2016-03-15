package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Fascia;
import entity.TariffaBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class ModificaFasciaController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
Fascia fascia = null;
TariffaBase tariffaAttuale = null;
@FXML
ChoiceBox<String> tariffa;
@FXML
TextField idFascia;
@FXML
TextField descrizione;
ArrayList<TariffaBase> tutteTariffe;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		fascia = Sessione.getFasciaAttuale();
		tariffaAttuale = fascia.getTariffaFascia();
		if(fascia == null || tariffaAttuale == null){
			vd.showMessage("Si è verificato un'errore");
			vd.home();
		}
		tutteTariffe = (ArrayList<TariffaBase>) fc.handleRequest("TutteTariffe");
		Iterator<TariffaBase> it1 = tutteTariffe.iterator();
		while(it1.hasNext()){
			tariffa.getItems().add(it1.next().getNome());
		}
		tariffa.setValue(tariffaAttuale.getNome());
		
		idFascia.setText(fascia.getIdFascia());
		descrizione.setText(fascia.getDescrizioneFascia());
		
	}
@FXML
public void conferma(){
	ArrayList<String> parameters = new ArrayList<String>();
	parameters.add(idFascia.getText());
	parameters.add(descrizione.getText());
	parameters.add(tariffa.getValue());
	boolean eseguito = (boolean) fc.handleRequest("ModificaFascia",parameters);
	if(eseguito){ vd.showMessage("Completato");
	vd.home();
	}
	else {
		vd.showMessage("Si è verificato un errore");
		vd.home();
	}
	
}
@FXML
public void indietro(){
	fc.handleRequest("Home");
}
@FXML
public void mostraTariffa(){
	if(tariffa.getValue().isEmpty()){
		vd.showMessage("Selezionare un elemento");
	}
	else{
		Iterator<TariffaBase> it1 = tutteTariffe.iterator();
		TariffaBase tmp;
		while(it1.hasNext()){
			tmp = it1.next();
			if(tmp.getNome().equals(tariffa.getValue())){
				Sessione.setTariffaAttuale(tmp);
				fc.handleRequest("MostraTariffaBase");
			}
		}
	}
}
@FXML
public void quit(){
	vd.quit();
}
}
