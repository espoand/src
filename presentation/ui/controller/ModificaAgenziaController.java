package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.Agenzia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class ModificaAgenziaController implements Initializable{
	ViewDispatcher vd = new ViewDispatcher();
	FrontController fc = new FrontController();
	InputController ic = new InputController();
	Agenzia agenzia = null;
	@FXML
	TextField nome;
	@FXML
	TextField via;
	@FXML
	TextField citta;
	@FXML
	TextField cap;
	@FXML
	TextField telefono;
	
	@FXML
	public void quit(){
		vd.quit();
	}
	@FXML
	public void indietro(){
		vd.indietro();
	}
	@FXML
	public void submit(){
		
		if(nome.getText().isEmpty() || via.getText().isEmpty() || citta.getText().isEmpty() || cap.getText().isEmpty() || telefono.getText().isEmpty()){
			vd.showMessage("Compilare tutti i campi");
		}
		if(!ic.telephoneNumber(telefono.getText()) || !ic.onlyNumbers(cap.getText()) || cap.getText().length()!=5){
			vd.showMessage("Numero di telefono e/o CAP Errato/i");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(Integer.toString(agenzia.getIdentificativo()));
			parameters.add(nome.getText());
			parameters.add(via.getText());
			parameters.add(citta.getText());
			parameters.add(cap.getText());
			parameters.add(telefono.getText());
			boolean eseguito = (boolean) fc.handleRequest("ModificaAgenzia",parameters);
			if(eseguito){
				vd.showMessage("Completato");
			}
			else vd.showMessage("Si è verificato un errore");
			
			
		}}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		agenzia = Sessione.getAgenziaAttuale();
		nome.setText(agenzia.getNome());
		via.setText(agenzia.getVia());
		citta.setText(agenzia.getCitta());
		cap.setText(agenzia.getCap());
		telefono.setText(agenzia.getTelefono());
	}
}
