package presentation.ui.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Agenzia;
import entity.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class AggiungiContrattoController implements Initializable{
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
TextField numeroOrdine;
@FXML
DatePicker dataFine;
@FXML
TextField agenziaNoleggio;
@FXML
TextField agenziaRiconsegna;
ArrayList<Agenzia> tutteAgenzie;
ArrayList<Cliente> tuttiClienti;
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
public void gestioneNoleggio(){
	fc.handleRequest("GestioneNoleggio");
}
@FXML
public void submit(){
	if(cfCliente.getText().isEmpty() || dataNoleggio.getValue() == null|| acconto.getText().isEmpty() || dataFine.getValue()==null || agenziaNoleggio.getText().isEmpty() || agenziaRiconsegna.getText().isEmpty())
	{	vd.showMessage("Compilare tutti i campi");}
	if(dataNoleggio.getValue().isBefore(Sessione.today())){
		vd.showMessage("Data inizio noleggio non valida");
	}
	if(dataNoleggio.getValue().isBefore(Sessione.today())){
		vd.showMessage("Data fine noleggio non valida");
	}
	if(!ic.onlyNumbersAndLetters(cfCliente.getText())){
		vd.showMessage("Codice fiscale non valido");
	}
	if(!ic.onlyNumbers(numeroOrdine.getText())){
		vd.showMessage("Numero ordine non valido");
	}
	if(!ic.onlyNumbers(acconto.getText())){
		vd.showMessage("Il valore inserito nel campo acconto non è valido");
	}
	Agenzia agenziaN = null;
	Agenzia agenziaR = null;
	Cliente cliente = null;
	
	Iterator<Agenzia> it1 = tutteAgenzie.iterator();
	Agenzia agenziaTmp = null;
	while(it1.hasNext()){
		agenziaTmp = it1.next();
		if(agenziaTmp.getIdentificativo() == Integer.valueOf(agenziaNoleggio.getText())){
			agenziaN = agenziaTmp;break;
		}}
	it1 = tutteAgenzie.iterator();
	while(it1.hasNext()){
		agenziaTmp = it1.next();
		if(agenziaTmp.getIdentificativo() == Integer.valueOf(agenziaRiconsegna.getText())){
			agenziaR = agenziaTmp;break;
		}}
	Iterator<Cliente> it2 = tuttiClienti.iterator();
	Cliente clientetmp = null;
	while(it2.hasNext()){
		clientetmp = it2.next();
		if(clientetmp.getCodiceFiscale().equals(cfCliente.getText())){
			cliente = clientetmp;break;
		}
	}
	
	if(agenziaR == null){
		vd.showMessage("Agenzia di riconsegna non esistente");
	}
	if(agenziaN == null){
		vd.showMessage("Agenzia di noleggio non esistente");
	}
	if(cliente == null){
		vd.showMessage("Cliente inesistente");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cfCliente.getText());
		parameters.add(dataNoleggio.getValue().toString());
		parameters.add(acconto.getText());
		parameters.add(numeroOrdine.getText());
		parameters.add(dataFine.getValue().toString());
		parameters.add(agenziaNoleggio.getText());
		parameters.add(agenziaRiconsegna.getText());
		fc.handleRequest("InserisciContratto",parameters);
	}
	
	}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	tutteAgenzie = (ArrayList<Agenzia>) fc.handleRequest("TutteAgenzie");
	tuttiClienti=(ArrayList<Cliente>) fc.handleRequest("TuttiClienti");
}
	
}



