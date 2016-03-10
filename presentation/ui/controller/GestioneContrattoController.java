package presentation.ui.controller;

import java.util.ArrayList;

import entity.Contratto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Calculator;
import utility.InputController;
import utility.Sessione;

public class GestioneContrattoController{
	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
	InputController ic = new InputController();
	Calculator calculator = new Calculator();
	
	@FXML
	TextField nroOrdine;
	@FXML
	public void cerca(){
		if(nroOrdine.getText().isEmpty() ){
			vd.showMessage("Compilare il campo Numero Ordine");
		}
		if(!ic.onlyNumbers(nroOrdine.getText()) || Double.parseDouble(nroOrdine.getText())>=calculator.calcolaNroOrdine()){
			vd.showMessage("Numero Ordine non valido");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(nroOrdine.getText());
			Contratto c = (Contratto) fc.handleRequest("CercaContratto",parameters);
			Sessione.setContrattoAttuale(c);
			fc.handleRequest("MostraContratto");
		}
	}
	@FXML
	public void aggiungi(){
		fc.handleRequest("AggiungiContratto");
	}
	@FXML
	public void modifica(){
		if(nroOrdine.getText().isEmpty() ){
			vd.showMessage("Compilare il campo Numero Ordine");
		}
		if(!ic.onlyNumbers(nroOrdine.getText()) || Double.parseDouble(nroOrdine.getText())>=calculator.calcolaNroOrdine()){
			vd.showMessage("Numero Ordine non valido");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(nroOrdine.getText());
			Contratto c = (Contratto) fc.handleRequest("CercaContratto",parameters);
			Sessione.setContrattoAttuale(c);
			fc.handleRequest("ModificaContratto");
		}
	}
	@FXML
	public void elimina(){
		if(nroOrdine.getText().isEmpty() ){
			vd.showMessage("Compilare il campo Numero Ordine");
		}
		if(!ic.onlyNumbers(nroOrdine.getText()) || Double.parseDouble(nroOrdine.getText())>=calculator.calcolaNroOrdine()){
			vd.showMessage("Numero Ordine non valido");
		}
		
		else{
			boolean eseguito = false;
			if(vd.areYouSure("Sei sicuro di voler procedere?")== 0){
				ArrayList<String> parameters = new ArrayList<String>();
				parameters.add(nroOrdine.getText());
				eseguito = (boolean) fc.handleRequest("RimuoviContratto",parameters);
				
			}
			if(eseguito){
				vd.showMessage("Completato");vd.indietro();
			}
			else{
				vd.showMessage("Si è verificato un errore");vd.indietro();
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
