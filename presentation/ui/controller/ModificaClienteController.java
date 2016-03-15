package presentation.ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.InputController;
import utility.Sessione;

public class ModificaClienteController implements Initializable{
	FrontController fc = new FrontController();
	InputController ic = new InputController();
	ViewDispatcher vd = new ViewDispatcher();
	@FXML
	TextField cf;
	@FXML
	TextField nome;
	@FXML
	TextField cognome;
	@FXML
	TextField telefono;
	@FXML
	TextField via;
	@FXML
	TextField citta;
	@FXML
	TextField cap;
	Cliente cliente = null;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cliente = Sessione.getClienteAttuale();
		cf.setText(cliente.getCodiceFiscale());
		nome.setText(cliente.getNome());
		cognome.setText(cliente.getCognome());
		telefono.setText(cliente.getTelefono());
		via.setText(cliente.getVia());
		citta.setText(cliente.getCitta());
		cap.setText(cliente.getCap());
		
	}
	@FXML
	public void quit(){
		vd.quit();
	}
	@FXML
	public void indietro(){vd.home();}
	@FXML
	public void submit(){
		if(cf.getText().isEmpty() || cognome.getText().isEmpty() || nome.getText().isEmpty() || telefono.getText().isEmpty() || via.getText().isEmpty()){
			vd.showMessage("Compilare tutti i campi");
			
		}
		if(!ic.onlyNumbersAndLetters(cf.getText())){
			vd.showMessage("Vi sono caratteri non ammessi nel campo Codice Fiscale!");
			
		}
		if(!ic.telephoneNumber(telefono.getText())){
			vd.showMessage("Numero di telefono non valido");
		}
		else{
			ArrayList<String> parameters = new ArrayList<String>();
			parameters.add(cf.getText());
			parameters.add(nome.getText());
			parameters.add(cognome.getText());
			parameters.add(telefono.getText());
			parameters.add(via.getText());
			parameters.add(citta.getText());
			parameters.add(cap.getText());
			boolean eseguito = (boolean) fc.handleRequest("ModificaCliente", parameters);
			if(eseguito){
				vd.showMessage("Operazione avvenuta con successo");
				vd.home();
			}
			else{
				vd.showMessage("Si è verificato un errore");
			}
		}
	}

}
