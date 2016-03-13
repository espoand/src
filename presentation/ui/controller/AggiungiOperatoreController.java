package presentation.ui.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class AggiungiOperatoreController {

FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField cf;
@FXML
TextField nome;
@FXML
TextField cognome;
@FXML
TextField username;
@FXML
PasswordField password;
@FXML
CheckBox amministratore;
@FXML
public void submit(){
	boolean isAmministratore = amministratore.isSelected();
	if(cf.getText().isEmpty() || nome.getText().isEmpty() || cognome.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()){
		vd.showMessage("Compilare tutti i campi");
	}
	if(!ic.onlyNumbersAndLetters(cf.getText()) || !ic.onlyNumbersAndLetters(username.getText()) || !ic.onlyNumbersAndLetters(password.getText())){
		vd.showMessage("I campi Codice Fiscale,Username e Password devono essere composti di soli numeri e lettere!");
	}
	else {
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cf.getText());
		parameters.add(nome.getText());
		parameters.add(cognome.getText());
		parameters.add(username.getText());
		parameters.add(password.getText());
		parameters.add(Boolean.toString(isAmministratore));
		boolean eseguito = (boolean) fc.handleRequest("AggiungiOperatore",parameters);
		if(eseguito){vd.showMessage("Completato");vd.indietro();}
		else {vd.showMessage("Si è verificato un errore");vd.indietro();}
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
}
