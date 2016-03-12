package presentation.command;

import java.text.ParseException;
import java.util.ArrayList;

import business.GestisciContratto;

public class InserisciContratto implements Command{
GestisciContratto b = new GestisciContratto();

	@Override
	public Object execute(ArrayList<String> parameters) {
	try {
		return b.InserisciContratto(parameters);
	} catch (ParseException | InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
