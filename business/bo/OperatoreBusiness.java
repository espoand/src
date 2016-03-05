package business.bo;

import dao.DaoFactory;
import dao.OperatoreDao;
import entity.Operatore;

public class OperatoreBusiness {
private static OperatoreDao operatoreDao= null;
public OperatoreBusiness(){
	operatoreDao = DaoFactory.getDaoFactory(DaoFactory.MySQL).getOperatoreDao();
}
public boolean inserisciOperatore(Operatore o){
	return operatoreDao.inserisciOperatore(o.getCf(), o.getNome(), o.getCognome(), o.getUsername(), o.getPassword(),o.isAmministratore());
}
public boolean cancellaOperatore(Operatore o){
	return operatoreDao.cancellaOperatore(o.getCf());
}
public Operatore getOperatore(Operatore o){
	return o;
}
}
