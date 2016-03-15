package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.TariffaBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class GestioneTariffaBaseController implements Initializable{
	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
	InputController ic = new InputController();
	
@FXML
TextField nome;
@FXML 
ListView<String> tabella;


@FXML
public void cerca(){
	if(nome.getText().isEmpty()){
		vd.showMessage("Riempire il campo nome");
	}
	else{
		ArrayList<String> parameters  = new ArrayList<String>();
		parameters.add(nome.getText());
		TariffaBase tf = null;
		tf = (TariffaBase) fc.handleRequest("CercaTariffaBase",parameters);	
		Sessione.setTariffaAttuale(tf);
		fc.handleRequest("MostraTariffaBase");
	}
}
@FXML
public void aggiungi(){
	fc.handleRequest("AggiungiTariffaBase");
}

@FXML
public void modifica(){
	if(nome.getText().isEmpty()){
		vd.showMessage("Riempire il campo nome");
	}
	else{
		ArrayList<String> parameters  = new ArrayList<String>();
		parameters.add(nome.getText());
		TariffaBase tf = null;
		tf = (TariffaBase) fc.handleRequest("CercaTariffaBase",parameters);	
		Sessione.setTariffaAttuale(tf);
		fc.handleRequest("ModificaTariffaBase");
	}
}

@FXML
public void elimina(){
	if(nome.getText().isEmpty()){
		
		vd.showMessage("Compilare il campo nome");
	}
	else{
		if(vd.areYouSure("Sei sicuro di voler procedere?")== 0){
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(nome.getText());
			fc.handleRequest("RimuoviTariffaBase", parameters);
			vd.showMessage("Operazione completata");
	}}
}

@FXML
public void indietro(){
	vd.home();
}

@FXML
public void quit(){
	vd.quit();
}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	ArrayList<TariffaBase> tutteTariffe = (ArrayList<TariffaBase>) fc.handleRequest("TutteTariffe");
	
}

}
