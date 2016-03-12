package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Contratto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Calculator;
import utility.InputController;
import utility.Sessione;
sada;

public class GestioneContrattoController implements Initializable{
	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
	InputController ic = new InputController();
	Calculator calculator = new Calculator();
	@FXML
	TextField nroOrdine;
	@FXML
	TableView<Record> listaContratti;
	@FXML
	TableColumn tabNroOrdine;
	@FXML
	TableColumn tabCf;
	@FXML 
	TableColumn tabTarga;
	@FXML
	public void cerca(){
		if(nroOrdine.getText().isEmpty() ){
			vd.showMessage("Compilare il campo Numero Ordine");
		}
		if(!ic.onlyNumbers(nroOrdine.getText())){
			vd.showMessage("Numero Ordine non valido");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(nroOrdine.getText());
			Contratto c = (Contratto) fc.handleRequest("CercaContratto",parameters);
			Sessione.setContrattoAttuale(c);
			fc.handleRequest("MostraContratto");
		}
	}
	@FXML
	public void aggiungi(){
		fc.handleRequest("AggiungiContratto");
	}
	@FXML
	public void modifica(){
		if(nroOrdine.getText().isEmpty() ){
			vd.showMessage("Compilare il campo Numero Ordine");
		}
		if(!ic.onlyNumbers(nroOrdine.getText())){
			vd.showMessage("Numero Ordine non valido");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(nroOrdine.getText());
			Contratto c = (Contratto) fc.handleRequest("CercaContratto",parameters);
			Sessione.setContrattoAttuale(c);
			boolean eseguito = (boolean) fc.handleRequest("ModificaContratto");
			if(eseguito){
				vd.showMessage("Completato");
				
			}
			else vd.showMessage("Si è verificato un errore");
		}
	}
	@FXML
	public void elimina(){
		if(nroOrdine.getText().isEmpty() ){
			vd.showMessage("Compilare il campo Numero Ordine");
		}
		if(!ic.onlyNumbers(nroOrdine.getText()) ){
			vd.showMessage("Numero Ordine non valido");
		}
		
		else{
			boolean eseguito = false;
			if(vd.areYouSure("Sei sicuro di voler procedere?")== 0){
				ArrayList<String> parameters = new ArrayList<String>();
				parameters.add(nroOrdine.getText());
				eseguito = (boolean) fc.handleRequest("RimuoviContratto",parameters);
				
			}
			if(eseguito){
				vd.showMessage("Completato");vd.indietro();
			}
			else{
				vd.showMessage("Si è verificato un errore");vd.indietro();
			}
		}
	}
	@FXML
	public void indietro(){
		vd.indietro();
	}
	@FXML
	public void quit(){
		vd.quit();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ArrayList<Contratto> tuttiContratti = (ArrayList<Contratto>) fc.handleRequest("TuttiContratti");
		Iterator<Contratto> it1 = tuttiContratti.iterator();
		Contratto tmp = null;
		ObservableList<Record> lista =  FXCollections.observableArrayList();
		
		while(it1.hasNext()){
			tmp= it1.next();
			lista.add(new Record(Integer.toString(tmp.getNroOrdine()),tmp.getCliente().getCodiceFiscale(),tmp.getAutoNoleggiata().getTarga()));
		}
		listaContratti.setItems(lista);		
	}
public class Record{
	private String nroOrdine;
	private String cf;
	private String targa;
	public Record(String a,String b ,String c){
		nroOrdine = a; cf = b;targa = c;}
}
}
