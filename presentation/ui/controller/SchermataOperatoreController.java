package presentation.ui.controller;

import javafx.fxml.FXML;
import presentation.FrontController;
import utility.Sessione;

public class SchermataOperatoreController {
	FrontController fc = new FrontController();
@FXML
public void gestioneClienti(){
	fc.handleRequest("GestioneCliente");
}
@FXML
public void gestioneNoleggi(){
	fc.handleRequest("GestioneNoleggio");
}
@FXML
public void gestioneAuto(){
	fc.handleRequest("GestioneAuto");
}
@FXML
public void gestioneContratti(){
	fc.handleRequest("GestioneContratto");
}
@FXML
public void login(){
	fc.handleRequest("Login");
}
@FXML
public void quit(){
	Sessione.azzera();
	System.exit(0);
}
}
