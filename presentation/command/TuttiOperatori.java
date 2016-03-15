package presentation.command;

import java.util.ArrayList;

import business.GestisciOperatore;

public class TuttiOperatori implements Command{
GestisciOperatore b = new GestisciOperatore();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return b.getOperatori();
	}

}
