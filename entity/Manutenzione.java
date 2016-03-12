package entity;

import java.time.LocalDate;

import utility.TipoManutenzione;

public class Manutenzione {
int id;
Auto auto;
LocalDate data;
TipoManutenzione tipoManutenzione;
double costo;
public Manutenzione(int id,Auto a,LocalDate d,TipoManutenzione m,double c){
	auto = a;
	data = d;
	tipoManutenzione = m;
	costo = c;
	this.id = id;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Auto getAuto() {
	return auto;
}
public void setAuto(Auto auto) {
	this.auto = auto;
}
public LocalDate getData() {
	return data;
}
public void setData(LocalDate data) {
	this.data = data;
}
public TipoManutenzione getTipoManutenzione() {
	return tipoManutenzione;
}
public void setTipoManutenzione(TipoManutenzione tipoManutenzione) {
	this.tipoManutenzione = tipoManutenzione;
}
public double getCosto() {
	return costo;
}
public void setCosto(double costo) {
	this.costo = costo;
}


}
