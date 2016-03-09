package presentation.ui.controller;

import java.util.ArrayList;

import entity.ModalitaNoleggio;
import entity.Noleggio;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class GestioneNoleggioController {
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField nroOrdine;
@FXML
public void cerca(){
	if(nroOrdine.getText().isEmpty()){
		vd.showMessage("Compilare il campo Numero Ordine");
	}
	if(!ic.onlyNumbers(nroOrdine.getText())){
		vd.showMessage("Il campo deve essere composto di soli numeri");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(nroOrdine.getText());
		Noleggio noleggio = (Noleggio) fc.handleRequest("CercaNoleggio",parameters);
		Sessione.setNoleggioAttuale(noleggio);
		fc.handleRequest("MostraNoleggio");
		
	}
}
@FXML
public void aggiungi(){
	fc.handleRequest("AggiungiNoleggio");
}
@FXML
public void modifica(){if(nroOrdine.getText().isEmpty()){
	vd.showMessage("Compilare il campo Numero Ordine");
}
if(!ic.onlyNumbers(nroOrdine.getText())){
	vd.showMessage("Il campo deve essere composto di soli numeri");
}
else{
	ArrayList<String> parameters = new ArrayList<String>();
	parameters.add(nroOrdine.getText());
	Noleggio noleggio = (Noleggio) fc.handleRequest("CercaNoleggio",parameters);
	Sessione.setNoleggioAttuale(noleggio);
	fc.handleRequest("ModificaNoleggio");
	
}}
@FXML
public void elimina(){
	if(nroOrdine.getText().isEmpty()){
		vd.showMessage("Compilare il campo Numero Ordine");
	}
	if(!ic.onlyNumbers(nroOrdine.getText())){
		vd.showMessage("Il campo deve essere composto di soli numeri");
	}
	
	else{
		if(vd.areYouSure("Sei sicuro di voler procedere?") == 0){
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(nroOrdine.getText());
			fc.handleRequest("RimuoviNoleggio", parameters);
			vd.showMessage("Completato");
		}
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
