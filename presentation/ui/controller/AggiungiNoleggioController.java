package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Noleggio;
import entity.TariffaBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Calculator;
import utility.InputController;
import utility.Sessione;

public class AggiungiNoleggioController implements Initializable{
FrontController fc = new FrontController();
InputController ic = new InputController();
ViewDispatcher vd = new ViewDispatcher();
@FXML
ChoiceBox<String> tariffa;
@FXML
TextField targa;
@FXML
CheckBox kmIllimitati;
@FXML
DatePicker data;
@FXML
TextField totale;
ArrayList<TariffaBase> tutteTariffe = null;
@FXML
TextField km;
Calculator calculator = new Calculator();
@FXML
public void submit(){
	if(targa.getText().isEmpty() || totale.getText().isEmpty() ||tariffa.getValue().isEmpty() || data.getValue()==null ||data.getValue().isBefore(Sessione.today())){
		vd.showMessage("Compilare tutti i campi");
	}
	if(!ic.isDouble(km.getText()) || !ic.onlyNumbersAndLetters(targa.getText()) || !ic.isDouble(totale.getText())){
		vd.showMessage("Caratteri non ammessi nel campo Km e/o Targa e/o totale");
	}
	else{
		ArrayList<String> parameters  = new ArrayList<String>();
		parameters.add(Integer.toString(calculator.calcolaNroOrdine()));
		parameters.add(tariffa.getValue());
		parameters.add(targa.getText());
		parameters.add(Boolean.toString(kmIllimitati.isSelected()));
		parameters.add(data.toString());
		parameters.add(totale.getText());
		parameters.add(km.getText());
		boolean eseguito  = (boolean) fc.handleRequest("AggiungiNoleggio",parameters);
		if(eseguito){
			vd.showMessage("Completato");vd.indietro();
		}
		else{
			vd.showMessage("Si è verificato un errore");vd.indietro();
		}
		
	}
}
@FXML
public void calcolaTotale(){
	if(tariffa.getValue().isEmpty() || data.getValue()==null ||data.getValue().isBefore(Sessione.today())){
		vd.showMessage("Data errata o tariffa non selezionata");
	}
	
	Iterator<TariffaBase> it1 = tutteTariffe.iterator();
	TariffaBase tariffaTmp = null;
	while(it1.hasNext()){
		tariffaTmp = it1.next();
		if(tariffaTmp.getNome().equals(tariffa.getValue())){
			break;}
		}
	
	double importoTotale = calculator.calcolaTotale(data.getValue(), kmIllimitati.isSelected(), tariffaTmp, Double.parseDouble(km.getText()));
	totale.setText(Double.toString(importoTotale));
	
}
@FXML
public void indietro(){
	vd.indietro();
}
@FXML
public void quit(){
	vd.quit();
}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tutteTariffe = (ArrayList<TariffaBase>) fc.handleRequest("TutteTariffe");
		Iterator<TariffaBase> it1 = tutteTariffe.iterator();
		ArrayList<String> nomeTariffe = new ArrayList<String>();
		while(it1.hasNext()){
			
			nomeTariffe.add(it1.next().getNome());
		}
		tariffa.getItems().addAll(nomeTariffe);
		
	}

}
