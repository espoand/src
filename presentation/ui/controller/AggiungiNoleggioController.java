package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.TariffaBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class AggiungiNoleggioController implements Initializable{
FrontController fc = new FrontController();
InputController ic = new InputController();
ViewDispatcher vd = new ViewDispatcher();
@FXML
ChoiceBox<String> tariffa;
@FXML
TextField targa;
@FXML
CheckBox kmIllimitati;
@FXML
DatePicker data;
@FXML
TextField totale;

@FXML
public void submit(){}
@FXML
public void calcolaTotale(){
	if(tariffa.getValue().isEmpty() || data.getValue().isBefore(Sessione.today())){
		vd.showMessage("Data errata o tariffa non selezionata");
	}
	
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ArrayList<TariffaBase> tutteTariffe = (ArrayList<TariffaBase>) fc.handleRequest("TutteTariffe");
		Iterator<TariffaBase> it1 = tutteTariffe.iterator();
		ArrayList<String> nomeTariffe = new ArrayList<String>();
		while(it1.hasNext()){
			
			nomeTariffe.add(it1.next().getNome());
		}
		tariffa.getItems().addAll(nomeTariffe);
		
	}

}
