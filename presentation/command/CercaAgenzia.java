package presentation.command;

import java.util.ArrayList;


import business.GestisciAgenzia;

public class CercaAgenzia implements Command{
GestisciAgenzia b = new GestisciAgenzia();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		
			return b.getAgenzia(parameter);
		
			// TODO Auto-generated catch block
		
	}

}
