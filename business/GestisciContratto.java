package business;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import business.bo.AgenziaBusiness;
import business.bo.ClienteBusiness;
import business.bo.ContrattoBusiness;
import entity.Agenzia;
import entity.Cliente;
import entity.Contratto;


public class GestisciContratto {

	private ContrattoBusiness cb;
	
	public GestisciContratto(){
		
			cb=new ContrattoBusiness();
		
	}
	
	public Object InserisciContratto(ArrayList<String> param) throws ParseException {
		if(cb==null)
			return false;
		AgenziaBusiness agenzie=new AgenziaBusiness();
		ClienteBusiness clientiBusiness=new ClienteBusiness();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
		
		String cf=param.get(0);
		Cliente cl=clientiBusiness.getCliente(cf);
		Date dataInizio=formatter.parse(param.get(1));
		double acconto=Double.parseDouble(param.get(2));
		int nroOrdine=Integer.parseInt(param.get(3));
		Date finePrevista=formatter.parse(param.get(4));
		int idAgenzia=Integer.parseInt(param.get(5));
		Agenzia ag=null;
		ArrayList<Agenzia> tutteAgenzia=agenzie.getAgenzie();
		Iterator it=tutteAgenzia.iterator();
		while(it.hasNext()){
			ag=(Agenzia) it.next();
			if(ag.getIdentificativo()==idAgenzia) break;
		 else return null;
	}
		int idAgenz=Integer.parseInt(param.get(6));
		Agenzia a=null;
		ArrayList<Agenzia> tutteAgenz=agenzie.getAgenzie();
		Iterator iter=tutteAgenz.iterator();
		while(iter.hasNext()){
			a=(Agenzia)it.next();
			if(a.getIdentificativo()==idAgenz) break;
			else return null;
			
		
		}
		Contratto c=new Contratto(cl,dataInizio,acconto,nroOrdine,finePrevista,ag,a);
		
		return cb.inserisciContratto(c);
		
	}
	
	public Object eliminaContratto(ArrayList<String> param) throws ParseException{
		
		if (cb==null)
			return false;
		AgenziaBusiness agenzie=new AgenziaBusiness();
		ClienteBusiness clientiBusiness=new ClienteBusiness();
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
		
		String cf=param.get(0);
		Cliente cl=clientiBusiness.getCliente(cf);
		
		Date dataInizio=formatter.parse(param.get(1));
		double acconto=Double.parseDouble(param.get(2));
		int nroOrdine=Integer.parseInt(param.get(3));
		Date finePrevista=formatter.parse(param.get(4));
		int idAgenzia=Integer.parseInt(param.get(5));
		Agenzia agenz=null;
		ArrayList<Agenzia> tutteAgenzia=agenzie.getAgenzie();
		Iterator it=tutteAgenzia.iterator();
		while(it.hasNext()){
			agenz=(Agenzia) it.next();
			if(agenz.getIdentificativo()==idAgenzia) break;
		 else return null;
	}
		int idAgenz=Integer.parseInt(param.get(6));
		Agenzia age=null;
		ArrayList<Agenzia> tutteAgenz=agenzie.getAgenzie();
		Iterator iter=tutteAgenz.iterator();
		while(iter.hasNext()){
			age=(Agenzia)it.next();
			if(age.getIdentificativo()==idAgenz) break;
			else return null;
			
		
		}
		
		Contratto c=new Contratto(cl,dataInizio,acconto,nroOrdine,finePrevista,age,agenz);
	
	    return cb.eliminaContratto(c);
	}
}