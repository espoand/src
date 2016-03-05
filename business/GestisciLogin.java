package business;

import java.util.ArrayList;

import business.bo.LoginBusiness;

public class GestisciLogin {
LoginBusiness loginB = null;
public GestisciLogin(){
	loginB= new LoginBusiness();
}
public Object login(ArrayList<String> params){
	if(loginB==null) return false;
	String username = params.get(0);
	String password = params.get(1);
	return loginB.login(username, password);
}

}
