package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import entity.Agenzia;
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
import utility.InputController;
import utility.Sessione;

public class GestioneAgenziaController implements Initializable{
	ViewDispatcher vd = new ViewDispatcher();
	FrontController fc = new FrontController();
	InputController ic = new InputController();

@FXML
TableView<Record> listaAgenzie;
//@FXML
//TableColumn<Record,String> idTable;
//@FXML
//TableColumn<Record,String> nomeTable;
@FXML
public void cerca(){
	if(listaAgenzie.getSelectionModel().getSelectedItem() == null){
		vd.showMessage("Selezionare un elemento");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(listaAgenzie.getSelectionModel().getSelectedItem().getIdAgenzia());
		Agenzia ag = (Agenzia) fc.handleRequest("CercaAgenzia",parameters);
		Sessione.setAgenziaAttuale(ag);
		fc.handleRequest("MostraAgenzia");
	}
}
@FXML
public void quit(){vd.quit();}
@FXML
public void aggiungi(){fc.handleRequest("AggiungiAgenzia");}
@FXML
public void elimina(){
	if(listaAgenzie.getSelectionModel().getSelectedItem() == null){
		vd.showMessage("Selezionare un elemento");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(listaAgenzie.getSelectionModel().getSelectedItem().getIdAgenzia());
		if(vd.areYouSure("Sei sicuro di voler procedere?") == 0){
			boolean eseguito = (boolean) fc.handleRequest("RimuoviAgenzia",parameters);
			if(eseguito){
				vd.showMessage("Completato");
				vd.ricarica();
		}
			else vd.showMessage("Si è verificato un errore");
	}}
}
@FXML
public void modifica(){
	if(listaAgenzie.getSelectionModel().getSelectedItem() == null){
		vd.showMessage("Selezionare un elemento");
	}
	else{
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add(listaAgenzie.getSelectionModel().getSelectedItem().getIdAgenzia());
		Agenzia ag = (Agenzia) fc.handleRequest("CercaAgenzia",parameters);
		if(ag!=null){
			Sessione.setAgenziaAttuale(ag);
			fc.handleRequest("ModificaAgenzia");
		}
		else{
			vd.showMessage("Agenzia non trovata");
		}
	}
}
@FXML
public void home(){vd.home();}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// TODO Auto-generated method stub
		TableColumn<Record,String> idTable = new TableColumn<>("ID Agenzia");
		TableColumn<Record,String> nomeTable = new TableColumn<>("Nome Agenzia");
		idTable.setEditable(false);
		nomeTable.setEditable(false);
		idTable.prefWidthProperty().bind(listaAgenzie.widthProperty().divide(2));
		nomeTable.prefWidthProperty().bind(listaAgenzie.widthProperty().divide(2));

		ArrayList<Agenzia> tutteAgenzie = (ArrayList<Agenzia>) fc.handleRequest("TutteAgenzie");
		Iterator<Agenzia> it1 = tutteAgenzie.iterator();
		ObservableList<Record> lista =  FXCollections.observableArrayList();
		Agenzia tmp = null;
		while(it1.hasNext()){
			tmp= it1.next();
			lista.add(new Record(Integer.toString(tmp.getIdentificativo()),tmp.getNome()));
		
		}
		 idTable.setCellValueFactory(new PropertyValueFactory<Record,String>("idAgenzia"));
		 nomeTable.setCellValueFactory(new PropertyValueFactory<Record,String>("nomeAgenzia"));
		 listaAgenzie.setItems(lista);
		 listaAgenzie.getColumns().addAll(idTable,nomeTable);


		
		
		
	}
	public class Record{
		private SimpleStringProperty idAgenzia;
		private SimpleStringProperty nomeAgenzia;
		public Record(String id,String nome){
			this.idAgenzia = new SimpleStringProperty(id);
			this.nomeAgenzia = new SimpleStringProperty(nome);
			
		}
		public String getIdAgenzia() {
			return idAgenzia.get();
		}
		public void setIdAgenzia(String idAgenzia) {
			this.idAgenzia.set(idAgenzia); 
		}
		public String getNomeAgenzia() {
			return nomeAgenzia.get();
		}
		public void setNomeAgenzia(String nomeAgenzia) {
			this.nomeAgenzia.set(nomeAgenzia);
		}
		
		
	}

}
