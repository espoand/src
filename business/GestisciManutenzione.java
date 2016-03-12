package business;

import java.util.ArrayList;

import business.bo.AgenziaBusiness;
import business.bo.ManutenzioneBusiness;
import entity.Manutenzione;

public class GestisciManutenzione {
ManutenzioneBusiness mb;
	
	public GestisciManutenzione(){
		
			mb=new ManutenzioneBusiness();
	
	}
	public void inserisciManutenzione(ArrayList<String> parameters){}
	public boolean eliminaManutenzione(String param){
		return mb.eliminaManutenzione(Integer.parseInt(param));
		
	}
	public Manutenzione getManutenzione(String param){
		return mb.getManutenzione(Integer.parseInt(param));
	}
	public ArrayList<Manutenzione> getManutenzioni(){
		return mb.getManutenzioni();
	}
}
