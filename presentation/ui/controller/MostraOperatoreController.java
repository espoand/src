package presentation.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Operatore;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.ViewDispatcher;
import utility.Sessione;

public class MostraOperatoreController implements Initializable{
ViewDispatcher vd = new ViewDispatcher();
@FXML
TextField nome;
@FXML
TextField cognome;
@FXML
TextField username;
@FXML
TextField cf;
Operatore operatore;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		operatore = Sessione.getOperatoreAttuale();
		nome.setText(operatore.getNome());
		cognome.setText(operatore.getCognome());
		username.setText(operatore.getUsername());
		cf.setText(operatore.getCf());
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
