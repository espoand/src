package presentation.command;

import java.util.ArrayList;

import business.BusinessDelegate;
import entity.Fascia;

public class TutteFasce implements Command{
BusinessDelegate b = new BusinessDelegate();
ArrayList<Fascia> fasce = null;
	@Override
	public Object execute(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object execute(String parameter) {
		// TODO Auto-generated method stub
		
		fasce= (ArrayList<Fascia>) b.handleRequest("TutteFasce");
		return fasce;
	}

}
