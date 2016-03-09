package presentation.ui.controller;

import java.util.ArrayList;

import entity.Auto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class GestioneAutoController {
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField targa;
@FXML 
public void cerca(){
	if(targa.getText().isEmpty()){
		vd.showMessage("Campo targa vuoto");
	}
	if(!ic.onlyNumbersAndLetters(targa.getText())){
	vd.showMessage("Targa non valida");
	}
	
	else{
		ArrayList<String> targaList = new ArrayList<String>();
		targaList.add(targa.getText());
		Auto a = (Auto) fc.handleRequest("CercaAuto",targaList);
		Sessione.setAuto(a);
		fc.handleRequest("MostraAuto");
		
	}
}
@FXML
public void aggiungi(){
	vd.apriView("AggiungiAuto");
}
@FXML
public void modifica(){
	if(targa.getText().isEmpty()){
		vd.showMessage("Campo targa vuoto");
	}
	if(!ic.onlyNumbersAndLetters(targa.getText())){
	vd.showMessage("Targa non valida");
	}
	
	else{
		ArrayList<String> targaList = new ArrayList<String>();
		targaList.add(targa.getText());
		Auto a = (Auto) fc.handleRequest("CercaAuto",targaList);
		Sessione.setAuto(a);
		fc.handleRequest("ModificaAuto");
		
	}
	
}
@FXML
public void elimina(){
	ArrayList<String> targalist = new ArrayList<String>();
	targalist.add(targa.getText());
	boolean eseguito = false;
	if(vd.areYouSure("Sei sicuro di voler eliminare l'auto?") == 0){
	eseguito = (boolean) fc.handleRequest("RimuoviAuto",targalist);
	}
	if(eseguito){
		vd.showMessage("Cancellazione eseguita");
	}
	else vd.showMessage("Si è verificato un errore durante la cancellazione");
	}

@FXML
public void quit(){
	vd.quit();
}
@FXML
public void home(){
	fc.handleRequest("Home");
}
}
