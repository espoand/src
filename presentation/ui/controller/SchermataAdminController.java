package presentation.ui.controller;

import javafx.fxml.FXML;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Sessione;

public class SchermataAdminController {

	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
@FXML
public void gestioneAuto(){
	fc.handleRequest("GestioneAuto");
	
}
@FXML
public void gestioneClienti(){
	fc.handleRequest("GestioneCliente");
	
}
@FXML
public void gestioneOperatori(){
	fc.handleRequest("GestioneOperatore");
	
}
@FXML
public void gestioneContratti(){
	fc.handleRequest("GestioneContratto");
}
@FXML
public void gestioneAgenzia(){
	fc.handleRequest("GestioneAgenzia");
}

@FXML
public void gestioneTariffe(){
	
	fc.handleRequest("GestioneTariffaBase");
	
}
@FXML
public void gestioneFasce(){
	fc.handleRequest("GestioneFascia");
}

@FXML
public void quit(){
	vd.quit();
}
}
