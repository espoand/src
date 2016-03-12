package business.bo;

import java.util.ArrayList;
import java.util.Iterator;

import dao.ContrattoDao;
import dao.DaoFactory;
import entity.Contratto;

public class ContrattoBusiness {
	private static ContrattoDao contrattoDao = null;
public ContrattoBusiness(){
	
	contrattoDao = DaoFactory.getDaoFactory(DaoFactory.MySQL).getContrattoDao();
	
}
public boolean inserisciContratto(Contratto c){
	return contrattoDao.inserisciContratto(c.getCliente(), c.getDataInizio(), c.getAcconto(),c.getFinePrevista(), c.getAgenziaNoleggio(), c.getAgenziaRestituzione(),c.getTariffaBase(),c.isKmIllimitato(),c.getNroKm(),c.getAutoNoleggiata(),c.getImportoTotale());
}
public boolean eliminaContratto(int c){
	return contrattoDao.eliminaContratto(c);
}
public ArrayList<Contratto> getContratti(){
	return contrattoDao.getContratti();
}
public Contratto getContratto(int nroOrdine){
	ArrayList<Contratto> contratti= contrattoDao.getContratti();
	Iterator<Contratto> it1 = contratti.iterator();
	Contratto tmp;
	while(it1.hasNext()){
		tmp = it1.next();
		if(tmp.getNroOrdine() == nroOrdine){
			return tmp;
		}
	}
	return null;
}
public boolean modificaContratto(Contratto c){
	return contrattoDao.modificaContratto(c.getCliente(), c.getDataInizio(),c.getAcconto(),c.getNroOrdine(), c.getFinePrevista(), c.getAgenziaNoleggio(), c.getAgenziaRestituzione(),c.getTariffaBase(),c.isKmIllimitato(),c.getNroKm(),c.getAutoNoleggiata(),c.getImportoTotale());
}
public boolean chiudiContratto(int c){
	return contrattoDao.chiudiContratto(c);
}
}
