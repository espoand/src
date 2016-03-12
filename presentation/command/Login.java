package presentation.command;

import java.util.ArrayList;

import business.GestisciLogin;

public class Login implements Command{
GestisciLogin b = new GestisciLogin();
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return b.login(parameters);
	}

	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
