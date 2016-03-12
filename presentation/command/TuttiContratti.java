package presentation.command;

import java.util.ArrayList;

import business.GestisciContratto;

public class TuttiContratti implements Command{
GestisciContratto b = new GestisciContratto();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return b.getContratti();
	}

}
