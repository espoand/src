package presentation.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Sessione;

public class AmministratoreController implements Initializable{

	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
	
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
public void schermataOperatore(){
	fc.handleRequest("SchermataOperatore");
}
@FXML
public void gestioneAgenzia(){
	fc.handleRequest("GestioneAgenzia");
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
	vd.quit();
}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	
}
}
