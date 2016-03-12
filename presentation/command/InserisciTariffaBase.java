package presentation.command;

import java.util.ArrayList;

import business.GestisciTariffaBase;

public class InserisciTariffaBase implements Command{
GestisciTariffaBase b = new GestisciTariffaBase();
@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return b.inserisciTariffaBase(parameters);
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
