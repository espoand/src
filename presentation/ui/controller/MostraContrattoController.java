package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Agenzia;
import entity.Cliente;
import entity.Contratto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class MostraContrattoController implements Initializable{
	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
	InputController ic = new InputController();
	@FXML
	TextField cfCliente;
	@FXML
	DatePicker dataNoleggio;
	@FXML
	TextField acconto;
		@FXML
	DatePicker dataFineNoleggio;
	@FXML
	TextField agenziaNoleggio;
	@FXML
	TextField agenziaRiconsegna;
	@FXML
	TextField tariffa;
	@FXML
	TextField nroKm;
	@FXML
	TextField auto;
	@FXML
	TextField importoTotale;
	ArrayList<Agenzia> tutteAgenzie;
	ArrayList<Cliente> tuttiClienti;
	Contratto contratto;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		contratto = Sessione.getContrattoAttuale();
		cfCliente.setText(contratto.getCliente().getCodiceFiscale());
		dataNoleggio.setValue(contratto.getDataInizio());
		acconto.setText(Double.toString(contratto.getAcconto()));
		dataFineNoleggio.setValue(contratto.getFinePrevista());
		agenziaNoleggio.setText(Integer.toString(contratto.getAgenziaNoleggio().getIdentificativo()));
		agenziaRiconsegna.setText(Integer.toString(contratto.getAgenziaRestituzione().getIdentificativo()));
		tariffa.setText(contratto.getTariffaBase().getNome());
		if(contratto.isKmIllimitato()){
			nroKm.setText("Illimitato");
		}
		else nroKm.setText(Double.toString(contratto.getNroKm()));
		auto.setText(contratto.getAutoNoleggiata().getTarga());
		importoTotale.setText(Double.toString(contratto.getImportoTotale()));
		
		
		
	}
	@FXML
	public void quit(){
		vd.quit();
	}
	@FXML
	public void home(){
		fc.handleRequest("Home");
	}
	@FXML
	public void mostraCliente(){
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(contratto.getCliente().getCodiceFiscale());
		//questa operazione di ricerca è fatta per ottenere dati più aggiorati
		Cliente cliente = (Cliente) fc.handleRequest("CercaCliente",parameters);
		if(cliente!=null){
			Sessione.setClienteAttuale(cliente);
			fc.handleRequest("MostraCliente");
		}
		else vd.showMessage("Si è verificato un errore");
		
	}
	
	
	@FXML
	public void mostraAgenziaNoleggio(){
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(Integer.toString(contratto.getAgenziaNoleggio().getIdentificativo()));
		Agenzia agNoleggio =(Agenzia) fc.handleRequest("CercaAgenzia",parameters);
		if(agNoleggio!=null){
			Sessione.setAgenziaAttuale(agNoleggio);
			fc.handleRequest("MostraAgenzia");
		}
		else vd.showMessage("Si è verificato un errore");
	}
	@FXML
	public void mostraAgenziaRestituzione(){
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(Integer.toString(contratto.getAgenziaRestituzione().getIdentificativo()));
		Agenzia agRestituzione =(Agenzia) fc.handleRequest("CercaAgenzia",parameters);
		if(agRestituzione!=null){
			Sessione.setAgenziaAttuale(agRestituzione);
			fc.handleRequest("MostraAgenzia");
		}
		else vd.showMessage("Si è verificato un errore");
	}
	
}
