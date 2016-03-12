package presentation.command;

import java.util.ArrayList;

import business.GestisciCliente;

public class InserisciCliente implements Command{
GestisciCliente b = new GestisciCliente();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return b.inserisciCliente(parameters);
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
