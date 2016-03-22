package business;

import java.util.ArrayList;
import java.util.Iterator;

import business.bo.FasciaBusiness;
import business.bo.TariffaBaseBusiness;
import entity.Fascia;
import entity.TariffaBase;
public class GestisciFascia {

	FasciaBusiness fb;
	
	public GestisciFascia(){
		
			fb=new FasciaBusiness();
		
	}
	
	public boolean inserisciFascia (ArrayList<String> param){
		if(fb==null)
			return false;
		TariffaBaseBusiness tb=new TariffaBaseBusiness();
		
		String id=param.get(0);
		String descrizione=param.get(1);
		String tariffa=param.get(2);
		TariffaBase tar=tb.getTariffaBase(tariffa);
		
		Fascia f=new Fascia(id,descrizione,tar);
		return fb.inserisciFascia(f);
	}
	
	public boolean modificaFascia (ArrayList<String> param){
		if(fb==null)
			return false;
		TariffaBaseBusiness tb=new TariffaBaseBusiness();
			
		
		String id=param.get(0);
		String descrizione=param.get(1);
		String tariffa=param.get(2);
		TariffaBase tar=tb.getTariffaBase(tariffa);
		
		Fascia f=new Fascia(id,descrizione,tar);
		return fb.modificaFascia(f);
	}
	
	public boolean eliminaFascia (String param){
		if(fb==null)
			return false;
		
		return fb.rimuoviFascia(param);
	}
	
	
	public ArrayList<Fascia> getFasce(){
		return fb.getFasce();
	}
public Fascia getFascia(String param){
	return fb.getFascia(param);
}	
}