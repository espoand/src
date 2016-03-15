package utility;

public class InputController {
public boolean onlyNumbers(String s){
	try {
		if(Integer.parseInt(s)>0)
		return true;
	else 
		return false;
	}
	catch(NumberFormatException e) {
		return false;
	}
	
}

public boolean onlyNumbersAndLetters(String s){
	return s.matches("^[a-zA-Z0-9]+$");
}
public boolean telephoneNumber(String s){
	return s.matches("^+(?:[0-9]●?){6,14}[0-9]$");
}
public boolean isDouble(String s){
	return s.matches("^[0-9]+\\.?[0-9]*$");
}
/*public static void main(String[] args){
	InputController ic = new InputController();
	System.out.println(Boolean.toString(ic.onlyNumbers("andrea")));
	System.out.println(Boolean.toString(ic.onlyNumbers("333")));
	System.out.println(Boolean.toString(ic.onlyNumbersAndLetters("AS111db")));
	System.out.println(Boolean.toString(ic.onlyNumbersAndLetters("AS11'	1db")));
	System.out.println(Boolean.toString(ic.telephoneNumber("3474794237")));
	System.out.println(Boolean.toString(ic.telephoneNumber("Andrea ")));
	System.out.println(Boolean.toString(ic.isDouble("2.33")));
	System.out.println(Boolean.toString(ic.isDouble("2 ")));




}*/
}
