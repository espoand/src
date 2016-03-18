package business;

import java.util.ArrayList;

import business.bo.OperatoreBusiness;
import entity.Operatore;
import exceptions.GenericException;
import utility.Cifratura;

public class GestisciOperatore {

	private OperatoreBusiness ob;
	
	public GestisciOperatore() {
	
			ob=new OperatoreBusiness();
		
		
	}
	
	public boolean inserisciOperatore(ArrayList<String> param) {
		if(ob==null)
			return false;
		Cifratura cifr = new Cifratura();
		String cf=param.get(0);
		String nome=param.get(1);
		String cognome=param.get(2);
		String username=param.get(3);
		String password=cifr.cripta(param.get(4));
		boolean amministratore = Boolean.parseBoolean(param.get(5));
		
		Operatore operator=new Operatore(cf,nome,cognome,username,password,amministratore);
		return ob.inserisciOperatore(operator);
		
	}
	
	public boolean cancellaOperatore (String param){
		
		
		return ob.cancellaOperatore(param);
	}
	public Operatore getOperatore(String parameter){
		return ob.getOperatore(parameter);
	}
	public ArrayList<Operatore> getOperatori(){
		ArrayList<Operatore> tutti = ob.getOperatori();
		if(tutti == null){
			throw new GenericException("Si è verificato un errore");
		}
		return tutti;
	}
	public static void main(String[] args){
		ArrayList<String> parameters = new ArrayList<String>();
		GestisciOperatore go = new GestisciOperatore();
		
		Cifratura cifr = new Cifratura();
		parameters.add("1234567890123456");
		parameters.add("Admin");
		parameters.add("Admin");
		parameters.add("admin");
		parameters.add("21232f297a57a5a743894a0e4a801fc3");
		parameters.add(Boolean.toString(true));
		
		
		
		go.inserisciOperatore(parameters);
		
	}
}
