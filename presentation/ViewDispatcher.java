package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import utility.Sessione;

public class ViewDispatcher {
Alert alert;
public ViewDispatcher(){}
public void apriView(String view){
	try {
		Parent root = FXMLLoader.load(getClass().getResource("/presentation/ui/" + view +".fxml"));
		Sessione.cambiaView(view);
		Sessione.getSc().setRoot(root);
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void indietro(){
	apriView(Sessione.getPrecedente());
	Sessione.cambiaView(Sessione.getPrecedente());
}

public void showMessage(String message){
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Messaggio");
alert.setContentText(message);
alert.showAndWait();
}
public static void main(String[] args){
	 
	ViewDispatcher vd = new ViewDispatcher();
	vd.showMessage("Password errata");
	vd.areYouSure("Sei sicuro");
	
}	
public int areYouSure(String message){
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Conferma");
	Optional<ButtonType> result = alert.showAndWait();
	if(result.get() == ButtonType.OK){
		return 0;
	}
	else return 1;
}
public void quit(){
	Sessione.azzera();
	System.exit(0);
}

}
