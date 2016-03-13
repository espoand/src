package business;

import java.time.LocalDate;
import java.util.ArrayList;

import business.bo.AgenziaBusiness;
import business.bo.AutoBusiness;
import business.bo.ManutenzioneBusiness;
import entity.Auto;
import entity.Manutenzione;
import exceptions.GenericException;
import utility.TipoManutenzione;
public class GestisciManutenzione {
ManutenzioneBusiness mb;
	
	public GestisciManutenzione(){
		
			mb=new ManutenzioneBusiness();
	
	}
	public boolean inserisciManutenzione(ArrayList<String> parameters){
		AutoBusiness ab = null;
		try {
			ab = new AutoBusiness();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new GenericException("Errore nella ricerca dell'auto");
		}
		String targa = parameters.get(0);
		Auto auto = ab.getAuto(targa);
		LocalDate data = LocalDate.parse(parameters.get(1));
		TipoManutenzione tipo;
		if(parameters.get(2) == TipoManutenzione.ORDINARIA.toString()){
			tipo = TipoManutenzione.ORDINARIA;
			
		}
		else tipo = TipoManutenzione.STRAORDINARIA;
		double costo = Double.parseDouble(parameters.get(3));
		Manutenzione manutenzione = new Manutenzione(0,auto,data,tipo,costo);
		return mb.inserisciManutenzione(manutenzione);
		
	}
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
