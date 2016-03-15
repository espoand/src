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
TextField via;
@FXML
TextField citta;
@FXML
TextField cap;
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	Cliente cliente = Sessione.getClienteAttuale();
	if(cliente == null){
		vd.showMessage("Si è verificato un'errore");
		vd.home();
	}
	cf.setText(cliente.getCodiceFiscale());
	nome.setText(cliente.getNome());
	cognome.setText(cliente.getCognome());
	telefono.setText(cliente.getTelefono());
	via.setText(cliente.getVia());
	citta.setText(cliente.getCitta());
	cap.setText(cliente.getCap());
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
