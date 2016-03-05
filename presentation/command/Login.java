package presentation.command;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import business.BusinessDelegate;

public class Login implements Command{
BusinessDelegate b;
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		boolean eseguito = false;
		try {
			eseguito = (boolean) b.handleRequest("Login", parameters);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eseguito;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
