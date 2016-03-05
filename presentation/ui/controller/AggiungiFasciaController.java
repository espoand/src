package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Fascia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;

public class AggiungiFasciaController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField idFascia;
@FXML
TextField descrizioneFascia;
@FXML 
ChoiceBox tariffa;

public void submit(){
	
	
}
public void quit(){}
public void indietro(){}

@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	ArrayList<Fascia> tutteFasce = (ArrayList<Fascia>) fc.handleRequest("TutteFasce");
	
}

}
