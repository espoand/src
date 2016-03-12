package presentation.command;

import java.util.ArrayList;

import business.GestisciAuto;

public class ModificaAuto implements Command{
GestisciAuto b = new GestisciAuto();
@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return b.modificaAuto(parameters);
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
