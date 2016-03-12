package presentation.command;

import java.util.ArrayList;

import business.GestisciFascia;

public class TutteFasce implements Command{
GestisciFascia b = new GestisciFascia();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		
		return b.getFasce();
	}

}
