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
public Contratto(int nroOrdine,Cliente c,LocalDate d,double acc,LocalDate fine,Agenzia noleggio,Agenzia restituzione){
	this.cliente = c;
	this.dataInizio=d;
	this.acconto=acc;
	this.finePrevista=fine;
	this.agenziaNoleggio=noleggio;
	this.agenziaRestituzione=restituzione;
	this.nroOrdine=nroOrdine;
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
