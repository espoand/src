package entity;

import exceptions.GenericException;

public class Auto {
String targa;
String modello;
Fascia fascia;
boolean disponibile;
double ultimoKmtraggio;
String dataManutenzioneOrdinaria;
String dataManutenzioneStraordinaria;
public String getDataManutenzioneOrdinaria() {
	return dataManutenzioneOrdinaria;
}
public void setDataManutenzioneOrdinaria(String dataManutenzioneOrdinaria) {
	this.dataManutenzioneOrdinaria = dataManutenzioneOrdinaria;
}
public String getDataManutenzioneStraordinaria() {
	return dataManutenzioneStraordinaria;
}
public void setDataManutenzioneStraordinaria(
		String dataManutenzioneStraordinaria) {
	this.dataManutenzioneStraordinaria = dataManutenzioneStraordinaria;
}
public Auto(String targa,String modello,Fascia fascia,boolean b, double ultimoKmtraggio) throws RuntimeException{
	if(targa.length()<3 || targa.length()>10) throw new GenericException("Targa non valida!");
	if(modello == null || fascia == null ) throw new GenericException("Modello e/o fascia non valido/i");
	this.targa=targa;
	this.modello=modello;
	this.fascia=fascia;
	disponibile = true;
	this.ultimoKmtraggio=ultimoKmtraggio;
	this.disponibile=b;
	
}
public String getTarga() {
	return targa;
}
public void setTarga(String targa) {
	this.targa = targa;
}
public String getModello() {
	return modello;
}
public void setModello(String modello) {
	this.modello = modello;
}
public Fascia getFascia() {
	return fascia;
}
public void setFascia(Fascia fascia) {
	this.fascia = fascia;
}
public boolean isDisponibile() {
	return disponibile;
}
public void setDisponibile(boolean disponibile) {
	this.disponibile = disponibile;
}
public double getUltimoKmtraggio() {
	return ultimoKmtraggio;
}
public void setUltimoKmtraggio(double ultimoKmtraggio) {
	this.ultimoKmtraggio = ultimoKmtraggio;
}

}
