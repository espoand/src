package business;

import java.util.ArrayList;

import business.bo.OperatoreBusiness;
import entity.Operatore;
import utility.Cifratura;

public class GestisciOperatore {

	private OperatoreBusiness ob;
	
	public GestisciOperatore() {
	
			ob=new OperatoreBusiness();
		
		
	}
	
	public Object inserisciOperatore(ArrayList<String> param) {
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
	
	public Object cancellaOperatore (String param){
		
		
		return ob.cancellaOperatore(param);
	}
	public Operatore getOperatore(String parameter){
		return ob.getOperatore(parameter);
	}
}
