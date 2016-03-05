package business;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BusinessDelegate {
private LookUpInterface lookUp;

public Object handleRequest(String request,Object parameters) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
lookUp = new LookUp(request);
Method m = lookUp.findService();
return m.invoke(m.getDeclaringClass().newInstance(),parameters );}


public Object handleRequest(String request){
	lookUp = new LookUp(request);
	Method m = lookUp.findService();
	try {
		return m.invoke(m.getDeclaringClass().newInstance());
	} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;}
}
