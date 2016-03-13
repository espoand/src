package exceptions;

import presentation.FrontController;
import presentation.ViewDispatcher;
import utility.Sessione;

public class WrongPasswordException extends RuntimeException{
public WrongPasswordException(){}
	public WrongPasswordException(String message){
		ViewDispatcher vd = new ViewDispatcher();
		FrontController fc = new FrontController();
		vd.showMessage("Password errata");
		fc.handleRequest("Login");
	}
	
}
