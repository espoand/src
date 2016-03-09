package presentation.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Agenzia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import presentation.ViewDispatcher;
import utility.Sessione;

public class MostraAgenziaController implements Initializable{
ViewDispatcher vd = new ViewDispatcher();
@FXML
TextField id;
@FXML
TextField nome;
@FXML
TextField indirizzo;
@FXML
TextField telefono;
Agenzia agenzia;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		agenzia = Sessione.getAgenziaAttuale();
		id.setText(Integer.toString(agenzia.getIdentificativo()));
		nome.setText(agenzia.getNome());
		indirizzo.setText(agenzia.getIndirizzo());
		telefono.setText(agenzia.getTelefono());
	}
@FXML
public void quit(){
	vd.quit();
}
@FXML
public void indietro(){
	vd.indietro();
}

}
