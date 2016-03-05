package entity;

import java.util.Date;

public class Contratto {
Cliente cliente;
Date dataInizio;
double acconto;
int nroOrdine;
Date finePrevista;
Agenzia agenziaNoleggio;
Agenzia agenziaRestituzione;
public Contratto(int nroOrdine,Cliente c,Date d,double acc,Date fine,Agenzia noleggio,Agenzia restituzione){
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
public void setDataInizio(Date dataInizio) {
	this.dataInizio = dataInizio;
}
public void setAcconto(double acconto) {
	this.acconto = acconto;
}
public void setNroOrdine(int nroOrdine) {
	this.nroOrdine = nroOrdine;
}
public void setFinePrevista(Date finePrevista) {
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
public Date getDataInizio() {
	return dataInizio;
}
public double getAcconto() {
	return acconto;
}
public int getNroOrdine() {
	return nroOrdine;
}
public Date getFinePrevista() {
	return finePrevista;
}
public Agenzia getAgenziaNoleggio() {
	return agenziaNoleggio;
}
public Agenzia getAgenziaRestituzione() {
	return agenziaRestituzione;
}

}
