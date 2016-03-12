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
import utility.Manutenzione;

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
		Iterator<Fascia> it1 = tutteFasce.iterator();
		while(it1.hasNext()){
			fascia=(Fascia) it1.next();
			if(fascia.getIdFascia().equals(idFascia)) break;
			
		}
		if(fascia!=null){
		
		
		a=new Auto(targa,modello,fascia,true,ultimoKmtraggio);
		return car.inserisciAuto(a);
		}
		return null;
		
	}
	
	public Object modificaAuto(ArrayList<String> param){
		
		if(car==null)
			return false;
		Auto a;
		String targa=param.get(0);
		double ultimoKm=Double.parseDouble(param.get(1));
		
		a=car.getAuto(targa);
		if(!a.isDisponibile()) return false;
		
		return car.modificaAuto(a,ultimoKm);
		
		
	}
	
	public Object rimuoviAuto(String param){
		if(car==null)
			return false;
	
			
			Auto a = car.getAuto(param);
			if(a.isDisponibile()){
				return car.rimuoviAuto(param);
			}
			else return false;
			
				}
				
	
	
	public boolean aggiungiManutenzione(ArrayList<String> param){
		Auto auto = car.getAuto(param.get(0));
		if(!auto.isDisponibile()) return false;
		LocalDate data = LocalDate.parse(param.get(1));
		double costo = Double.parseDouble(param.get(2));
		Manutenzione tipo;
		if(param.get(0) == Manutenzione.ORDINARIA.toString()){
			tipo=Manutenzione.ORDINARIA;
		}
		else tipo=Manutenzione.STRAORDINARIA;
		return car.aggiungiManutenzione(auto, data, costo, tipo);
		
		
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