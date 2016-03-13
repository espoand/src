package presentation;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utility.Sessione;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



	public class Main extends Application{

		public static void main(String[] args){
			
			launch(args);
			
		}
		public void start(Stage stage) throws IOException{
			
			

			Parent root = FXMLLoader.load(getClass().getResource("/presentation/ui/Login.fxml"));
			
			Scene sc = new Scene(root,650,500);
			Sessione.setSc(sc);
			
			sc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        
	        stage.setTitle("CarLoan");
	        stage.setScene(sc);
	        stage.setResizable(false);
	        stage.show();
			
			
			
		}
}
