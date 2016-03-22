package entity;

public class TariffaBase implements Comparable<TariffaBase>{
double costoAlKm;
double costoAlKmExtra;
double costoAlGiornoExtra;
String nome;
public TariffaBase(String nome,double c,double d,double e){
	this.nome = nome;
	costoAlKm = c;
	costoAlKmExtra = d;
	costoAlGiornoExtra=e;
	
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getCostoAlKm() {
	return costoAlKm;
}
public void setCostoAlKm(double costoAlKm) {
	this.costoAlKm = costoAlKm;
}
public double getCostoAlKmExtra() {
	return costoAlKmExtra;
}
public void setCostoAlKmExtra(double costoAlKmExtra) {
	this.costoAlKmExtra = costoAlKmExtra;
}
public double getCostoAlGiornoExtra() {
	return costoAlGiornoExtra;
}
public void setCostoAlGiornoExtra(double costoAlGiornoExtra) {
	this.costoAlGiornoExtra = costoAlGiornoExtra;
}
@Override
public int compareTo(TariffaBase o) {
	// TODO Auto-generated method stub
	if(nome.equals(o.getNome()) && costoAlKm== o.getCostoAlKm() && costoAlKmExtra == o.getCostoAlKmExtra() && costoAlGiornoExtra == o.getCostoAlGiornoExtra())
	return 0;
	else return -1;
}

}
