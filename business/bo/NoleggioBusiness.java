package business.bo;
import java.util.ArrayList;

import dao.DaoFactory;
import dao.NoleggioDao;
import entity.Noleggio;
public class NoleggioBusiness {
private static NoleggioDao noleggioDao = null;
public NoleggioBusiness(){
	noleggioDao= DaoFactory.getDaoFactory(DaoFactory.MySQL).getNoleggioDao();
}
public boolean inserisciNoleggio(Noleggio n){
	return noleggioDao.inserisciNoleggio(n.getNroOrdine(), n.getTariffaBase(), n.isKmIllimitato(), n.getNroKm(), n.getAutoNoleggiata(), n.getDataEffettivaRiconsegna(), n.getImportoTotale());
}
public boolean cancellaNoleggio(Noleggio n){
return noleggioDao.cancellaNoleggio(n.getNroOrdine());
}
public boolean modificaNoleggio(Noleggio n){
	return noleggioDao.modificaNoleggio(n.getNroOrdine(), n.getTariffaBase(), n.isKmIllimitato(), n.getNroKm(), n.getAutoNoleggiata(), n.getDataEffettivaRiconsegna(), n.getImportoTotale());
	}
public Noleggio getNoleggio(Noleggio n){
return n;
}
public ArrayList<Noleggio> getNoleggi(){
	return noleggioDao.getNoleggi();
}}
