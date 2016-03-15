package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Agenzia;
import entity.Auto;
import entity.Cliente;
import entity.Contratto;
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

public class ModificaContrattoController implements Initializable{
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
Contratto contratto;
	ArrayList<Agenzia> tutteAgenzie;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tutteAgenzie = (ArrayList<Agenzia>) fc.handleRequest("TutteAgenzie");
		Iterator<Agenzia> it1 = tutteAgenzie.iterator();
		ArrayList<Auto> tutteAuto = new ArrayList<Auto>();
		ArrayList<TariffaBase> tutteTariffe = new ArrayList<TariffaBase>();
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
		contratto = Sessione.getContrattoAttuale();
		cfCliente.setText(contratto.getCliente().getCodiceFiscale());
		dataNoleggio.setValue(contratto.getDataInizio());
		acconto.setText(Double.toString(contratto.getAcconto()));
		dataFine.setValue(contratto.getFinePrevista());
		agenziaNoleggio.setValue(Integer.toString(contratto.getAgenziaNoleggio().getIdentificativo()));
		agenziaRiconsegna.setValue(Integer.toString(contratto.getAgenziaRestituzione().getIdentificativo()));
		tariffa.setValue(contratto.getTariffaBase().getNome());
		nroKm.setText(Double.toString(contratto.getNroKm()));
		illimitati.setSelected(contratto.isKmIllimitato());
		auto.setValue(contratto.getAutoNoleggiata().getTarga());
		
		
		
		
		
	}
	@FXML
	public void submit(){
		if(tariffa.getValue().isEmpty() || auto.getValue().isEmpty() || importoTotale.getText().isEmpty() || cfCliente.getText().isEmpty() || dataNoleggio.getValue() == null|| acconto.getText().isEmpty() || dataFine.getValue()==null || agenziaNoleggio.getValue().isEmpty() || agenziaRiconsegna.getValue().isEmpty())
		{	vd.showMessage("Compilare tutti i campi");}
		if(dataNoleggio.getValue().isBefore(Sessione.today()) || dataNoleggio.getValue().isBefore(Sessione.today())){
			vd.showMessage("Le date devono essere successive a quella odierna");
		}
		if(!ic.onlyNumbersAndLetters(cfCliente.getText()) || !ic.onlyNumbers(acconto.getText())){
			vd.showMessage("Codice fiscale e/o acconto non valido");
		}
		if(nroKm.getText().isEmpty() && !illimitati.isSelected()){
			vd.showMessage("Selezionare Km illimitati o inserire il numero di Km");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(cfCliente.getText());
			parameters.add(dataNoleggio.getValue().toString());
			parameters.add(acconto.getText());
			parameters.add(dataFine.getValue().toString());
			parameters.add(agenziaNoleggio.getValue());
			parameters.add(agenziaRiconsegna.getValue());
			parameters.add(tariffa.getValue());
			parameters.add(Boolean.toString(illimitati.isSelected()));
			parameters.add(nroKm.getText());
			parameters.add(auto.getValue());
			parameters.add(importoTotale.getText());
			
			
			
			boolean eseguito=(boolean) fc.handleRequest("ModificaContratto",parameters);
			if(eseguito ){
				vd.showMessage("Completato");vd.indietro();
			}
			else{
				vd.showMessage("Si è verificato un errore");vd.indietro();
			}
		}
	}
	@FXML
	public void quit(){
		vd.quit();
	}
	@FXML
	public void indietro(){
		vd.home();
		
	}
	@FXML
	public void chiudi(){
		if(vd.areYouSure("Sei sicuro?L'operazione è irreversibile!")==0){
			ArrayList<String> parameter = new ArrayList<String>();
			parameter.add(Integer.toString(contratto.getNroOrdine()));
			boolean eseguito = (boolean) fc.handleRequest("ChiudiContratto",parameter);
			if(eseguito){
				contratto.setChiuso(true);
				vd.showMessage("Completato");
				Sessione.setContrattoAttuale(contratto);
				fc.handleRequest("MostraContratto");
			}
			else{
				vd.showMessage("Si è verificato un errore");
			}
}
		
}
	@FXML
	public void mostraCliente(){
		Cliente c = contratto.getCliente();
		Sessione.setClienteAttuale(c);
		fc.handleRequest("MostraCliente");
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
	
}
