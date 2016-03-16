package business.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import dao.AutoDao;
import dao.DaoFactory;
import entity.Auto;
import exceptions.DatabaseConnectionException;
/**
 * Classe per la gestione di richieste a livello di business per le automobili
 * 
 * @author Andrea Esposito & Mauro De Cesare
 * 
 */
public class AutoBusiness {
	
private static AutoDao auto;
/**
 * Cerca di avvalorare l'attributo di classe,altrimenti solleva un'eccezione
 * throws InstantiationException
 * 
 */
public AutoBusiness() throws InstantiationException{

	auto = DaoFactory.getDaoFactory(DaoFactory.MySQL).getAutoDao();
	

	



}
/**
 * Cerca di inserire l'auto nel database,altrimenti solleva un'eccezione
 * @throws DatabaseConnectionException
 * @param a L'auto da inserire
 * @return true se l'inserimento va a buon fine,altrimenti false
 */
public boolean inserisciAuto(Auto a){
	try {
		return auto.inserisciAuto(a.getTarga(), a.getModello(), a.getFascia(), a.getUltimoKmtraggio());
	} catch (DatabaseConnectionException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
		return false;
	}
	
}
/**
 * Cerca di modificare l'auto nel database inserendo l'ultimo kmtraggio,altrimenti solleva un'eccezione
 * 
 * @param a L'auto da modificare
 * @return true se la modifica va a buon fine,altrimenti false
 */
public boolean modificaAuto(Auto a,double ultimoKM){
	return auto.modificaAuto(a.getTarga(),ultimoKM);
}
/**
 * Rimuove un'auto da database
 * @param a l'auto da rimuovere
 * @return true se viene rimossa,altrimenti false
 */
public boolean rimuoviAuto(String t){
	return auto.rimuoviAuto(t);
}
/**
 * L'insieme di tutte le auto presenti nel database
 * @return 
 * 
 */
public ArrayList<Auto> getTutteAuto(){
	return auto.getTutteAuto();
}
/**
 * Insieme di tutte le auto disponibili 
 * @return
 */
public ArrayList<Auto> getAutoDisponibili(){
	return auto.getAutoDisponibili();
}



public Auto getAuto(String targa){
	return auto.getAuto(targa);
}
public boolean setStato(String targa,boolean disponibile){
	return auto.setStato(targa, disponibile);
}


}
