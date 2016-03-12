package business.bo;

import java.util.ArrayList;

import dao.AgenziaDao;
import dao.DaoFactory;
import entity.Agenzia;

public class AgenziaBusiness {
private static	AgenziaDao agenziaDao = null;
	public AgenziaBusiness(){
		try {
			agenziaDao = DaoFactory.getDaoFactory(DaoFactory.MySQL).getAgenziaDao();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public boolean inserisciAgenzia(Agenzia a){
 return agenziaDao.inserisciAgenzia(a.getIdentificativo(), a.getNome(), a.getVia(),a.getCitta(),a.getCap(), a.getTelefono());
}
public boolean rimuoviAgenzia(int ag){
	return agenziaDao.rimuoviAgenzia(ag);
	
}
public boolean modificaAgenzia(Agenzia a){
	return agenziaDao.modificaAgenzia(a.getIdentificativo(), a.getNome(), a.getVia(),a.getCitta(),a.getCap(), a.getTelefono());
}
public ArrayList<Agenzia> getAgenzie(){
	return agenziaDao.getAgenzie();
}
public Agenzia getAgenzia(int id){
	return agenziaDao.getAgenzia(id);
}

}
