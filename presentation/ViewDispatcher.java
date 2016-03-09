package presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import utility.Sessione;

public class ViewDispatcher {
public void apriView(String view){
	try {
		Parent root = FXMLLoader.load(getClass().getResource("ui/" +view));
		Sessione.cambiaView(view);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public void apriViewSenzaSalvare(String view){
	try{
		Parent root = FXMLLoader.load(getClass().getResource("ui/" +view));
	
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
	JOptionPane.showMessageDialog(null, message);

}
public static void main(String[] args){
	ViewDispatcher vd = new ViewDispatcher();
	vd.showMessage("Password errata");
}	
public int areYouSure(String message){
	return JOptionPane.showConfirmDialog(null, message);
}
public void quit(){
	Sessione.azzera();
	System.exit(0);
}
}
