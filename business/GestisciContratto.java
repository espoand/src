package business;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import business.bo.AgenziaBusiness;
import business.bo.AutoBusiness;
import business.bo.ClienteBusiness;
import business.bo.ContrattoBusiness;
import business.bo.TariffaBaseBusiness;
import entity.Agenzia;
import entity.Auto;
import entity.Cliente;
import entity.Contratto;
import entity.TariffaBase;
import exceptions.GenericException;


public class GestisciContratto {

	private ContrattoBusiness cb;
	
	
	public GestisciContratto(){
		
			cb=new ContrattoBusiness();
		
	}
	
	public Object InserisciContratto(ArrayList<String> param) throws ParseException, InstantiationException {
		if(cb==null)
			return false;
		AgenziaBusiness agenzie=new AgenziaBusiness();
		ClienteBusiness clientiBusiness=new ClienteBusiness();
		AutoBusiness autoBusiness = new AutoBusiness();
		TariffaBaseBusiness tbBusiness = new TariffaBaseBusiness();
		
		
		
		
		
		Cliente cl=clientiBusiness.getCliente(param.get(0));
		LocalDate dataInizio=LocalDate.parse(param.get(1));
		double acconto=Double.parseDouble(param.get(2));
	
		LocalDate finePrevista=LocalDate.parse(param.get(3));
		TariffaBase tb = tbBusiness.getTariffaBase(param.get(6));
		boolean kmIllimitati = Boolean.parseBoolean(param.get(7));
		double nroKm = Double.parseDouble(param.get(8));
		Auto auto = autoBusiness.getAuto(param.get(9));
		double totale = Double.parseDouble(param.get(10));
		ArrayList<Auto> autoDisponibili= autoBusiness.getAutoDisponibili();
		boolean disponibile = false;
		Iterator<Auto> it1 = autoDisponibili.iterator();
		while(it1.hasNext()){
			if(it1.next().getTarga().equals(auto.getTarga())){
				disponibile = true;
				break;
			}
		}
		if(!disponibile) throw new GenericException("Auto non disponibile");
		
		
		
		Agenzia agenziaNoleggio = agenzie.getAgenzia(Integer.parseInt(param.get(4)));
		Agenzia agenziaRestituzione = agenzie.getAgenzia(Integer.parseInt(param.get(5)));
		
		
			
		
		
		Contratto c=new Contratto(0,cl,dataInizio,acconto,finePrevista,agenziaNoleggio,agenziaRestituzione,tb,kmIllimitati,nroKm,auto,totale);
		boolean autoModificata = false;
		autoModificata = autoBusiness.setStato(auto.getTarga(), false);
		if(autoModificata){return cb.inserisciContratto(c);}
		return false;
	
		
	}
	
	public Object eliminaContratto(String param) throws ParseException{
		
		if (cb==null)
			return false;
		
	    return cb.eliminaContratto(Integer.parseInt(param));
	    
	}
	public Contratto getContratto(String parameter){
		int nroOrdine = Integer.parseInt(parameter);
		return cb.getContratto(nroOrdine);
	}
	public boolean modificaContratto(ArrayList<String> parameters) throws InstantiationException{
		AgenziaBusiness agenzie=new AgenziaBusiness();
		ClienteBusiness clientiBusiness=new ClienteBusiness();
		AutoBusiness autoBusiness = new AutoBusiness();
		TariffaBaseBusiness tbBusiness = new TariffaBaseBusiness();
		Cliente cliente = clientiBusiness.getCliente(parameters.get(0));
		LocalDate dataInizio = LocalDate.parse(parameters.get(1));
		double acconto = Double.parseDouble(parameters.get(2));
		int nroOrdine = Integer.parseInt(parameters.get(3));
		LocalDate dataFine = LocalDate.parse(parameters.get(4));
		
		Agenzia agRestituzione = agenzie.getAgenzia(Integer.parseInt(parameters.get(6)));
		
		Agenzia agNoleggio= agenzie.getAgenzia(Integer.parseInt(parameters.get(5)));
		TariffaBase tb = tbBusiness.getTariffaBase(parameters.get(7));
		boolean kmIllimitati = Boolean.parseBoolean(parameters.get(8));
		double nroKm = Double.parseDouble(parameters.get(9));
		Auto auto = autoBusiness.getAuto(parameters.get(10));
		double totale = Double.parseDouble(parameters.get(11));
		ArrayList<Auto> autoDisponibili= autoBusiness.getAutoDisponibili();
		boolean disponibile = false;
		Iterator<Auto> it1 = autoDisponibili.iterator();
		while(it1.hasNext()){
			if(it1.next().getTarga().equals(auto.getTarga())){
				disponibile = true;
				break;
			}
		}
		if(!disponibile) throw new GenericException("Auto non disponibile");
		
		
		
		Contratto c=new Contratto(nroOrdine,cliente,dataInizio,acconto,dataFine,agNoleggio,agRestituzione,tb,kmIllimitati,nroKm,auto,totale);
		
		return cb.modificaContratto(c);
		
	}
	public boolean chiudiContratto(String param) throws InstantiationException{
		Contratto contratto = cb.getContratto(Integer.parseInt(param));
		String targaAuto= contratto.getAutoNoleggiata().getTarga();
		AutoBusiness ab = new AutoBusiness();
		ab.setStato(targaAuto, true);
		Auto a = ab.getAuto(targaAuto);
		ab.modificaAuto(a, a.getUltimoKmtraggio() + contratto.getNroKm());
		return cb.chiudiContratto(Integer.parseInt(param));
	}
	public ArrayList<Contratto> getContratti(){
		return cb.getContratti();
	}
	

}