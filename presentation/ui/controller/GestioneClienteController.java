package presentation.ui.controller;


import java.util.ArrayList;

import entity.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.ApplicationController;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class GestioneClienteController {
ViewDispatcher vd = new ViewDispatcher();
FrontController fc = new FrontController();
InputController ic = new InputController();
@FXML
TextField cf;

@FXML 
public void cerca(){
	Cliente cliente = null;
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
		
	}
	if(!ic.onlyNumbersAndLetters(cf.getText())){
		vd.showMessage("Il campo codice fiscale deve essere composto di soli numeri e lettere");
		
}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cf.getText());
		cliente = (Cliente) fc.handleRequest("CercaCliente",parameters);
		Sessione.setClienteAttuale(cliente);
		fc.handleRequest("MostraCliente");
		}
	}
@FXML 
public void aggiungi(){
	fc.handleRequest("AggiungiCliente");
}
@FXML
public void modifica(){
	Cliente cliente = null;
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
		
	}
	if(!ic.onlyNumbersAndLetters(cf.getText())){
		vd.showMessage("Il campo codice fiscale deve essere composto di soli numeri e lettere");
		
}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cf.getText());
		cliente = (Cliente) fc.handleRequest("CercaCliente",parameters);
		Sessione.setClienteAttuale(cliente);
		fc.handleRequest("ModificaCliente");
		}
}
@FXML
public void elimina(){
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
		
	}
	if(!ic.onlyNumbersAndLetters(cf.getText())){
		vd.showMessage("Il campo codice fiscale deve essere composto di soli numeri e lettere");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		fc.handleRequest("RimuoviCliente", parameters);
	}
}
@FXML
public void indietro(){
	
	vd.indietro();
}
public void quit(){
	vd.quit();
}
}
