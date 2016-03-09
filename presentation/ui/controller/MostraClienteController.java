package presentation.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.ApplicationController;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Sessione;

public class MostraClienteController implements Initializable{
FrontController fc = new FrontController();
ApplicationController ac = new ApplicationController();
ViewDispatcher vd = new ViewDispatcher();
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
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	Cliente cliente = Sessione.getClienteAttuale();
	if(cliente == null){
		vd.showMessage("Si è verificato un'errore");
		vd.indietro();
	}
	cf.insertText(0, cliente.getCodiceFiscale());
	nome.insertText(0, cliente.getNome());
	cognome.insertText(0, cliente.getCognome());
	telefono.insertText(0, cliente.getTelefono());
	indirizzo.insertText(0, cliente.getIndirizzo());
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
