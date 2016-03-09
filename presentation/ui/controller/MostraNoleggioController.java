package presentation.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Noleggio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.ViewDispatcher;
import utility.Sessione;

public class MostraNoleggioController implements Initializable{
	ViewDispatcher vd = new ViewDispatcher();
Noleggio noleggio ;
@FXML
TextField nroOrdine;
@FXML
TextField tariffa;
@FXML
TextField targa;
@FXML
TextField riconsegna;
@FXML
TextField totale;
@FXML
TextField illimitati;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		noleggio = Sessione.getNoleggioAttuale();
		nroOrdine.setText(Integer.toString(noleggio.getNroOrdine()));
		tariffa.setText(noleggio.getTariffaBase().getNome());
		targa.setText(noleggio.getAutoNoleggiata().getTarga());
		riconsegna.setText(noleggio.getDataEffettivaRiconsegna().toString());
		totale.setText(Double.toString(noleggio.getImportoTotale()));
		illimitati.setText(Boolean.toString(noleggio.isKmIllimitato()));
		
		
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
