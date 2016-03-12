package presentation.command;

import java.util.ArrayList;

import business.GestisciAgenzia;

public class InserisciAgenzia implements Command{
GestisciAgenzia b = new GestisciAgenzia();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return b.inserisciAgenzia(parameters);
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
