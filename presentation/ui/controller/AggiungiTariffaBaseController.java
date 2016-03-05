package presentation.ui.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class AggiungiTariffaBaseController {
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField nome;
@FXML
TextField costoKm;
@FXML
TextField costoKmExtra;
@FXML
TextField costoGiornoExtra;
@FXML
public void sumbit(){
	if(nome.getText().isEmpty() || costoKm.getText().isEmpty() || costoKmExtra.getText().isEmpty() || costoGiornoExtra.getText().isEmpty()){
		vd.showMessage("Compilare tutti i campi");
	}
	if(!ic.isDouble(costoKm.getText()) || !ic.isDouble(costoKmExtra.getText()) || !ic.isDouble(costoGiornoExtra.getText()) ){
		vd.showMessage("Nei campi Costo al Km,Costo al KM extra e Costo al giorno extra è possibile inserire solo numeri");
	}
	else{
		ArrayList<String> parameters= new ArrayList<String>();
		parameters.add(nome.getText());
		parameters.add(costoKm.getText());
		parameters.add(costoKmExtra.getText());
		parameters.add(costoGiornoExtra.getText());
		fc.handleRequest("AggiungiTariffaBase", parameters);
	}
}
@FXML
public void quit(){
	Sessione.azzera();
	System.exit(0);
}
@FXML
public void indietro(){
	vd.indietro();
}

}
