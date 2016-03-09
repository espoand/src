package business;

import java.util.ArrayList;

import business.bo.TariffaBaseBusiness;
import entity.TariffaBase;

public class GestisciTariffaBase {

	TariffaBaseBusiness tar;
	
	public GestisciTariffaBase(){
	
			tar=new TariffaBaseBusiness();
		
	}
	
	public Object inserisciTariffaBase(ArrayList<String> param){
		
		if(tar==null)
			return false;
		
		String nome=param.get(0);
		double costoAlKm=Double.parseDouble(param.get(1));
		double costoAlKmExtra=Double.parseDouble(param.get(2));
		double costoAlGiornoExtra=Double.parseDouble(param.get(3));
		
		TariffaBase tarBas=new TariffaBase(nome,costoAlKm,costoAlKmExtra,costoAlGiornoExtra);
		return tar.inserisciTariffaBase(tarBas);
	}
	
public Object modificaTariffaBase(ArrayList<String> param){
		
		if(tar==null)
			return false;
		
		String nome=param.get(0);
		double costoAlKm=Double.parseDouble(param.get(1));
		double costoAlKmExtra=Double.parseDouble(param.get(2));
		double costoAlGiornoExtra=Double.parseDouble(param.get(3));
		
		TariffaBase tarBas=new TariffaBase(nome,costoAlKm,costoAlKmExtra,costoAlGiornoExtra);
		return tar.modificaTariffaBase(tarBas);
	}

public Object eliminaTariffaBase(ArrayList<String> param){
	
	if(tar==null)
		return false;
	
	String nome=param.get(0);
	double costoAlKm=Double.parseDouble(param.get(1));
	double costoAlKmExtra=Double.parseDouble(param.get(2));
	double costoAlGiornoExtra=Double.parseDouble(param.get(3));
	
	TariffaBase tarBas=new TariffaBase(nome,costoAlKm,costoAlKmExtra,costoAlGiornoExtra);
	return tar.eliminaTariffaBase(tarBas);
}
}
