package presentation.command;

import java.util.ArrayList;

import business.BusinessDelegate;

public class TutteAuto implements Command{
BusinessDelegate b = new BusinessDelegate();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return b.handleRequest("TutteAuto");
	}

}
