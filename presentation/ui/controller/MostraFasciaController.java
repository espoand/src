package presentation.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Fascia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Sessione;

public class MostraFasciaController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
@FXML
TextField idFascia;
@FXML
TextField descrizione;
@FXML
TextField tariffa;
Fascia fascia  = null;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		fascia = Sessione.getFasciaAttuale();
		idFascia.insertText(0, fascia.getIdFascia());
		descrizione.insertText(0, fascia.getDescrizioneFascia());
		tariffa.insertText(0, fascia.getTariffaFascia().getNome());
		
	}
@FXML
public void indietro(){
vd.home();
}
@FXML
public void quit(){
	vd.quit();
}
@FXML
public void mostraTariffa(){
	Sessione.setTariffaAttuale(fascia.getTariffaFascia());
	fc.handleRequest("MostraTariffa");
}
}
