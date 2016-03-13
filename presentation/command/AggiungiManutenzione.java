package presentation.command;

import java.util.ArrayList;

import business.GestisciManutenzione;

public class AggiungiManutenzione implements Command{
GestisciManutenzione b = new GestisciManutenzione();
	@Override
	public Object execute(ArrayList<String> parameters){
		// TODO Auto-generated method stub
		return b.inserisciManutenzione(parameters);
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
