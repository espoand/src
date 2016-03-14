package presentation.ui.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Agenzia;
import entity.Auto;
import entity.Cliente;
import entity.TariffaBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Calculator;
import utility.InputController;
import utility.Sessione;

public class AggiungiContrattoController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();

//Quando si clicca su illimitato si disabilita il nroKm e viceversa
@FXML
ChoiceBox<String> cfCliente;
@FXML
DatePicker dataNoleggio;
@FXML
TextField acconto;
@FXML
ChoiceBox<String> tariffa;
@FXML
TextField nroKm;
@FXML
CheckBox illimitati;
@FXML
ChoiceBox<String> auto;
@FXML
TextField importoTotale;
@FXML
DatePicker dataFine;
@FXML
ChoiceBox<String> agenziaNoleggio;
@FXML
ChoiceBox<String> agenziaRiconsegna;
ArrayList<Agenzia> tutteAgenzie;

@FXML
public void indietro(){
	fc.handleRequest("Home");
}
@FXML
public void quit(){
	vd.quit();
}

@FXML
public void submit(){
	if(tariffa.getValue().isEmpty() || auto.getValue().isEmpty() || importoTotale.getText().isEmpty() || cfCliente.getValue() == null || dataNoleggio.getValue() == null|| acconto.getText().isEmpty() || dataFine.getValue()==null || agenziaNoleggio.getValue().isEmpty() || agenziaRiconsegna.getValue().isEmpty())
	{	vd.showMessage("Compilare tutti i campi");}
	if(dataNoleggio.getValue().isBefore(Sessione.today()) || dataNoleggio.getValue().isBefore(Sessione.today()) || dataNoleggio.getValue().isAfter(dataFine.getValue())){
		vd.showMessage("Le date devono essere successive a quella odierna e la data di restituzione successiva a quella di noleggio");
	}
	if(!ic.onlyNumbersAndLetters(cfCliente.getValue()) || !ic.onlyNumbers(acconto.getText())){
		vd.showMessage("Codice fiscale e/o acconto non valido");
	}
	if(nroKm.getText().isEmpty() && !illimitati.isSelected()){
		vd.showMessage("Selezionare Km illimitati o inserire il numero di Km");
	}
	ArrayList<String> parameter = new ArrayList<String>();
	parameter.add(agenziaNoleggio.getValue());
	Agenzia agenziaN = null;
	agenziaN=(Agenzia) fc.handleRequest("CercaAgenzia",parameter);
	parameter = new ArrayList<String>();
	parameter.add(agenziaRiconsegna.getValue());
	
	
	Agenzia agenziaR =null;
	agenziaR=(Agenzia) fc.handleRequest("CercaAgenzia",parameter);
	parameter = new ArrayList<String>();
	parameter.add(cfCliente.getValue());
	Cliente cliente =null;
	cliente=(Cliente) fc.handleRequest("CercaCliente",parameter);
	
	
	if(agenziaR == null || agenziaN == null || cliente == null){
		vd.showMessage("Agenzia di riconsegna e/o di noleggio e/o Cliente non esistente");
	}
	
	
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cfCliente.getValue());
		parameters.add(dataNoleggio.getValue().toString());
		parameters.add(acconto.getText());
		
		parameters.add(dataFine.getValue().toString());
		parameters.add(agenziaNoleggio.getValue());
		parameters.add(agenziaRiconsegna.getValue());
		parameters.add(tariffa.getValue());
		parameters.add(Boolean.toString(illimitati.isSelected()));
		if(illimitati.isSelected()){parameters.add("1");}
		else{
		parameters.add(nroKm.getText());}
		parameters.add(auto.getValue());
		parameters.add(importoTotale.getText());
		fc.handleRequest("InserisciContratto",parameters);
	}
	
	}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	//agenzia noleggio riconsegna tariffa e auto
	tutteAgenzie = (ArrayList<Agenzia>) fc.handleRequest("TutteAgenzie");
	ArrayList<Auto> tutteAuto= (ArrayList<Auto>) fc.handleRequest("TutteAuto");	
	ArrayList<TariffaBase> tutteTariffe = (ArrayList<TariffaBase>) fc.handleRequest("TutteTariffe");
	Iterator<Agenzia> it1 = tutteAgenzie.iterator();
	Agenzia tmp = null;
	while(it1.hasNext()){
		tmp = it1.next();
		agenziaNoleggio.getItems().add(Integer.toString(tmp.getIdentificativo()));
		agenziaRiconsegna.getItems().add(Integer.toString(tmp.getIdentificativo()));
		
	}
	Iterator<Auto> it2 =tutteAuto.iterator();
	while(it2.hasNext()){
		auto.getItems().add(it2.next().getTarga());
	}
	Iterator<TariffaBase> it3 = tutteTariffe.iterator();
	while(it3.hasNext()){
		tariffa.getItems().add(it3.next().getNome());
	}
	
	ArrayList<Cliente> tuttiClienti = (ArrayList<Cliente>) fc.handleRequest("TuttiClienti");
	Iterator<Cliente> it4 = tuttiClienti.iterator();
	while(it4.hasNext()){
		cfCliente.getItems().add(it4.next().getCodiceFiscale());
	}
	
}
@FXML
public void totale(){
	if(dataNoleggio.getValue() == null || dataFine.getValue() == null || tariffa.getValue() == null ){
		vd.showMessage("Compilare i campi Data Inizio,data fine,tariffa ed inserire un numero di km o selezionare km illimitati ");
		}
	if(!illimitati.isSelected() && nroKm.getText().isEmpty()){
		vd.showMessage("Selezionare Km illimitati o inserire un numero di km da percorrere");
	}
	else{
		ArrayList<String> params = new ArrayList<String>();
		params.add(tariffa.getValue());
		TariffaBase tb = (TariffaBase) fc.handleRequest("CercaTariffaBase",params);
		Calculator calculator  = new Calculator();
		double importo = calculator.calcolaTotale(dataNoleggio.getValue(), dataFine.getValue(), illimitati.isSelected(),tb, Double.parseDouble(nroKm.getText()));
		importoTotale.setText(Double.toString(importo));
	}
	

}

@FXML
public void mostraCliente(){
	if(cfCliente.getValue()== null){
		vd.showMessage("Inserire un codice fiscale");
	}
	else{
	 Cliente c = null;
	 ArrayList<String> parameters = new ArrayList<String>();
	 parameters.add(cfCliente.getValue());
	 
	 c = (Cliente) fc.handleRequest("CercaCliente",parameters);
	 if(c!=null){
		 Sessione.setClienteAttuale(c);
		 fc.handleRequest("MostraCliente");
	 }
	 else vd.showMessage("Cliente non trovato");
	}
}

	
}




