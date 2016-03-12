package business.bo;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.TariffaBaseDao;
import entity.TariffaBase;

public class TariffaBaseBusiness {
private static TariffaBaseDao	tbDao = null;
public TariffaBaseBusiness(){
	tbDao = DaoFactory.getDaoFactory(DaoFactory.MySQL).getTariffaBaseDao();
}
public boolean inserisciTariffaBase(TariffaBase tb){
	return tbDao.inserisciTariffaBase(tb.getNome(), tb.getCostoAlKm(), tb.getCostoAlKmExtra(), tb.getCostoAlGiornoExtra());
	
}
public boolean eliminaTariffaBase(String tb){
	return tbDao.eliminaTariffaBase(tb);
}
public boolean modificaTariffaBase(TariffaBase tb){
	return tbDao.modificaTariffaBase(tb.getNome(), tb.getCostoAlKm(), tb.getCostoAlKmExtra() ,tb.getCostoAlGiornoExtra());
}
public TariffaBase getTariffaBase(String tb){
	return tbDao.getTariffaBase(tb);
}
public ArrayList<TariffaBase> getTariffe(){
	return tbDao.getTariffe();
}
}
