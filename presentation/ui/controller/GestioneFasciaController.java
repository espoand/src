package presentation.ui.controller;
import entity.Fascia;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Iterator;

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
TextField identificativo;
@FXML
ListView<String> tutteFasce;
Fascia fascia = null;
ArrayList<Fascia> fasce = null;
@FXML	
public void cerca(){
	if(identificativo.getText().isEmpty()){
		vd.showMessage("Compila il campo identificativo");
	}
	if(!ic.onlyNumbersAndLetters(identificativo.getText())){
		vd.showMessage("Il campo identificativo deve essere composto solo da lettere e numeri");
	}
	
	Iterator<Fascia> it1 = fasce.iterator();
	Fascia tmp = null;
	while(it1.hasNext()){
		tmp = it1.next();
		if(tmp.getIdFascia().equals(identificativo.getText())){
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
	if(identificativo.getText().isEmpty()){
		vd.showMessage("Compila il campo identificativo inserendo l'identificativo della fascia da eliminare");
	}
	if(!ic.onlyNumbersAndLetters(identificativo.getText())){
		vd.showMessage("Il campo identificativo deve essere composto solo da lettere e numeri");
	}
	if(vd.areYouSure("Sei sicuro di voler eliminare la fascia?") == 0)
	{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(identificativo.getText());
		fc.handleRequest("RimuoviFascia", parameters);
	}
	
}
@FXML
public void modifica(){
	if(identificativo.getText().isEmpty()){
		vd.showMessage("Compila il campo identificativo");
	}
	if(!ic.onlyNumbersAndLetters(identificativo.getText())){
		vd.showMessage("Il campo identificativo deve essere composto solo da lettere e numeri");
	}
	
	Iterator<Fascia> it1 = fasce.iterator();
	Fascia tmp = null;
	while(it1.hasNext()){
		tmp = it1.next();
		if(tmp.getIdFascia().equals(identificativo.getText())){
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
	vd.indietro();
}
@FXML
public void quit(){
	vd.quit();
}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	fasce = (ArrayList<Fascia>) fc.handleRequest("TutteFasce");
	Iterator<Fascia> it  = fasce.iterator();
	while(it.hasNext()){
		tutteFasce.getItems().add(it.next().getIdFascia());
	}
	
}

}
