package presentation.command;

import java.util.ArrayList;

import business.GestisciAgenzia;

public class ModificaAgenzia implements Command{
GestisciAgenzia b = new GestisciAgenzia();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return b.modificaAgenzia(parameters);
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
