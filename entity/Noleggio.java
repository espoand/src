package entity;

import java.sql.Date;
import java.time.LocalDate;

public class Noleggio {
int nroOrdine;
TariffaBase tariffaBase;
ModalitaNoleggio modalità;
boolean kmIllimitato;
double nroKm;
Auto autoNoleggiata;
LocalDate dataEffettivaRiconsegna;
double importoTotale;

public Noleggio(int nroOrdine, TariffaBase tariffa, boolean kmIllimitato, double nroKm, Auto autoNoleggiata, LocalDate dataRiconsegna,
		double importoTotale) {
	// TODO Auto-generated constructor stub
	this.nroOrdine=nroOrdine;
	this.tariffaBase = tariffa;
	this.kmIllimitato = kmIllimitato;
	this.nroKm = nroKm;
	this.autoNoleggiata = autoNoleggiata;
	this.dataEffettivaRiconsegna = dataRiconsegna;
	this.importoTotale = importoTotale;
}
public int getNroOrdine() {
	return nroOrdine;
}
public void setNroOrdine(int nroOrdine) {
	this.nroOrdine = nroOrdine;
}
public TariffaBase getTariffaBase() {
	return tariffaBase;
}
public void setTariffaBase(TariffaBase tariffaBase) {
	this.tariffaBase = tariffaBase;
}
public ModalitaNoleggio getModalità() {
	return modalità;
}
public void setModalità(ModalitaNoleggio modalità) {
	this.modalità = modalità;
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
public LocalDate getDataEffettivaRiconsegna() {
	return dataEffettivaRiconsegna;
}
public void setDataEffettivaRiconsegna(LocalDate dataEffettivaRiconsegna) {
	this.dataEffettivaRiconsegna = dataEffettivaRiconsegna;
}
public double getImportoTotale() {
	return importoTotale;
}
public void setImportoTotale(double importoTotale) {
	this.importoTotale = importoTotale;
}

}
