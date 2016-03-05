package utility;

import entity.Auto;

public  class Sessione {
static String username;
static TipoUtente tipo;
static String viewAttuale;
static String viewPrecedente;
//utile per mostrare l'auto che l'utente ha cercato
static Auto autoAttuale;

public Sessione(String username,TipoUtente tipo){
	this.username=username;
	this.tipo=tipo;
	if(tipo==TipoUtente.AMMINISTRATORE){
		viewAttuale="SchermataAmministratore";
		
	}
	else viewAttuale="SchermataOperatore";
}
public static void cambiaView(String nuovaView){
	viewPrecedente=viewAttuale;
	viewAttuale=nuovaView;
	
}
public static void setAuto(Auto a){
	autoAttuale = a;
}
public static Auto getAuto(){
	return autoAttuale;
}
public static void azzera(){
	username =null;
	tipo= null;
	viewAttuale=null;
	viewPrecedente = null;
	autoAttuale = null;
}
public static String getPrecedente(){
	return viewPrecedente;
}
public static void setUsername(String u){
	username =u;
}
public static String getUsername(){
	return username;
}
public static void setTipoUtente(TipoUtente t){
	tipo=t;
}
}
