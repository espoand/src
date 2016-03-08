package utility;

import java.time.LocalDate;

import entity.Auto;
import entity.Cliente;
import entity.TariffaBase;
import java.time.temporal.ChronoUnit;

public  class Sessione {
static String username;
static TipoUtente tipo;
static String viewAttuale;
static String viewPrecedente;
//utile per mostrare l'auto che l'utente ha cercato
static Auto autoAttuale;
static Cliente clienteAttuale;
//trova la data odierna
public static LocalDate today(){
	LocalDate today = LocalDate.now();
	return today;
	
}

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
	clienteAttuale = null;
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

//calcola il totale in base ai km,poi se non si riconsegna in tempo scatta la mora per ogni giorno
public static Cliente getClienteAttuale() {
	return clienteAttuale;
}


  public static void setClienteAttuale(Cliente clienteAttuale) {

	Sessione.clienteAttuale = clienteAttuale;
}
/*
public static double calcolaTotale(LocalDate riconsegna,boolean illimitati,TariffaBase tariffa,double kmDaPercorrere){
	LocalDate oggi = today();
	long durata = ChronoUnit.
	double totale;
	if(illimitati){
		totale = tariffa.getCostoAlGiornoExtra() * durata;
	}
	else{
		totale = tariffa.getCostoAlKm() * kmDaPercorrere;
	}
	return totale;
	
}
public static void main(String[] args){
	LocalDate riconsegna = LocalDate.of(2016, 03, 16);
	TariffaBase tariffa = new TariffaBase("prova",1.70,5,50);
	System.out.println(Double.toString(Sessione.calcolaTotale(riconsegna,false,tariffa,400)));
	System.out.println(Double.toString(Sessione.calcolaTotale(riconsegna,true,tariffa,400)));
	LocalDate riconsegnaDopoUnMese = LocalDate.of(2016, 04, 06);
	System.out.println(Double.toString(Sessioasfane.calcolaTotale(riconsegnaDopoUnMese,false,tariffa,400)));


}*/

}
