package presentation.ui.controller;

import java.util.ArrayList;

import entity.Operatore;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class GestioneOperatoreController {
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField cf;
@FXML
public void cerca(){
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
	}
	if(!ic.onlyNumbersAndLetters(cf.getText())){
		vd.showMessage("Codice fiscale non valido");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cf.getText());
		Operatore operatore = (Operatore) fc.handleRequest("CercaOperatore", parameters);
		Sessione.setOperatoreAttuale(operatore);
		fc.handleRequest("MostraOperatore");
		
	}
}
@FXML
public void aggiungi(){
	fc.handleRequest("AggiungiOperatore");
}
@FXML
public void elimina(){
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
	}
	if(!ic.onlyNumbersAndLetters(cf.getText()) || Sessione.getUsername().equals(cf.getText())){
		vd.showMessage("Codice fiscale non valido o utente attualmente loggato");
	}
	else{
	 if(vd.areYouSure("Sei sicuro di voler procedere?") == 0){
		 ArrayList<String> parameters = new ArrayList<String>();
		 parameters.add(cf.getText());
		 fc.handleRequest("RimuoviOperatore", parameters);
	 }
	 
	}
}
@FXML
public void modifica(){	
	if(cf.getText().isEmpty()){
	vd.showMessage("Compilare il campo codice fiscale");
}
if(!ic.onlyNumbersAndLetters(cf.getText())){
	vd.showMessage("Codice fiscale non valido");
}
else{
	ArrayList<String> parameters = new ArrayList<String>();
	parameters.add(cf.getText());
	Operatore operatore = (Operatore) fc.handleRequest("CercaOperatore", parameters);
	Sessione.setOperatoreAttuale(operatore);
	fc.handleRequest("ModificaOperatore");
	
}
}

@FXML
public void indietro(){
	vd.indietro();
}
@FXML
public void quit(){
	vd.quit();
}
}
