package presentation.ui.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateTimeStringConverter;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;
import entity.Agenzia;
import entity.Auto;
import entity.Noleggio;
import entity.TariffaBase;

public class ModificaNoleggioController implements Initializable{
	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
	InputController ic = new InputController();
@FXML
TextField nroOrdine;
@FXML
ChoiceBox<String> tariffa;
@FXML
CheckBox illimitati;
@FXML
TextField targa;
@FXML
DatePicker riconsegna;
@FXML
TextField totale;
Noleggio noleggioAttuale;
ArrayList<TariffaBase> tutteTariffe;
ArrayList<Agenzia> tutteAgenzie;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		noleggioAttuale = Sessione.getNoleggioAttuale();
		tutteTariffe = (ArrayList<TariffaBase>) fc.handleRequest("TutteTariffe");
		
		Iterator<TariffaBase> it1 = tutteTariffe.iterator();
		while(it1.hasNext()){
			tariffa.getItems().add(it1.next().getNome());
			
		}
		tariffa.setValue(noleggioAttuale.getTariffaBase().getNome());
		nroOrdine.setText(Integer.toString(noleggioAttuale.getNroOrdine()));
		illimitati.setSelected(noleggioAttuale.isKmIllimitato());
		targa.setText(noleggioAttuale.getAutoNoleggiata().getTarga());
		
		riconsegna.setValue(noleggioAttuale.getDataEffettivaRiconsegna());
		totale.setText(Double.toString(noleggioAttuale.getImportoTotale()));
		
		
		
	}

@FXML
public void quit(){
	vd.quit();
}
@FXML
public void conferma(){
	if(nroOrdine.getText().isEmpty() || tariffa.getValue().isEmpty() || targa.getText().isEmpty() || riconsegna.getValue().toString().isEmpty() || totale.getText().isEmpty()){
		vd.showMessage("Compilare tutti i campi");
	}
	if(!ic.onlyNumbers(nroOrdine.getText())){
		vd.showMessage("Il campo Numero Ordine può contenere solo numeri");
	}
	if(!ic.onlyNumbersAndLetters(targa.getText())){
		vd.showMessage("Inserita targa non valida");
}
	if(riconsegna.getValue().isBefore(Sessione.today())){
		vd.showMessage("La data di restituzione inserita è precedente ad oggi");}
	if(!ic.onlyNumbers(totale.getText())){
		vd.showMessage("Il campo totale può contenere solo numeri");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(nroOrdine.getText());
		parameters.add(tariffa.getValue());
		parameters.add(targa.getText());
		parameters.add(Boolean.toString(illimitati.isSelected()));
		parameters.add(riconsegna.getValue().toString());
		parameters.add(totale.getText());
		boolean eseguito = (boolean) fc.handleRequest("ModificaNoleggio", parameters);
		if(eseguito){
			vd.showMessage("Completato");
			vd.indietro();
		}
		else{vd.showMessage("Si è verificato un errore");
		vd.indietro();
		}
	}
	}

@FXML
public void mostraTariffa(){
	if(tariffa.getValue().isEmpty()){
		vd.showMessage("Selezionare una tariffa");
	}
	else{
	Iterator<TariffaBase> it1 = tutteTariffe.iterator();
	TariffaBase tmp = null;
	while(it1.hasNext()){
		tmp = it1.next();
		if(tmp.getNome().equals(tariffa.getValue())){
			Sessione.setTariffaAttuale(tmp);break;
		}
	}
	fc.handleRequest("MostraTariffaBase");
}}
@FXML
public void mostraAuto(){
	ArrayList<Auto> tutteAuto= (ArrayList<Auto>) fc.handleRequest("TutteAuto");
	Iterator<Auto> it1 = tutteAuto.iterator();
	Auto tmp = null;
	boolean trovato = false;
	while(it1.hasNext()){
		tmp = it1.next();
		if(tmp.getTarga().equals(targa.getText())){
			Sessione.setAuto(tmp);trovato = true;break;
		}
	}
	if(trovato){
		fc.handleRequest("MostraAuto");
	}
	else{
	vd.showMessage("La targa inserita non corrisponde a nessuna auto");
	}
}
@FXML
public void indietro(){
	fc.handleRequest("Home");
}
}
