package entity;

public class Fascia {
String idFascia;
String descrizioneFascia;
TariffaBase tariffaFascia;
public String getIdFascia() {
	return idFascia;
}
public void setIdFascia(String idFascia) {
	this.idFascia = idFascia;
}
public String getDescrizioneFascia() {
	return descrizioneFascia;
}
public void setDescrizioneFascia(String descrizioneFascia) {
	this.descrizioneFascia = descrizioneFascia;
}
public TariffaBase getTariffaFascia() {
	return tariffaFascia;
}
public void setTariffaFascia(TariffaBase tariffaFascia) {
	this.tariffaFascia = tariffaFascia;
}
public Fascia(String id,String descr,TariffaBase tariffa){
	this.idFascia=id;
	this.descrizioneFascia=descr;
	this.tariffaFascia=tariffa;
}
}
