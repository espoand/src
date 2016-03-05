package exceptions;

import utility.Sessione;

public class WrongPasswordException extends RuntimeException{
public WrongPasswordException(){super("Password errata");Sessione.azzera();}
	public WrongPasswordException(String message){
		super(message);
	}
	
}
