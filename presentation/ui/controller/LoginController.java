package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.WrongPasswordException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;
import utility.TipoUtente;

public class LoginController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField username;
@FXML
PasswordField password;
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	Sessione.azzera();
}

@FXML
public void submit(){
	if(username.getText().isEmpty() || password.getText().isEmpty()){
		vd.showMessage("Compilare tutti i campi");
	}
	if(!ic.onlyNumbersAndLetters(username.getText())){
		vd.showMessage("Caratteri non ammessi nel campo username");
	}
	if(!ic.onlyNumbersAndLetters(password.getText())){
		vd.showMessage("Caratteri non ammessi nel campo password");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(username.getText());
		parameters.add(password.getText());
		boolean loggato = false;
		try{
		loggato = (boolean) fc.handleRequest("Login", parameters);}
		catch(WrongPasswordException e){
			vd.showMessage("Password errata!");
		}
		if(loggato){
			if(Sessione.getTipo() == TipoUtente.AMMINISTRATORE){
				fc.handleRequest("SchermataAmministratore");
			}
			else fc.handleRequest("SchermataOperatore");
		}
	}
}
@FXML
public void quit(){
	vd.quit();
}
}
