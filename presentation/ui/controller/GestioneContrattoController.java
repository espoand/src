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
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Calculator;
import utility.InputController;
import utility.Sessione;

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
		 tabNroOrdine.setCellValueFactory(new PropertyValueFactory<Record,String>("nroOrdine"));
		 tabCf.setCellValueFactory(new PropertyValueFactory<Record,String>("cf"));
		 tabTarga.setCellValueFactory(new PropertyValueFactory<Record,String>("targa"));
		 listaContratti.setItems(lista);
		 listaContratti.getColumns().setAll(tabNroOrdine,tabCf,tabTarga);
	}
public class Record{
	private SimpleStringProperty nroOrdine;
	private SimpleStringProperty cf;
	private SimpleStringProperty targa;
	public Record(String a,String b ,String c){
		
	nroOrdine.set(a);
	cf.set(b);
	targa.set(c);
	}
	public SimpleStringProperty getNroOrdine() {
		return nroOrdine;
	}
	public void setNroOrdine(String nroOrdine) {
		this.nroOrdine.set(nroOrdine);
	}
	public SimpleStringProperty getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf.set(cf);
	}
	public SimpleStringProperty getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa.set(targa);
	}
}
}
