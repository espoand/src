package presentation.ui.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class AggiungiClienteController {
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
TextField telefono;
@FXML
TextField indirizzo;
@FXML
public void submit(){
	if(cf.getText().isEmpty() || cognome.getText().isEmpty() || nome.getText().isEmpty() || telefono.getText().isEmpty() || indirizzo.getText().isEmpty()){
		vd.showMessage("Compilare tutti i campi");
		
	}
	if(!ic.onlyNumbersAndLetters(cf.getText())){
		vd.showMessage("Vi sono caratteri non ammessi nel campo Codice Fiscale!");
		
	}
	if(!ic.telephoneNumber(telefono.getText())){
		vd.showMessage("Numero di telefono non valido");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cf.getText());
		parameters.add(nome.getText());
		parameters.add(cognome.getText());
		parameters.add(telefono.getText());
		parameters.add(indirizzo.getText());
		boolean eseguito = (boolean) fc.handleRequest("InserisciCliente", parameters);
		if(eseguito){
			vd.showMessage("Operazione avvenuta con successo");
			vd.indietro();
		}
		else{
			vd.showMessage("Si è verificato un errore");
		}
	}
}
@FXML
public void indietro(){
	vd.home();
}
@FXML
public void quit(){
	vd.quit();
}
}
