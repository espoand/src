package presentation.ui.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;

public class AggiungiAgenziaController {
	ViewDispatcher vd = new ViewDispatcher();
	FrontController fc = new FrontController();
	InputController ic = new InputController();
	
	@FXML
	TextField nome;
	@FXML
	TextField via;
	@FXML
	TextField citta;
	@FXML
	TextField cap;
	@FXML
	TextField telefono;
	
	@FXML
	public void quit(){
		vd.quit();
	}
	@FXML
	public void indietro(){
		vd.home();
	}
	@FXML
	public void submit(){
		//id intero,cap max 5 caratteri senza spazi
		if(nome.getText().isEmpty() || via.getText().isEmpty() || citta.getText().isEmpty() || cap.getText().isEmpty() || telefono.getText().isEmpty()){
			vd.showMessage("Compilare tutti i campi");
		}
		if(!ic.telephoneNumber(telefono.getText()) || !ic.onlyNumbers(cap.getText()) || cap.getText().length()!=5){
			vd.showMessage("Numero di telefono e/o CAP Errato/i");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add("0");
			parameters.add(nome.getText());
			parameters.add(via.getText());
			parameters.add(citta.getText());
			parameters.add(cap.getText());
			parameters.add(telefono.getText());
			boolean eseguito = (boolean) fc.handleRequest("InserisciAgenzia",parameters);
			if(eseguito){
				vd.showMessage("Completato");
			}
			else vd.showMessage("Si è verificato un errore");
			
			
		}
	}
}
