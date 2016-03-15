package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Auto;
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
import presentation.ui.controller.GestioneOperatoreController.Record;
import utility.InputController;
import utility.Sessione;

public class GestioneAutoController implements Initializable{
FrontController fc = new FrontController();
ViewDispatcher vd = new ViewDispatcher();
InputController ic = new InputController();
@FXML
TextField targa;
@FXML
TableView<Record> tabella;
@FXML
public void manutenzione(){
	fc.handleRequest("GestioneManutenzione");
}
@FXML 
public void cerca(){
	if(targa.getText().isEmpty()){
		vd.showMessage("Campo targa vuoto");
	}
	if(!ic.onlyNumbersAndLetters(targa.getText())){
	vd.showMessage("Targa non valida");
	}
	
	else{
		ArrayList<String> targaList = new ArrayList<String>();
		targaList.add(targa.getText());
		Auto a = (Auto) fc.handleRequest("CercaAuto",targaList);
		Sessione.setAuto(a);
		fc.handleRequest("MostraAuto");
		
	}
}
@FXML
public void aggiungi(){
	vd.apriView("AggiungiAuto");
}
@FXML
public void modifica(){
	if(targa.getText().isEmpty()){
		vd.showMessage("Campo targa vuoto");
	}
	if(!ic.onlyNumbersAndLetters(targa.getText())){
	vd.showMessage("Targa non valida");
	}
	
	else{
		ArrayList<String> targaList = new ArrayList<String>();
		targaList.add(targa.getText());
		Auto a = (Auto) fc.handleRequest("CercaAuto",targaList);
		Sessione.setAuto(a);
		fc.handleRequest("ModificaAuto");
		
	}
	
}
@FXML
public void elimina(){
	ArrayList<String> targalist = new ArrayList<String>();
	targalist.add(targa.getText());
	boolean eseguito = false;
	if(vd.areYouSure("Sei sicuro di voler eliminare l'auto?") == 0){
	eseguito = (boolean) fc.handleRequest("RimuoviAuto",targalist);
	}
	if(eseguito){
		vd.showMessage("Cancellazione eseguita");
	}
	else vd.showMessage("Si è verificato un errore durante la cancellazione");
	}

@FXML
public void quit(){
	vd.quit();
}
@FXML
public void home(){
	vd.home();
}
@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	TableColumn<Record,String> targaTable = new TableColumn("Targa");
	TableColumn<Record,String> modelloTable = new TableColumn("Modello");
	TableColumn<Record,String> dispTable = new TableColumn("Disponibilità");
	targaTable.prefWidthProperty().bind(tabella.widthProperty().divide(3));
	modelloTable.prefWidthProperty().bind(tabella.widthProperty().divide(3));
	dispTable.prefWidthProperty().bind(tabella.widthProperty().divide(3));
	 ObservableList<Record> lista = FXCollections.observableArrayList();
	 ArrayList<Auto> tutteAuto = (ArrayList<Auto>) fc.handleRequest("TutteAuto");
	 Iterator<Auto> it1 = tutteAuto.iterator();
	 Auto tmp = null;
	 while(it1.hasNext())
	 {
		 tmp = it1.next();
		 lista.add(new Record(tmp.getTarga(),tmp.getModello(),tmp.isDisponibile()));
	 }
	 targaTable.setCellValueFactory(new PropertyValueFactory<Record,String>("targa"));
	 modelloTable.setCellValueFactory(new PropertyValueFactory<Record,String>("modello"));
	 dispTable.setCellValueFactory(new PropertyValueFactory<Record,String>("disponibile"));
	 
	 tabella.setItems(lista);
	 tabella.getColumns().setAll(targaTable,modelloTable,dispTable);
	 
	 
}
public class Record{
	private SimpleStringProperty targa;
	private SimpleStringProperty modello;
	private SimpleStringProperty disponibile;
	public Record(String n,String c,boolean disp){
		targa = new SimpleStringProperty(n);
		modello = new SimpleStringProperty(c);
		String a;
		if(disp) a = "Disponibile";
		else a = "Non Disponibile";
		disponibile = new SimpleStringProperty(a);
		
	}
	public String getTarga() {
		return targa.get();
	}
	public void setTarga(String targa) {
		this.targa = new SimpleStringProperty(targa);
	}
	public String getModello() {
		return modello.get();
	}
	public void setModello(String modello) {
		this.modello = new SimpleStringProperty(modello);
	}
	public String getDisponibile() {
		return disponibile.get();
	}
	public void setDisponibile(String disp) {
		this.disponibile = new SimpleStringProperty(disp);
	}
}}
