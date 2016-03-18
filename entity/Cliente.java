package entity;

public class Cliente implements Comparable<Cliente>{
String nome;
String cognome;
String telefono;
String codiceFiscale;
String via;
String citta;
String cap;
public Cliente(String nome,String cognome,String telefono,String codiceFiscale,String via,String citta,String cap) throws RuntimeException{
	
	this.nome=nome;
	this.cognome=cognome;
	this.telefono=telefono;
	this.codiceFiscale=codiceFiscale;
	this.via=via;
	this.citta = citta;
	this.cap = cap;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getCodiceFiscale() {
	return codiceFiscale;
}
public void setCodiceFiscale(String codiceFiscale) {
	this.codiceFiscale = codiceFiscale;
}
public String getVia() {
	return via;
}
public void setVia(String via) {
	this.via = via;
}
public String getCitta() {
	return citta;
}
public void setCitta(String citta) {
	this.citta = citta;
}
public String getCap() {
	return cap;
}
public void setCap(String cap) {
	this.cap = cap;
}
@Override
public int compareTo(Cliente o) {
	// TODO Auto-generated method stub
	if(nome.equals(o.nome) && cognome.equals(o.cognome) && telefono.equals(o.getTelefono()) && codiceFiscale.equals(o.getCodiceFiscale()) && via.equals(o.getVia()) && citta.equals(o.citta) && cap.equals(o.cap)){
		return 0;
	}
	return -1;
}




}
