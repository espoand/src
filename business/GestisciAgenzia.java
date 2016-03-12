package business;

import java.util.ArrayList;

import business.bo.AgenziaBusiness;
import entity.Agenzia;
import exceptions.GenericException;

public class GestisciAgenzia {

	AgenziaBusiness ab;
	
	public GestisciAgenzia(){
		
			ab=new AgenziaBusiness();
	
	}
	
	public Object inserisciAgenzia(ArrayList<String> param){
		if(ab==null)
			return false;
		
		int id=Integer.parseInt(param.get(0));
		String nome=param.get(1);
		String via=param.get(2);
		String citta = param.get(3);
		String cap = param.get(4);
		String telefono=param.get(5);
	
		Agenzia a=new Agenzia(id,nome,via,citta,cap,telefono);
		return ab.inserisciAgenzia(a);
	}
	
	public Object modificaAgenzia(ArrayList<String> param){
		if(ab==null)
			return false;
		
		int id=Integer.parseInt(param.get(0));
		String nome=param.get(1);
		String via=param.get(2);
		String citta = param.get(3);
		String cap = param.get(4);
		String telefono=param.get(5);
		Agenzia a=new Agenzia(id,nome,via,citta,cap,telefono);
		return ab.modificaAgenzia(a);
	}
	
	public Object eliminaAgenzia(String parameter){
		if(ab==null)
			return false;
		
		int id=Integer.parseInt(parameter);
		
		
		return ab.rimuoviAgenzia(id);
	}
	public Agenzia getAgenzia(String parameter){
		int id = Integer.parseInt(parameter);
		Agenzia agenzia= ab.getAgenzia(id);
		if(agenzia==null) throw new GenericException("La ricerca ha prodotto valore nullo");
		return agenzia;
		
	}
	public ArrayList<Agenzia> getAgenzie(){
		ArrayList<Agenzia> tutteAgenzie = ab.getAgenzie();
			if(tutteAgenzie!=null){
				return tutteAgenzie;
			} 
			else throw new GenericException("La ricerca ha prodotto valore nullo");
	}
}
