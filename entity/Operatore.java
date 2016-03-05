package entity;

import utility.Cifratura;

public class Operatore {
String nome;
String cognome;
String cf;
String username;
String password;
boolean amministratore;
public Operatore(String cf,String nome,String cognome,String username,String password,boolean amministraotore) {
	
	// TODO Auto-generated constructor stub
	this.cf = cf;
	this.nome = nome;
	this.cognome = cognome;
	this.username = username;
	this.password = password;
	this.amministratore = amministratore;
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
public String getCf() {
	return cf;
}
public void setCf(String cf) {
	this.cf = cf;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public void setPassword(String password){
	Cifratura c = new Cifratura();
	this.password= c.cripta(password);
}
public String getPassword(){
	return password;
}
public boolean isAmministratore() {
	return amministratore;
}
public void setAmministratore(boolean amministratore) {
	this.amministratore = amministratore;
}

}
