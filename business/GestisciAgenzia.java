package business;

import java.util.ArrayList;

import business.bo.AgenziaBusiness;
import entity.Agenzia;
import exceptions.GenericException;

public class GestisciAgenzia {

	AgenziaBusiness ab;
	/**
	 * Inizializzo il Business Object relativo alle agenzie
	 * 
	 * 
	 */
	public GestisciAgenzia(){
		
			ab=new AgenziaBusiness();
	
	}
	/**
	 * Inserisce un'agenzia nel database attraverso il Business Object
	 * L'inserimento avviene invocando il business object relativo all'agenzia,vengono estratti tutti i parametri dall'arraylist
	 * che viene dato in input e viene creato un'oggetto Agenzia.
	 * 
	 * @param param i parametri che vengono passati dal Command,tutti inseriti in un arraylist di stringhe
	 * @return true se l'operazione va a buon fine,false altrimenti
	 */
	public boolean inserisciAgenzia(ArrayList<String> param){
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
	/**
	 * Modifica un'agenzia nel database 
	 * 
	 * Attraverso il business object relativo all'agenzia vengono modificati i dati relativi all'agenzia specificata.
	 * @param param arraylist di stringhe contenenti tutti i dati dell'agenzia
	 * @return true se l'operazione va a buon fine,false altrimenti
	 */
	public boolean modificaAgenzia(ArrayList<String> param){
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
	/**
	 * Elimina un'agenzia dal database
	 * 
	 * Viene passato l'identificativo dell'agenzia al business object che si occupa di gestire questa richiesta di eliminazione.
	 * 
	 * @param parameter l'identificativo dell'agenzia
	 * @return true se l'operazione va a buon fine,false altrimenti
	 */
	public boolean eliminaAgenzia(String parameter){
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
