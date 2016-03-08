package presentation.command;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import business.BusinessDelegate;

public class CercaOperatore implements Command{
BusinessDelegate b = new BusinessDelegate();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		try {
			return b.handleRequest("CercaNoleggio", parameter);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
