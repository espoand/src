package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Fascia;
import entity.TariffaBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class AggiungiFasciaController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField idFascia;
@FXML
TextField descrizioneFascia;
@FXML 
ChoiceBox<String> tariffa;
@FXML
public void submit(){
if(idFascia.getText().isEmpty() || descrizioneFascia.getText().isEmpty() || tariffa.getValue().isEmpty()){
	vd.showMessage("Compila tutti i campi");
}	
if(!ic.onlyNumbersAndLetters(idFascia.getText())){
	vd.showMessage("ID Fascia deve essere composto di sole lettere e numeri");
}
else{
String tariffaSelezionata = tariffa.getValue();
ArrayList<String> parameters = new ArrayList<String>();
parameters.add(idFascia.getText());
parameters.add(descrizioneFascia.getText());
parameters.add(tariffaSelezionata);
boolean eseguito = (boolean) fc.handleRequest("AggiungiFascia",parameters);
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
public void indietro(){vd.home();}

@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	ArrayList<Fascia> tutteTariffe = (ArrayList<Fascia>) fc.handleRequest("TutteTariffe");
	ArrayList<String> nomeTariffe = new ArrayList<String>();
	Iterator it1 = tutteTariffe.iterator();
		while(it1.hasNext()){
			nomeTariffe.add(((TariffaBase) it1.next()).getNome());
		}
	tariffa.setItems(FXCollections.observableArrayList(nomeTariffe));
	
	}
}


