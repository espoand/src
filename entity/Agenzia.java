package entity;

public class Agenzia {
int identificativo;
String nome;
String via;
String citta;
String cap;
String telefono;

public Agenzia(int id,String nome,String via,String citta,String cap,String telefono){
	this.identificativo=id;
	this.nome=nome;
	this.via = via;
	this.citta = citta;
	this.cap =cap;
	this.telefono=telefono;
}
public int getIdentificativo() {
	return identificativo;
}
public void setIdentificativo(int identificativo) {
	this.identificativo = identificativo;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
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
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}

}
