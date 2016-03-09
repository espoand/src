package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Auto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;
import entity.Fascia;
public class ModificaAutoController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
Auto a = null;
@FXML
TextField targa;
@FXML
TextField modello;
@FXML
TextField fascia;
@FXML
TextField km;

ArrayList<Fascia> tutteFasce;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		a = Sessione.getAuto();
		targa.setText(a.getTarga());
		modello.setText(a.getModello());
		fascia.setText(a.getFascia().getIdFascia());
		km.setText(Double.toString(a.getUltimoKmtraggio()));
		tutteFasce = (ArrayList<Fascia>) fc.handleRequest("TutteFasce");
		
	}
	@FXML
	public void indietro(){
		vd.indietro();
	}
	@FXML
	public void quit(){
		Sessione.azzera();
		System.exit(0);
	}
	@FXML
	public void submit(){
		if(modello.getText().isEmpty() || fascia.getText().isEmpty() || km.getText().isEmpty()){
			vd.showMessage("Non possono esserci campi vuoti");
		}
		Iterator<Fascia> it1 = tutteFasce.iterator();
		Fascia actual = null;
		Fascia temp = null;
		boolean eseguito = false;
		while(it1.hasNext()){
			temp = it1.next();
			if(temp.getIdFascia().equals(fascia.getText())){
				actual = temp;break;
			}
		}
		if(actual == null){
			vd.showMessage("La fascia con l'identificativo inserito non è stata trovata nel database");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(targa.getText());
			parameters.add(km.getText());
			eseguito = (boolean) fc.handleRequest("ModificaAuto",parameters);
		}
		if(eseguito){
			vd.showMessage("Completato");
			vd.indietro();
		}
		else{
			vd.showMessage("Si è verificato un errore");
			vd.indietro();
		}
	}
	
}
