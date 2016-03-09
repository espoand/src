package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Agenzia;
import entity.Cliente;
import entity.Contratto;
import entity.Noleggio;
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
	TextField numeroOrdine;
	@FXML
	DatePicker dataFine;
	@FXML
	TextField agenziaNoleggio;
	@FXML
	TextField agenziaRiconsegna;
	ArrayList<Agenzia> tutteAgenzie;
	ArrayList<Cliente> tuttiClienti;
	Noleggio noleggio ;
	Contratto contratto;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		contratto = Sessione.getContrattoAttuale();
		cfCliente.setText(contratto.getCliente().getCodiceFiscale());
		dataNoleggio.setValue(contratto.getDataInizio());
		acconto.setText(Double.toString(contratto.getAcconto()));
		numeroOrdine.setText(Integer.toString(contratto.getNroOrdine()));
		dataFine.setValue(contratto.getFinePrevista());
		agenziaNoleggio.setText(Integer.toString(contratto.getAgenziaNoleggio().getIdentificativo()));
		agenziaRiconsegna.setText(Integer.toString(contratto.getAgenziaRestituzione().getIdentificativo()));
		
		
		
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
		tuttiClienti = (ArrayList<Cliente>) fc.handleRequest("TuttiClienti");
		Iterator<Cliente> it1 = tuttiClienti.iterator();
		Cliente tmp;
		while(it1.hasNext()){
			tmp = it1.next();
			if(tmp.getCodiceFiscale().equals(cfCliente.toString())){
				Sessione.setClienteAttuale(tmp);break;
				
			}
		}
		fc.handleRequest("MostraCliente");
		
	}
	@FXML
	public void mostraNoleggio(){
		ArrayList<String> parameters = new ArrayList<String>();
		
		noleggio = (Noleggio) fc.handleRequest("CercaNoleggio", parameters);
		if(noleggio!=null){
			Sessione.setNoleggioAttuale(noleggio);
			fc.handleRequest("MostraNoleggio");
		}
	}
	@FXML
	public void mostraAgenziaNoleggio(){
		tutteAgenzie = (ArrayList<Agenzia>) fc.handleRequest("TutteAgenzie");
		Iterator<Agenzia> it1 = tutteAgenzie.iterator();
		Agenzia tmp ;
		while(it1.hasNext()){
			tmp = it1.next();
			if(tmp.getIdentificativo() == Integer.parseInt(agenziaNoleggio.getText())){
				Sessione.setAgenziaAttuale(tmp);
			}
		}
		fc.handleRequest("MostraAgenzia");
	}
	@FXML
	public void mostraAgenziaRestituzione(){
		tutteAgenzie = (ArrayList<Agenzia>) fc.handleRequest("TutteAgenzie");
		Iterator<Agenzia> it1 = tutteAgenzie.iterator();
		Agenzia tmp ;
		while(it1.hasNext()){
			tmp = it1.next();
			if(tmp.getIdentificativo() == Integer.parseInt(agenziaRiconsegna.getText())){
				Sessione.setAgenziaAttuale(tmp);
			}
		}
		fc.handleRequest("MostraAgenzia");
	}
	
}
