package business.bo;

import java.util.ArrayList;

import dao.ContrattoDao;
import dao.DaoFactory;
import entity.Contratto;

public class ContrattoBusiness {
	private static ContrattoDao contrattoDao = null;
public ContrattoBusiness(){
	
	contrattoDao = DaoFactory.getDaoFactory(DaoFactory.MySQL).getContrattoDao();
	
}
public boolean inserisciContratto(Contratto c){
	return contrattoDao.inserisciContratto(c.getCliente(), c.getDataInizio(), c.getAcconto(), c.getNroOrdine(), c.getFinePrevista(), c.getAgenziaNoleggio(), c.getAgenziaRestituzione());
}
public boolean eliminaContratto(Contratto c){
	return contrattoDao.eliminaContratto(c.getNroOrdine());
}
public ArrayList<Contratto> getContratti(){
	return contrattoDao.getContratti();
}

}
