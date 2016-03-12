package utility;

import java.time.LocalDate;

import entity.Agenzia;
import entity.Auto;
import entity.Cliente;
import entity.Contratto;
import entity.Fascia;
import entity.Operatore;
import entity.TariffaBase;
import javafx.scene.Scene;

import java.time.temporal.ChronoUnit;

public  class Sessione {
static String username= null;
public static Auto getAutoAttuale() {
	return autoAttuale;
}

public static void setAutoAttuale(Auto autoAttuale) {
	Sessione.autoAttuale = autoAttuale;
}

public static Contratto getContrattoAttuale() {
	return contrattoAttuale;
}

public static void setContrattoAttuale(Contratto contrattoAttuale) {
	Sessione.contrattoAttuale = contrattoAttuale;
}

private static Scene sc = null;
public static Scene getSc() {
	return sc;
}

public static void setSc(Scene sc) {
	Sessione.sc = sc;
}

static TipoUtente tipo= null;
static String viewAttuale= null;
static String viewPrecedente= null;
//utile per mostrare l'auto che l'utente ha cercato
static Auto autoAttuale= null;
static Cliente clienteAttuale= null;
static Fascia fasciaAttuale = null;
static TariffaBase tariffaAttuale= null;

static Operatore operatoreAttuale = null;
static Contratto contrattoAttuale = null;
static Agenzia agenziaAttuale = null;
static String cf = null;


public static Agenzia getAgenziaAttuale() {
	return agenziaAttuale;
}

public static void setAgenziaAttuale(Agenzia agenziaAttuale) {
	Sessione.agenziaAttuale = agenziaAttuale;
}

public static TipoUtente getTipo() {
	return tipo;
}

public static void setTipo(TipoUtente tipo) {
	Sessione.tipo = tipo;
}

public static Operatore getOperatoreAttuale() {
	return operatoreAttuale;
}

public static void setOperatoreAttuale(Operatore operatoreAttuale) {
	Sessione.operatoreAttuale = operatoreAttuale;
}



//trova la data odierna
public static LocalDate today(){
	LocalDate today = LocalDate.now();
	return today;
	
}

public static Fascia getFasciaAttuale() {
	return fasciaAttuale;
}

public static void setFasciaAttuale(Fascia fasciaAttuale) {
	Sessione.fasciaAttuale = fasciaAttuale;
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
	fasciaAttuale = null;
	tariffaAttuale = null;

	operatoreAttuale = null;
	cf = null;
}
public static String getCf() {
	return cf;
}

public static void setCf(String cf) {
	Sessione.cf = cf;
}

public static TariffaBase getTariffaAttuale() {
	return tariffaAttuale;
}

public static void setTariffaAttuale(TariffaBase tariffaAttuale) {
	Sessione.tariffaAttuale = tariffaAttuale;
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
