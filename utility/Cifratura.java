package utility;
import java.math.BigInteger;
import java.security.MessageDigest;
/*
 * In questa classe viene implementata la funzione per criptare una stringa tramite la classe 
 * MessageDigest presente nelle API Java
 */
public class Cifratura {
	/*
	 * Il metodo crea un digest di  una stringa tramite l'algoritmo MD5 e poi la restituisce
	 * @param messaggio : la stringa che si vuole criptare
	 * @return cripted : la stringa criptata
	 * @throw Exception : eccezione generica
	 */
public String cripta(String messaggio){
	try{
		MessageDigest m= MessageDigest.getInstance("MD5");
		m.update(messaggio.getBytes());
		String cripted;
		cripted= String.format("%032x",new BigInteger(1,m.digest()));
		return cripted;
	}
	catch(Exception e){
		return null;
	}
}
public static void main(String[] args){
	Cifratura cifratura = new Cifratura();
	String stringa = "andrea";
	int i = 0;
	while(i<4){
		System.out.println(cifratura.cripta(stringa));
		i++;
	
	}
	
}
}
