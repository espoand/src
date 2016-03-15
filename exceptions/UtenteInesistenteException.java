package exceptions;

import presentation.FrontController;
import presentation.ViewDispatcher;

public class UtenteInesistenteException extends RuntimeException {
	ViewDispatcher vd = new ViewDispatcher();
	FrontController fc = new FrontController();
public UtenteInesistenteException(){
	vd.showMessage("Utente inesistente");
	fc.handleRequest("Login");
}
}
