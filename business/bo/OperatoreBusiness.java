package business.bo;

import java.util.ArrayList;

import business.GestisciOperatore;
import dao.DaoFactory;
import dao.OperatoreDao;
import entity.Operatore;
import utility.Cifratura;

public class OperatoreBusiness {
private static OperatoreDao operatoreDao= null;
public OperatoreBusiness(){
	operatoreDao = DaoFactory.getDaoFactory(DaoFactory.MySQL).getOperatoreDao();
}
public boolean inserisciOperatore(Operatore o){
	return operatoreDao.inserisciOperatore(o.getCf(), o.getNome(), o.getCognome(), o.getUsername(), o.getPassword(),o.isAmministratore());
}
public boolean cancellaOperatore(String o){
	return operatoreDao.cancellaOperatore(o);
}
public Operatore getOperatore(String cf){
	return operatoreDao.getOperatore(cf);
}
public ArrayList<Operatore> getOperatori(){
	return operatoreDao.getOperatori();
}
public static void main(String[] args){
	ArrayList<String> parameters = new ArrayList<String>();
	OperatoreBusiness go = new OperatoreBusiness();
	
	Cifratura cifr = new Cifratura();
	parameters.add("1234567890123456");
	parameters.add("Admin");
	parameters.add("Admin");
	parameters.add("admin");
	parameters.add("21232f297a57a5a743894a0e4a801fc3");
	parameters.add(Boolean.toString(true));
	
	
	Operatore operator=new Operatore(parameters.get(0),parameters.get(1),parameters.get(2),parameters.get(3),parameters.get(4),Boolean.parseBoolean(parameters.get(5)));;
	go.inserisciOperatore(operator);
	System.out.println(Boolean.toString(operator.isAmministratore()));
	
}
}
