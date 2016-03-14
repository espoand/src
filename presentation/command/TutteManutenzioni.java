package presentation.command;

import java.util.ArrayList;

import business.GestisciManutenzione;

public class TutteManutenzioni implements Command{
GestisciManutenzione b = new GestisciManutenzione();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return b.getManutenzioni();
	}

}
