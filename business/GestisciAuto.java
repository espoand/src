package business;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import business.bo.AutoBusiness;
import business.bo.FasciaBusiness;
import business.bo.NoleggioBusiness;
import entity.Auto;
import entity.Fascia;
import entity.Noleggio;
import exceptions.DatabaseConnectionException;

public class GestisciAuto {
 
	private AutoBusiness car;
	
	
	public GestisciAuto() {
		try {
			car=new AutoBusiness();
		} catch (InstantiationException e) {
			car=null;
		}
		
	}
	
	public Object inserisciAuto(ArrayList<String> param) {
		FasciaBusiness fb = new FasciaBusiness();
		if(car==null)
			return false;
		
		Auto a;
		String targa=param.get(0);
		String modello=param.get(1);
		String idFascia=param.get(2);
		Fascia fascia =null;
		double ultimoKmtraggio=Double.parseDouble(param.get(3));
		ArrayList<Fascia> tutteFasce = fb.getFasce();
		Iterator it1 = tutteFasce.iterator();
		while(it1.hasNext()){
			fascia=(Fascia) it1.next();
			if(fascia.getIdFascia().equals(idFascia)) break;
			else return null;
				
		}
	
		
		
		a=new Auto(targa,modello,fascia,ultimoKmtraggio);
		return car.inserisciAuto(a);
		
	}
	
	public Object modificaAuto(ArrayList<String> param){
		
		if(car==null)
			return false;
		Auto a;
		String targa=param.get(0);
		double ultimoKm=Double.parseDouble(param.get(1));
		
		a=car.getAuto(targa);
		
		return car.modificaAuto(a,ultimoKm);
		
		
	}
	
	public Object rimuoviAuto(String param){
		if(car==null)
			return false;
		
	
			NoleggioBusiness noleggioBusiness= new NoleggioBusiness();
			ArrayList<Noleggio> noleggi= new ArrayList<Noleggio>();
			noleggi=noleggioBusiness.getNoleggi();
			Iterator<Noleggio> it=noleggi.iterator();
			Auto a = car.getAuto(param);
			while(it.hasNext()) {
				Noleggio current=it.next();
				if(current.getAutoNoleggiata().equals(a))
					return false;
					}
					return car.rimuoviAuto(a);
				}
				
	
	
	public Object aggiungiManutenzione(ArrayList<String> param){
		
		
}}