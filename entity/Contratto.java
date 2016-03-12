package entity;

import java.time.LocalDate;
import java.util.Date;

public class Contratto {
Cliente cliente;
LocalDate dataInizio;
double acconto;
int nroOrdine;
LocalDate finePrevista;
Agenzia agenziaNoleggio;
Agenzia agenziaRestituzione;
TariffaBase tariffaBase;
boolean kmIllimitato;
double nroKm;
Auto autoNoleggiata;
double importoTotale;
boolean chiuso;


public Contratto(int nroOrdine,Cliente c,LocalDate d,double acc,LocalDate fine,Agenzia noleggio,Agenzia restituzione,TariffaBase tariffaBase,boolean kmIllimitato,double nroKm,Auto autoNoleggiata,double importoTotale){
	
	this.cliente = c;
	this.dataInizio=d;
	this.acconto=acc;
	this.finePrevista=fine;
	this.agenziaNoleggio=noleggio;
	this.agenziaRestituzione=restituzione;
	this.nroOrdine=nroOrdine;
	this.tariffaBase = tariffaBase;
	this.kmIllimitato = kmIllimitato;
	this.autoNoleggiata = autoNoleggiata;
	this.importoTotale = importoTotale;
	chiuso = false;
	
}
public Contratto(int nroOrdine,Cliente c,LocalDate d,double acc,LocalDate fine,Agenzia noleggio,Agenzia restituzione,TariffaBase tariffaBase,boolean kmIllimitato,double nroKm,Auto autoNoleggiata,double importoTotale,boolean chiuso){
	
	this.cliente = c;
	this.dataInizio=d;
	this.acconto=acc;
	this.finePrevista=fine;
	this.agenziaNoleggio=noleggio;
	this.agenziaRestituzione=restituzione;
	this.nroOrdine=nroOrdine;
	this.tariffaBase = tariffaBase;
	this.kmIllimitato = kmIllimitato;
	this.autoNoleggiata = autoNoleggiata;
	this.importoTotale = importoTotale;
	this.chiuso = chiuso;	
}

public TariffaBase getTariffaBase() {
	return tariffaBase;
}


public void setTariffaBase(TariffaBase tariffaBase) {
	this.tariffaBase = tariffaBase;
}


public boolean isKmIllimitato() {
	return kmIllimitato;
}


public void setKmIllimitato(boolean kmIllimitato) {
	this.kmIllimitato = kmIllimitato;
}


public double getNroKm() {
	return nroKm;
}


public void setNroKm(double nroKm) {
	this.nroKm = nroKm;
}


public Auto getAutoNoleggiata() {
	return autoNoleggiata;
}


public void setAutoNoleggiata(Auto autoNoleggiata) {
	this.autoNoleggiata = autoNoleggiata;
}


public double getImportoTotale() {
	return importoTotale;
}


public void setImportoTotale(double importoTotale) {
	this.importoTotale = importoTotale;
}


public boolean isChiuso() {
	return chiuso;
}


public void setChiuso(boolean chiuso) {
	this.chiuso = chiuso;
}


public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public void setDataInizio(LocalDate dataInizio) {
	this.dataInizio = dataInizio;
}
public void setAcconto(double acconto) {
	this.acconto = acconto;
}
public void setNroOrdine(int nroOrdine) {
	this.nroOrdine = nroOrdine;
}
public void setFinePrevista(LocalDate finePrevista) {
	this.finePrevista = finePrevista;
}
public void setAgenziaNoleggio(Agenzia agenziaNoleggio) {
	this.agenziaNoleggio = agenziaNoleggio;
}
public void setAgenziaRestituzione(Agenzia agenziaRestituzione) {
	this.agenziaRestituzione = agenziaRestituzione;
}
public Cliente getCliente() {
	return cliente;
}
public LocalDate getDataInizio() {
	return dataInizio;
}
public double getAcconto() {
	return acconto;
}
public int getNroOrdine() {
	return nroOrdine;
}
public LocalDate getFinePrevista() {
	return finePrevista;
}
public Agenzia getAgenziaNoleggio() {
	return agenziaNoleggio;
}
public Agenzia getAgenziaRestituzione() {
	return agenziaRestituzione;
}


}
