package dao;

import dao.mysql.MySqlDaoFactory;

public abstract class DaoFactory {
public static final int MySQL = 1;
public abstract AgenziaDao getAgenziaDao() throws InstantiationException, IllegalAccessException;
public abstract AutoDao getAutoDao();
public abstract ClienteDao getClienteDao();
public abstract ContrattoDao getContrattoDao();
public abstract FasciaDao getFasciaDao();
public abstract OperatoreDao getOperatoreDao();
public abstract TariffaBaseDao getTariffaBaseDao();
public abstract LoginDao getLoginDao();
public static DaoFactory getDaoFactory(int whichFactory){
	switch(whichFactory){
	case MySQL:
		return new MySqlDaoFactory();
	}
	return null;
}
public static Object createDao(Class c) throws InstantiationException, IllegalAccessException{
	return  c.newInstance();
}

}
