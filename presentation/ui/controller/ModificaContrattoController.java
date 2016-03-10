package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Agenzia;
import entity.Contratto;
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
	TextField numeroOrdine;
	@FXML
	DatePicker dataFine;
	@FXML
	ChoiceBox<String> agenziaNoleggio;
	@FXML
	ChoiceBox<String> agenziaRiconsegna;
	Contratto contratto ;
	ArrayList<Agenzia> tutteAgenzie;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tutteAgenzie = (ArrayList<Agenzia>) fc.handleRequest("TutteAgenzie");
		Iterator<Agenzia> it1 = tutteAgenzie.iterator();
		Agenzia tmp = null;
		while(it1.hasNext()){
			tmp = it1.next();
			agenziaNoleggio.getItems().add(Integer.toString(tmp.getIdentificativo()));
			agenziaRiconsegna.getItems().add(Integer.toString(tmp.getIdentificativo()));
			
		}
		contratto = Sessione.getContrattoAttuale();
		cfCliente.setText(contratto.getCliente().getCodiceFiscale());
		dataNoleggio.setValue(contratto.getDataInizio());
		acconto.setText(Double.toString(contratto.getAcconto()));
		numeroOrdine.setText(Integer.toString(contratto.getNroOrdine()));
		dataFine.setValue(contratto.getFinePrevista());
		agenziaNoleggio.setValue(Integer.toString(contratto.getAgenziaNoleggio().getIdentificativo()));
		agenziaRiconsegna.setValue(Integer.toString(contratto.getAgenziaRestituzione().getIdentificativo()));
		
		
	}
	@FXML
	public void submit(){
		if(cfCliente.getText().isEmpty() || dataNoleggio.getValue() == null|| acconto.getText().isEmpty() || dataFine.getValue()==null || agenziaNoleggio.getValue().isEmpty() || agenziaRiconsegna.getValue().isEmpty()  )
		{	vd.showMessage("Compilare tutti i campi");}
		if(dataNoleggio.getValue().isBefore(Sessione.today()) || dataNoleggio.getValue().isBefore(Sessione.today()) || !ic.onlyNumbers(acconto.getText())){
			vd.showMessage("Le date devono essere successive a quella odierna e l'acconto deve essere valido!");
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
		fc.handleRequest("Home");
		
	}
	@FXML
	public void gestioneNoleggio(){
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(numeroOrdine.getText());
		Noleggio noleggio = (Noleggio) fc.handleRequest("CercaNoleggio",parameters);
		Sessione.setNoleggioAttuale(noleggio);
		fc.handleRequest("MostraNoleggio");
		
	}
	
}
