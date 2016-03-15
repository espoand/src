package presentation.ui.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.ApplicationController;
import presentation.FrontController;
import presentation.ViewDispatcher;
import presentation.ui.controller.GestioneContrattoController.Record;
import utility.InputController;
import utility.Sessione;

public class GestioneClienteController implements Initializable{
ViewDispatcher vd = new ViewDispatcher();
FrontController fc = new FrontController();
InputController ic = new InputController();
@FXML
TextField cf;
@FXML
TableView<Record> tabella;

@FXML 
public void cerca(){
	Cliente cliente = null;
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
		
	}
	if(!ic.onlyNumbersAndLetters(cf.getText())){
		vd.showMessage("Il campo codice fiscale deve essere composto di soli numeri e lettere");
		
}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cf.getText());
		cliente = (Cliente) fc.handleRequest("CercaCliente",parameters);
		Sessione.setClienteAttuale(cliente);
		fc.handleRequest("MostraCliente");
		}
	}
@FXML 
public void aggiungi(){
	fc.handleRequest("AggiungiCliente");
}
@FXML
public void modifica(){
	Cliente cliente = null;
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
		
	}
	if(!ic.onlyNumbersAndLetters(cf.getText())){
		vd.showMessage("Il campo codice fiscale deve essere composto di soli numeri e lettere");
		}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(cf.getText());
		cliente = (Cliente) fc.handleRequest("CercaCliente",parameters);
		Sessione.setClienteAttuale(cliente);
		fc.handleRequest("ModificaCliente");
		}
}
@FXML
public void elimina(){
	if(cf.getText().isEmpty()){
		vd.showMessage("Compilare il campo codice fiscale");
		
	}
	if(!ic.onlyNumbersAndLetters(cf.getText())){
		vd.showMessage("Il campo codice fiscale deve essere composto di soli numeri e lettere");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		fc.handleRequest("RimuoviCliente", parameters);
	}
}
@FXML
public void indietro(){
	
	vd.home();
}
public void quit(){
	vd.quit();
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
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	ArrayList<Cliente> tuttiClienti = (ArrayList<Cliente>) fc.handleRequest("TuttiClienti");
	ObservableList<Record> lista =  FXCollections.observableArrayList();
	Iterator<Cliente> it1 = tuttiClienti.iterator();
	Cliente tmp = null;
	while(it1.hasNext()){
		tmp = it1.next();
		lista.add(new Record(tmp.getNome(),tmp.getCognome(),tmp.getCodiceFiscale()));
	}
	TableColumn<Record,String> nomeTable = new TableColumn("Nome");
	TableColumn<Record,String> cognomeTable = new TableColumn("Cognome");
	TableColumn<Record,String> cfTable = new TableColumn("Codice Fiscale");
	nomeTable.prefWidthProperty().bind(tabella.widthProperty().divide(3));
	cognomeTable.prefWidthProperty().bind(tabella.widthProperty().divide(3));
	cfTable.prefWidthProperty().bind(tabella.widthProperty().divide(3));



	nomeTable.setCellValueFactory(new PropertyValueFactory<Record,String>("nome"));
	 cognomeTable.setCellValueFactory(new PropertyValueFactory<Record,String>("cognome"));
	 cfTable.setCellValueFactory(new PropertyValueFactory<Record,String>("cf"));
	 
	 tabella.setItems(lista);
	 tabella.getColumns().setAll(nomeTable,cognomeTable,cfTable);
	 



	
}
}
