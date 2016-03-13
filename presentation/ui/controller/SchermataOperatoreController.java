package presentation.ui.controller;

import javafx.fxml.FXML;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Sessione;

public class SchermataOperatoreController {
	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
@FXML
public void gestioneClienti(){
	fc.handleRequest("GestioneCliente");
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
	vd.quit();
}
}
