package presentation.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import entity.TariffaBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.ViewDispatcher;
import utility.Sessione;

public class MostraTariffaBaseController implements Initializable{
	ViewDispatcher vd = new ViewDispatcher();
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
	public void quit(){
		vd.quit();
	}
	@FXML
	public void indietro(){
		vd.indietro();
	}
}
