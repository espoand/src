package business;

import java.util.ArrayList;

import business.bo.LoginBusiness;
import utility.Cifratura;

public class GestisciLogin {
LoginBusiness loginB = null;
public GestisciLogin(){
	loginB= new LoginBusiness();
}
public Object login(ArrayList<String> params){
	Cifratura cifratore = new Cifratura();
	if(loginB==null) return false;
	String username = params.get(0);
	String password = cifratore.cripta(params.get(1));
	return loginB.login(username, password);
}

}
