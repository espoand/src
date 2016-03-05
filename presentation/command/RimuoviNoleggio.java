package presentation.command;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import business.BusinessDelegate;

public class RimuoviNoleggio implements Command{
	BusinessDelegate b;
@Override
public Object execute(ArrayList<String> parameters) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Object execute(String parameter) {
	// TODO Auto-generated method stub
	boolean eseguito = false;
	try {
		eseguito = (boolean) b.handleRequest("RimuoviNoleggio", parameter);
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return eseguito;
}

}
