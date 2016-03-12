package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Auto;
import entity.Manutenzione;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Sessione;

public class GestioneManutenzioneController implements Initializable{
	FrontController fc = new FrontController();
	ViewDispatcher vd = new ViewDispatcher();
@FXML
TableView <Record > listaManutenzione;
@FXML
TableColumn targa;
@FXML
TableColumn tipo;
@FXML
TableColumn data;
@FXML
TableColumn costo;
@FXML
public void mostraAuto(){
	Record attuale = listaManutenzione.getSelectionModel().getSelectedItem();
	if(attuale== null){
		vd.showMessage("Selezionare un elemento");
	}
	else{
		String targa = attuale.getTarga().toString();
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(targa);
		Auto a = (Auto) fc.handleRequest("CercaAuto",parameters);
		if(a!=null){
		Sessione.setAuto(a);
		fc.handleRequest("MostraAuto");}
		else vd.showMessage("Si è verificato un errore");
	}
}

@FXML
public void indietro(){
	fc.handleRequest("Home");
}
@FXML
public void quit(){
	vd.quit();

}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	 ObservableList<Record> lista = FXCollections.observableArrayList();
	 ArrayList<Manutenzione> tutteManutenzioni = (ArrayList<Manutenzione>) fc.handleRequest("TutteManutenzioni");
	 Iterator<Manutenzione> it1 = tutteManutenzioni.iterator();
	 Manutenzione tmp = null;
	 while(it1.hasNext()){
		 tmp= it1.next();
		 lista.add(new Record(tmp.getAuto().getTarga(),tmp.getTipoManutenzione().toString(),tmp.getData().toString(),Double.toString(tmp.getCosto())));
		 
	 }
	 targa.setCellValueFactory(new PropertyValueFactory<Record,String>("targa"));
	 tipo.setCellValueFactory(new PropertyValueFactory<Record,String>("tipo"));
	 data.setCellValueFactory(new PropertyValueFactory<Record,String>("data"));
	 costo.setCellValueFactory(new PropertyValueFactory<Record,String>("costo"));
	 listaManutenzione.setItems(lista);
	 listaManutenzione.getColumns().addAll(targa,tipo,data,costo);

	 
	}
@FXML
public void aggiungi(){
	fc.handleRequest("AggiungiManutenzione");
	
}
public class Record{
    private  SimpleStringProperty targa;
    private  SimpleStringProperty tipo;
    private  SimpleStringProperty data;
    private  SimpleStringProperty costo;
    private Record(String targa,String tipo,String data,String costo){
    	this.targa= new SimpleStringProperty(targa);
    	this.tipo = new SimpleStringProperty(tipo);
    	this.data = new SimpleStringProperty(data);
    	this.costo =new  SimpleStringProperty(costo);
    	
    }
	public SimpleStringProperty getTarga() {
		return targa;
	}
	public SimpleStringProperty getTipo() {
		return tipo;
	}
	public SimpleStringProperty getData() {
		return data;
	}
	public SimpleStringProperty getCosto() {
		return costo;
	}
	public void setTarga(String t ){
		targa.set(t);


	}
	public void tipo(String t ){
		tipo.set(t);


	}public void setData(String t ){
		data.set(t);


	}public void setCosto(String t ){
		costo.set(t);


	}
}}
