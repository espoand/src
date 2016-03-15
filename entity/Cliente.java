package entity;

public class Cliente {
String nome;
String cognome;
String telefono;
String codiceFiscale;
String via;
String citta;
String cap;
public Cliente(String nome,String cognome,String telefono,String codiceFiscale,String via,String citta,String cap) throws RuntimeException{
	if(nome.length()==0 || cognome.length()==0 || telefono.length()==0 || codiceFiscale.length()==0 || via.length()==0) throw new RuntimeException("Tutti i campi sono obbligatori");
	if(codiceFiscale.length()!=16 ) throw new RuntimeException("Il codice fiscale deve contenere 16 cifre");
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




}
