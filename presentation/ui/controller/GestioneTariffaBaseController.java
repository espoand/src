package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Contratto;
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
ListView<String> tabella;


@FXML
public void cerca(){
	if(tabella.getSelectionModel().getSelectedItem() == null){
		vd.showMessage("Selezionare un elemento");
	}
	else{
		ArrayList<String> parameters  = new ArrayList<String>();
		parameters.add(tabella.getSelectionModel().getSelectedItem());
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
	if(tabella.getSelectionModel().getSelectedItem() == null){
		vd.showMessage("Selezionare un elemento ");
	}
	else{
		ArrayList<String> parameters  = new ArrayList<String>();
		parameters.add(tabella.getSelectionModel().getSelectedItem());
		TariffaBase tf = null;
		tf = (TariffaBase) fc.handleRequest("CercaTariffaBase",parameters);	
		Sessione.setTariffaAttuale(tf);
		fc.handleRequest("ModificaTariffaBase");
	}
}

@FXML
public void elimina(){
	if(tabella.getSelectionModel().getSelectedItem() == null){
		
		vd.showMessage("Selezionare un elemento ");
	}
	else{
		if(!isInContract(tabella.getSelectionModel().getSelectedItem())){
		if(vd.areYouSure("Sei sicuro di voler procedere?")== 0){
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(tabella.getSelectionModel().getSelectedItem());
			boolean eseguito = (boolean) fc.handleRequest("RimuoviTariffaBase", parameters);
			if(eseguito){vd.showMessage("Operazione completata");vd.ricarica();}
			else vd.showMessage("Si è verificato un errore");
	}
		else vd.showMessage("Eliminare prima tutti i contratti stipulati con questa tariffa"); 
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
	Iterator<TariffaBase> it1 = tutteTariffe.iterator();
	while(it1.hasNext()){
		tabella.getItems().add(it1.next().getNome());
	}
	
	
}
public boolean isInContract(String nome){
	ArrayList<Contratto> tuttiContratti = (ArrayList<Contratto>) fc.handleRequest("TuttiContratti");
	Iterator<Contratto> it1 = tuttiContratti.iterator();
	Contratto tmp ;
	while(it1.hasNext()){
		tmp = it1.next();
		if(tmp.getTariffaBase().getNome().equals(nome)){
			return true;
		}
	}
	return false;
	
	
}

}
