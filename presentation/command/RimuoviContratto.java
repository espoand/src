package presentation.command;

import java.text.ParseException;
import java.util.ArrayList;

import business.GestisciContratto;

public class RimuoviContratto implements Command{
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
			return b.eliminaContratto(parameter);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
