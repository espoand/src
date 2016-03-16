package exceptions;

import presentation.FrontController;
import presentation.ViewDispatcher;

public class GenericException extends RuntimeException {
public GenericException(){
	
}
public GenericException(String message){
	/*ViewDispatcher vd = new ViewDispatcher();
	FrontController fc = new FrontController();
	vd.showMessage(message);
	fc.handleRequest("Home");*/
}
}
