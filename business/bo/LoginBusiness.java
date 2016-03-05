package business.bo;

import dao.DaoFactory;
import dao.LoginDao;
import dao.mysql.MySQLLoginDao;

public class LoginBusiness {
private static LoginDao login = null;
public LoginBusiness(){
	login = DaoFactory.getDaoFactory(DaoFactory.MySQL).getLoginDao();
}
public boolean login(String username,String password){
	return login.login(username, password);
	
}
}
