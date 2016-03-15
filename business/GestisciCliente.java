package business;

import java.util.ArrayList;

import business.bo.ClienteBusiness;
import entity.Cliente;



public class GestisciCliente {

	ClienteBusiness cb;
	
	public GestisciCliente() {
		cb= new ClienteBusiness();
	}
	
	public Object inserisciCliente(ArrayList<String> param) {
		if(cb==null)
			return false;
		String nome=param.get(1);
		String cognome=param.get(2);
		String telefono=param.get(3);
		String codiceFiscale=param.get(0);
		String via=param.get(4);
		String citta = param.get(5);
		String cap = param.get(6);
		
		Cliente c= new Cliente(nome,cognome,telefono,codiceFiscale,via,citta,cap);
		return cb.inserisciCliente(c);
		
	}
	
	public Object modificaCliente(ArrayList<String> param){
		if(cb==null)
			return false;
		String codiceFiscale=param.get(0);
		String nome=param.get(1);
		String cognome=param.get(2);
		String telefono=param.get(3);
		String via=param.get(4);
		String citta = param.get(5);
		String cap = param.get(6);
		Cliente c= new Cliente(nome,cognome,telefono,codiceFiscale,via,citta,cap);
		return cb.modificaCliente(c);
		
	}
	
	public Object rimuoviCliente(String param) {
		if (cb==null)
			return false;
		
		
		return cb.rimuoviCliente(param);
		
		
		
		
	}
	public Cliente getCliente(String param){
		
		return cb.getCliente(param);
	}
	public ArrayList<Cliente> tuttiClienti(){
		return cb.tuttiClienti();
	}
}