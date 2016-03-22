package entity;

public class Fascia implements Comparable<Fascia>{
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
@Override
public int compareTo(Fascia o) {
	// TODO Auto-generated method stub
	if(idFascia.equals(o.getIdFascia()) && descrizioneFascia.equals(o.getDescrizioneFascia()) && tariffaFascia.compareTo(o.getTariffaFascia()) == 0)
	return 0;
	else return -1;
}
}
