package business.bo;

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
public boolean eliminaTariffaBase(TariffaBase tb){
	return tbDao.eliminaTariffaBase(tb.getNome());
}
public boolean modificaTariffaBase(TariffaBase tb){
	return tbDao.modificaTariffaBase(tb.getNome(), tb.getCostoAlKm(), tb.getCostoAlKmExtra() ,tb.getCostoAlGiornoExtra());
}
public TariffaBase getTariffaBase(String tb){
	return tbDao.getTariffaBase(tb);
}
}
