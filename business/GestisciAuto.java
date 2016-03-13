package business;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import business.bo.AutoBusiness;
import business.bo.FasciaBusiness;
import entity.Auto;
import entity.Fascia;
import exceptions.DatabaseConnectionException;
import exceptions.GenericException;

public class GestisciAuto {
 
	private AutoBusiness car;
	
	
	public GestisciAuto() {
		try {
			car=new AutoBusiness();
		} catch (InstantiationException e) {
			car=null;
		}
		
	}

	public boolean inserisciAuto(ArrayList<String> param) {
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
		Iterator<Fascia> it1 = tutteFasce.iterator();
		while(it1.hasNext()){
			fascia=(Fascia) it1.next();
			if(fascia.getIdFascia().equals(idFascia)) break;
			
		}
		if(fascia!=null){
		
		
		a=new Auto(targa,modello,fascia,true,ultimoKmtraggio);
		return car.inserisciAuto(a);
		}
		return false;
		
	}
	
	public boolean modificaAuto(ArrayList<String> param){
		
		if(car==null)
			return false;
		Auto a;
		String targa=param.get(0);
		double ultimoKm=Double.parseDouble(param.get(1));
		
		a=car.getAuto(targa);
		if(!a.isDisponibile()) return false;
		
		return car.modificaAuto(a,ultimoKm);
		
		
	}
	
	public boolean rimuoviAuto(String param){
		if(car==null)
			return false;
	
			
			Auto a = car.getAuto(param);
			if(a.isDisponibile()){
				return car.rimuoviAuto(param);
			}
			else return false;
			
				}
				
	
	
	public Auto getAuto(String targa){
		Auto a = car.getAuto(targa);;
		if(a==null) throw new GenericException("Valore nullo");
		
		return a;
	}
	public ArrayList<Auto> tutteAuto(){
		ArrayList<Auto> tutteAuto=  car.getTutteAuto();
		if(tutteAuto== null) throw new GenericException("Valore nullo");
		return tutteAuto;
	}
	public ArrayList<Auto> getAutoDisponibili(){
		ArrayList<Auto> disponibili = car.getAutoDisponibili();
		if(disponibili == null) throw new GenericException("Valore nullo");
		return disponibili;
		
	}
	public boolean setStato(ArrayList<String> parameters){
		boolean disponibile = Boolean.parseBoolean(parameters.get(1));
		String targa = parameters.get(0);
		return car.setStato(targa, disponibile);
		
		
	}
	}