package presentation.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Auto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Sessione;

public class MostraAutoController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
@FXML
TextField targa;
@FXML
TextField modello;
@FXML
TextField fascia;
@FXML
TextField km;
Auto a;
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
	a = Sessione.getAuto();
	if(a==null){
		vd.showMessage("Si è verificato un errore");
		quit();
		}
	else {targa.insertText(0, a.getTarga());
			modello.insertText(0, a.getModello());
			fascia.insertText(0, a.getFascia().getDescrizioneFascia());
			km.insertText(0, Double.toString(a.getUltimoKmtraggio()));
	}
	
}

}
