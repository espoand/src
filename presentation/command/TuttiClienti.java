package presentation.command;

import java.util.ArrayList;

import business.GestisciCliente;

public class TuttiClienti implements Command{
GestisciCliente b = new GestisciCliente();
@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return b.tuttiClienti();
	}

}
