package presentation.command;

import java.util.ArrayList;

import business.GestisciContratto;

public class ChiudiContratto implements Command{
GestisciContratto b = new GestisciContratto();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		try {
			return b.chiudiContratto(parameter);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
