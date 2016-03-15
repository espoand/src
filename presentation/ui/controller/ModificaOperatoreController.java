package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.Operatore;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class ModificaOperatoreController implements Initializable{
	FrontController fc = new FrontController();
	InputController ic = new InputController();
	ViewDispatcher vd  = new ViewDispatcher();
	
@FXML
TextField codiceFiscale;
@FXML
CheckBox amministratore;
@FXML
TextField nome;
@FXML
TextField cognome;
@FXML
TextField username;
@FXML
PasswordField password;
Operatore operatore = null;
	
@FXML
public void quit(){
	vd.quit();
}
@FXML
public void home(){
	fc.handleRequest("Home");
}
@FXML
public void submit(){
	if(nome.getText().isEmpty() || cognome.getText().isEmpty() || username.getText().isEmpty()){
		vd.showMessage("Riempire tutti i campi");
	}
	if(!password.getText().isEmpty() || !ic.onlyNumbersAndLetters(password.getText())){
		vd.showMessage("La password deve essere composta solo di numeri e lettere");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(codiceFiscale.getText());
		parameters.add(nome.getText());
		parameters.add(cognome.getText());
		parameters.add(Boolean.toString(amministratore.isSelected()));
		parameters.add(username.getText());
		if(password.getText().isEmpty()){
			parameters.add(operatore.getPassword());
		}
		else{
			parameters.add(password.getText());
		}
		boolean eseguito = (boolean) fc.handleRequest("ModificaOperatore",parameters);
		if(eseguito){
			vd.showMessage("Completato");
			vd.home();
		}
		else{
			vd.showMessage("Si è verificato un errore");
			vd.home();
		}
	}
	
}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	operatore = Sessione.getOperatoreAttuale();
	codiceFiscale.setText(operatore.getCf());
	amministratore.setSelected(operatore.isAmministratore());
	nome.setText(operatore.getNome());
	cognome.setText(operatore.getCognome());
	username.setText(operatore.getUsername());
	
}

}
