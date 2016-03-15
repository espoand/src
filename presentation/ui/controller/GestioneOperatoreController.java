package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;


import entity.Operatore;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import presentation.FrontController;
import presentation.ViewDispatcher;
import presentation.ui.controller.GestioneManutenzioneController.Record;
import utility.InputController;
import utility.Sessione;

public class GestioneOperatoreController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField cf;
@FXML
TableView<Record> tabella;
@FXML
public void cerca(){
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
	}
	else if(!ic.onlyNumbersAndLetters(cf.getText())){
		vd.showMessage("Codice fiscale non valido");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cf.getText());
		Operatore operatore = (Operatore) fc.handleRequest("CercaOperatore", parameters);
		Sessione.setOperatoreAttuale(operatore);
		fc.handleRequest("MostraOperatore");
		
	}
}
@FXML
public void aggiungi(){
	fc.handleRequest("AggiungiOperatore");
}
@FXML
public void elimina(){
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
	}
	if(!ic.onlyNumbersAndLetters(cf.getText()) || Sessione.getUsername().equals(cf.getText())){
		vd.showMessage("Codice fiscale non valido o utente attualmente loggato");
	}
	else{
	 if(vd.areYouSure("Sei sicuro di voler procedere?") == 0){
		 ArrayList<String> parameters = new ArrayList<String>();
		 parameters.add(cf.getText());
		 fc.handleRequest("RimuoviOperatore", parameters);
	 }
	 
	}
}
@FXML
public void modifica(){	
	if(cf.getText().isEmpty()){
	vd.showMessage("Compilare il campo codice fiscale");
}
if(!ic.onlyNumbersAndLetters(cf.getText())){
	vd.showMessage("Codice fiscale non valido");
}
else{
	ArrayList<String> parameters = new ArrayList<String>();
	parameters.add(cf.getText());
	Operatore operatore = (Operatore) fc.handleRequest("CercaOperatore", parameters);
	Sessione.setOperatoreAttuale(operatore);
	fc.handleRequest("ModificaOperatore");
	
}
}

@FXML
public void indietro(){
	vd.home();
}
@FXML
public void quit(){
	vd.quit();
}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	ArrayList<Operatore> tuttiOperatori = (ArrayList<Operatore>) fc.handleRequest("TuttiOperatori");
	 ObservableList<Record> lista = FXCollections.observableArrayList();
	 	TableColumn<Record,String> nomeTable = new TableColumn("Nome");
		TableColumn<Record,String> cognomeTable = new TableColumn("Cognome");
		TableColumn<Record,String> cfTable = new TableColumn("Codice Fiscale");
		tabella.setPrefWidth(Region.USE_COMPUTED_SIZE);
		nomeTable.prefWidthProperty().bind(tabella.widthProperty().divide(3));
		cognomeTable.prefWidthProperty().bind(tabella.widthProperty().divide(3));
		cfTable.prefWidthProperty().bind(tabella.widthProperty().divide(3));
		Iterator<Operatore> it1 = tuttiOperatori.iterator();
		Operatore tmp = null;
		while(it1.hasNext()){
			tmp = it1.next();
			lista.add(new Record(tmp.getNome(),tmp.getCognome(),tmp.getCf()));
		}
		nomeTable.setCellValueFactory(new PropertyValueFactory<Record,String>("nome"));
		 cognomeTable.setCellValueFactory(new PropertyValueFactory<Record,String>("cognome"));
		 cfTable.setCellValueFactory(new PropertyValueFactory<Record,String>("cf"));
		 
		 tabella.setItems(lista);
		 tabella.getColumns().setAll(nomeTable,cognomeTable,cfTable);
		
}
public class Record{
	private SimpleStringProperty nome;
	private SimpleStringProperty cognome;
	private SimpleStringProperty cf;
	public Record(String n,String c,String co){
		nome = new SimpleStringProperty(n);
		cognome = new SimpleStringProperty(c);
		cf = new SimpleStringProperty(co);
		
	}
	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
		this.nome = new SimpleStringProperty(nome);
	}
	public String getCognome() {
		return cognome.get();
	}
	public void setCognome(String cognome) {
		this.cognome = new SimpleStringProperty(cognome);
	}
	public String getCf() {
		return cf.get();
	}
	public void setCf(String cf) {
		this.cf = new SimpleStringProperty(cf);
	}
	
}
}
