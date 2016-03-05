package exceptions;

import utility.Sessione;

public class DatabaseConnectionException extends Exception {
public DatabaseConnectionException(Exception e){
	e.printStackTrace();
	Sessione.azzera();
	
}
}
