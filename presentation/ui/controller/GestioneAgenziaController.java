package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Agenzia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import presentation.ui.controller.GestioneContrattoController.Record;
import utility.InputController;
import utility.Sessione;

public class GestioneAgenziaController implements Initializable{
	ViewDispatcher vd = new ViewDispatcher();
	FrontController fc = new FrontController();
	InputController ic = new InputController();
@FXML
TextField id;
@FXML
TableView<String> listaAgenzie;
@FXML
public void cerca(){
	if(!ic.onlyNumbers(id.getText())){
		vd.showMessage("Id non valido");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(id.getText());
		Agenzia ag = (Agenzia) fc.handleRequest("CercaAgenzia",parameters);
		if(ag!=null){
			Sessione.setAgenziaAttuale(ag);
			fc.handleRequest("MostraAgenzia");
		}
		else{
			vd.showMessage("Agenzia non trovata");
		}
	}
}
@FXML
public void quit(){vd.quit();}
@FXML
public void aggiungi(){fc.handleRequest("AggiungiAgenzia");}
@FXML
public void elimina(){
	if(!ic.onlyNumbers(id.getText())){
		vd.showMessage("Id non valido");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(id.getText());
		if(vd.areYouSure("Sei sicuro di voler procedere?") == 0){
			boolean eseguito = (boolean) fc.handleRequest("RimuoviAgenzia",parameters);
			if(eseguito){
				vd.showMessage("Completato");
		}
			else vd.showMessage("Si è verificato un errore");
	}}
}
@FXML
public void modifica(){
	if(!ic.onlyNumbers(id.getText())){
		vd.showMessage("Id non valido");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(id.getText());
		Agenzia ag = (Agenzia) fc.handleRequest("CercaAgenzia",parameters);
		if(ag!=null){
			Sessione.setAgenziaAttuale(ag);
			fc.handleRequest("ModificaAgenzia");
		}
		else{
			vd.showMessage("Agenzia non trovata");
		}
	}
}
@FXML
public void home(){fc.handleRequest("Home");}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ArrayList<Agenzia> tutteAgenzie = (ArrayList<Agenzia>) fc.handleRequest("TutteAgenzie");
		Iterator<Agenzia> it1 = tutteAgenzie.iterator();
		ObservableList<Record> lista =  FXCollections.observableArrayList();
		Agenzia tmp = null;
		while(it1.hasNext()){
			tmp.
		}
		
		
		
	}

}
