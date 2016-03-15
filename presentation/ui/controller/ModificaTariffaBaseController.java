package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.TariffaBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class ModificaTariffaBaseController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
TariffaBase tariffa ;
@FXML
TextField nome;
@FXML
TextField costoKm;
@FXML
TextField costoKmExtra;
@FXML
TextField giornoExtra;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tariffa = Sessione.getTariffaAttuale();
		nome.setText(tariffa.getNome());
		costoKm.setText(Double.toString(tariffa.getCostoAlKm()));
		costoKmExtra.setText(Double.toString(tariffa.getCostoAlKmExtra()));
		giornoExtra.setText(Double.toString(tariffa.getCostoAlGiornoExtra()));
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
public void submit(){
		if(costoKm.getText().isEmpty() || costoKmExtra.getText().isEmpty() || giornoExtra.getText().isEmpty()){
			vd.showMessage("Compilare tutti i campi");
		}
		if(!ic.isDouble(costoKm.getText()) || !ic.isDouble(costoKmExtra.getText()) || !ic.isDouble(giornoExtra.getText()) ){
			vd.showMessage("Inserire solo valori numerici nei campi!");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(nome.getText());
			parameters.add(costoKm.getText());
			parameters.add(costoKmExtra.getText());
			parameters.add(giornoExtra.getText());
			boolean eseguito = (boolean) fc.handleRequest("ModificaTariffaBase",parameters);
			if(eseguito){
				vd.showMessage("Completato"); vd.home();
			}
			else{
				vd.showMessage("Si è verificato un errore");
				vd.home();
			}
			
		}
	}
}
