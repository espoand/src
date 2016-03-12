package business.bo;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.FasciaDao;
import entity.Fascia;

public class FasciaBusiness {
private static FasciaDao fasciaDao = null;
public FasciaBusiness(){
	fasciaDao= DaoFactory.getDaoFactory(DaoFactory.MySQL).getFasciaDao();
}
public boolean inserisciFascia(Fascia f){
	return fasciaDao.inserisciFascia(f.getIdFascia(), f.getDescrizioneFascia(), f.getTariffaFascia());
}
public boolean rimuoviFascia(String f){
	return fasciaDao.eliminaFascia(f);
}
public boolean modificaFascia(Fascia f){
	return fasciaDao.modificaFascia(f.getIdFascia(), f.getTariffaFascia());
}
public ArrayList<Fascia> getFasce(){
	return fasciaDao.getFasce();
}
}
