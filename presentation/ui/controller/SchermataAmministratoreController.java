package presentation.ui.controller;

import javafx.fxml.FXML;
import presentation.FrontController;
import utility.Sessione;

public class SchermataAmministratoreController {
	FrontController fc = new FrontController();
@FXML
public void gestioneAuto(){
	fc.handleRequest("GestioneAuto");
	
}
@FXML
public void gestioneClienti(){
	fc.handleRequest("GestioneClienti");
	
}
@FXML
public void gestioneOperatori(){
	fc.handleRequest("GestioneOperatori");
	
}
@FXML
public void gestioneTariffe(){
	
	fc.handleRequest("GestioneTariffe");
	
}
@FXML
public void gestioneFasce(){
	fc.handleRequest("GestioneFasce");
}
@FXML
public void login(){
	fc.handleRequest("Login");
	Sessione.azzera();
}
@FXML
public void quit(){
	Sessione.azzera();
	System.exit(0);
}
}
