package entity;

public class Agenzia {
int identificativo;
String nome;
String indirizzo;
String telefono;
public Agenzia(int id,String nome,String indirizzo,String telefono){
	this.identificativo=id;
	this.nome=nome;
	this.indirizzo=indirizzo;
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
public String getIndirizzo() {
	return indirizzo;
}
public void setIndirizzo(String indirizzo) {
	this.indirizzo = indirizzo;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}

}
