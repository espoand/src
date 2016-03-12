package presentation.command;

import java.util.ArrayList;

import business.GestisciFascia;

public class ModificaFascia implements Command{
	GestisciFascia b = new GestisciFascia();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return b.modificaFascia(parameters);
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
