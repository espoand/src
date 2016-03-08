package presentation.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class GestioneTariffaBaseController {
	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
	InputController ic = new InputController();
	alallalala;
@FXML
TextField nome;
@FXML
public void cerca(){}
@FXML
public void aggiungi(){}
@FXML
public void modifica(){}
@FXML
public void elimina(){}
@FXML
public void indietro(){}
@FXML
public void quit(){
	Sessione.azzera();
	System.exit(0);
}

}
