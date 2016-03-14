package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Fascia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class AggiungiAutoController implements Initializable{
	FrontController fc = new FrontController();
	InputController ic = new InputController();
	ViewDispatcher vd = new ViewDispatcher();
@FXML
TextField targa;
@FXML
TextField modello;
@FXML
ChoiceBox<String> fascia;
@FXML
TextField km;

@FXML
public void submit(){
	if(targa.getText().isEmpty() || modello.getText().isEmpty() || fascia.getValue().isEmpty() || km.getText().isEmpty()){
		vd.showMessage("Compilare tutti i campi");
	}
	if(!ic.onlyNumbersAndLetters(targa.getText())){
		vd.showMessage("Il campo targa può contenere solo numeri e lettere");
	}
	if(!ic.onlyNumbers(km.getText())){
		vd.showMessage("Il campo KM deve contenere un numero");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(targa.getText());
		parameters.add(modello.getText());
		parameters.add(fascia.getValue());
		parameters.add(km.getText());
		boolean eseguito = (boolean) fc.handleRequest("InserisciAuto",parameters);
		if(eseguito){
			vd.showMessage("Completato");vd.home();
		}
		else {vd.showMessage("Si è verificato un errore");vd.home();}
	}
}
@FXML
public void quit(){
	vd.quit();
}
@FXML
public void indietro(){
	vd.indietro();
}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	ArrayList<Fascia> tutteFasce =  (ArrayList<Fascia>) fc.handleRequest("TutteFasce");
	ArrayList<String> idFasce = new ArrayList<String>();
	Iterator<Fascia> it1 = tutteFasce.iterator();
	while(it1.hasNext()){
		idFasce.add(((Fascia)it1.next()).getIdFascia());
	}
	fascia.getItems().addAll(idFasce);
	
}
}
