package presentation.ui.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Agenzia;
import entity.Cliente;
import entity.Noleggio;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
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
ChoiceBox<String> agenziaNoleggio;
@FXML
ChoiceBox<String> agenziaRiconsegna;
ArrayList<Agenzia> tutteAgenzie;
ArrayList<Cliente> tuttiClienti;
@FXML
public void indietro(){
	vd.indietro();
}
@FXML
public void quit(){
	vd.quit();
}
@FXML
public void gestioneNoleggio(){
	if(!ic.onlyNumbers(numeroOrdine.getText())){
		vd.showMessage("Numero ordine non valido");
	}
	else{
	ArrayList<String> parameters = new ArrayList<String>();
	parameters.add(numeroOrdine.getText());
	Noleggio noleggio = (Noleggio) fc.handleRequest("CercaNoleggio",parameters);
	Sessione.setNoleggioAttuale(noleggio);
	fc.handleRequest("MostraNoleggio");}
}
@FXML
public void submit(){
	if(cfCliente.getText().isEmpty() || dataNoleggio.getValue() == null|| acconto.getText().isEmpty() || dataFine.getValue()==null || agenziaNoleggio.getValue().isEmpty() || agenziaRiconsegna.getValue().isEmpty())
	{	vd.showMessage("Compilare tutti i campi");}
	if(dataNoleggio.getValue().isBefore(Sessione.today()) || dataNoleggio.getValue().isBefore(Sessione.today())){
		vd.showMessage("Le date devono essere successive a quella odierna");
	}
	if(!ic.onlyNumbersAndLetters(cfCliente.getText())){
		vd.showMessage("Codice fiscale non valido");
	}
	if(!ic.onlyNumbers(numeroOrdine.getText()) || !ic.onlyNumbers(acconto.getText())){
		vd.showMessage("Numero ordine e/o acconto non valido");
	}
	
	Agenzia agenziaN = null;
	Agenzia agenziaR = null;
	Cliente cliente = null;
	
	Iterator<Agenzia> it1 = tutteAgenzie.iterator();
	Agenzia agenziaTmp = null;
	while(it1.hasNext()){
		agenziaTmp = it1.next();
		if(agenziaTmp.getIdentificativo() == Integer.valueOf(agenziaNoleggio.getValue())){
			agenziaN = agenziaTmp;break;
		}}
	it1 = tutteAgenzie.iterator();
	while(it1.hasNext()){
		agenziaTmp = it1.next();
		if(agenziaTmp.getIdentificativo() == Integer.valueOf(agenziaRiconsegna.getValue())){
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
		parameters.add(agenziaNoleggio.getValue());
		parameters.add(agenziaRiconsegna.getValue());
		fc.handleRequest("InserisciContratto",parameters);
	}
	
	}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	tutteAgenzie = (ArrayList<Agenzia>) fc.handleRequest("TutteAgenzie");
	tuttiClienti=(ArrayList<Cliente>) fc.handleRequest("TuttiClienti");
	
	Iterator<Agenzia> it1 = tutteAgenzie.iterator();
	Agenzia tmp = null;
	while(it1.hasNext()){
		tmp = it1.next();
		agenziaNoleggio.getItems().add(Integer.toString(tmp.getIdentificativo()));
		agenziaRiconsegna.getItems().add(Integer.toString(tmp.getIdentificativo()));
		
	}
}
	
}



