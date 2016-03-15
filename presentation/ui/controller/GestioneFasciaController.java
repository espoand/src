package presentation.ui.controller;
import entity.Fascia;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class GestioneFasciaController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();

@FXML
ListView<String> tutteFasce;
Fascia fascia = null;
ArrayList<Fascia> fasce = null;
@FXML	
public void cerca(){
	if(tutteFasce.getSelectionModel().getSelectedItem().isEmpty()){
		vd.showMessage("Seleziona un elemento");
	}
	
	
	Iterator<Fascia> it1 = fasce.iterator();
	Fascia tmp = null;
	while(it1.hasNext()){
		tmp = it1.next();
		if(tmp.getIdFascia().equals(tutteFasce.getSelectionModel().getSelectedItem())){
			fascia = tmp;break;
		}
		
	}
	if(fascia !=null){
	Sessione.setFasciaAttuale(fascia);
	fc.handleRequest("MostraFascia");
	}
	
	
	
	}
@FXML
public void aggiungi(){
	fc.handleRequest("AggiungiFascia");
}
@FXML
public void elimina(){
	if(tutteFasce.getSelectionModel().getSelectedItem().isEmpty()){
		vd.showMessage("Seleziona un elemento");
	}
	if(vd.areYouSure("Sei sicuro di voler eliminare la fascia?") == 0)
	{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(tutteFasce.getSelectionModel().getSelectedItem());
		fc.handleRequest("RimuoviFascia", parameters);
	}
	
}
@FXML
public void modifica(){
	if(tutteFasce.getSelectionModel().getSelectedItem().isEmpty()){
		vd.showMessage("Seleziona un elemento");
	}
	
	Iterator<Fascia> it1 = fasce.iterator();
	Fascia tmp = null;
	while(it1.hasNext()){
		tmp = it1.next();
		if(tmp.getIdFascia().equals(tutteFasce.getSelectionModel().getSelectedItem())){
			fascia = tmp;break;
		}
		
	}
	if(fascia !=null){
	Sessione.setFasciaAttuale(fascia);
	fc.handleRequest("ModificaFascia");
	}
	
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
/**
 * 
 */
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	fasce = (ArrayList<Fascia>) fc.handleRequest("TutteFasce");
	Iterator<Fascia> it  = fasce.iterator();
	while(it.hasNext()){
		tutteFasce.getItems().add(it.next().getIdFascia());
	}
	
}

}
