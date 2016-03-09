package business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import business.bo.AutoBusiness;
import business.bo.NoleggioBusiness;
import business.bo.TariffaBaseBusiness;
import entity.Auto;
import entity.ModalitaNoleggio;
import entity.Noleggio;
import entity.TariffaBase;

public class GestisciNoleggio {

	NoleggioBusiness nolb;
	
	public GestisciNoleggio(){
		try {
			nolb=new NoleggioBusiness();
			
		} catch (DatabaseInstantiationException e){
			nolb=null;
		}
	}
	
	public Object inserisciNoleggio(ArrayList<String> param) throws InstantiationException, ParseException{
		if(nolb==null)
			return false;
		TariffaBaseBusiness tarBus=new TariffaBaseBusiness();
		AutoBusiness autoBusine=new AutoBusiness();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
		
		int nroOrdine=Integer.parseInt(param.get(0));
		String tariffaBase=param.get(1);
		TariffaBase tar=tarBus.getTariffaBase(tariffaBase);
		String mod=param.get(2);
		ModalitaNoleggio modal=ModalitaNoleggio.valueOf(mod);
		String kmIllim=param.get(3);
		boolean isIllim=Boolean.parseBoolean(kmIllim);
		double nroKm=Double.parseDouble(param.get(4));
		String auto=param.get(5);
		Auto autoNoleggiata=autoBusine.getAuto(auto);
		Date dataEffettivaRiconsegna=formatter.parse(param.get(6));
		double importoTot=Double.parseDouble(param.get(6));
		
		Noleggio nol=new Noleggio(nroOrdine,tar,modal,isIllim,nroKm,autoNoleggiata,dataEffettivaRiconsegna,importoTot);
		return nolb.inserisciNoleggio(nol);
		
	}
	
	public Object modificaNoleggio(ArrayList<String> param) throws InstantiationException, ParseException{
		if(nolb==null)
			return false;
		TariffaBaseBusiness tarBus=new TariffaBaseBusiness();
		AutoBusiness autoBusine=new AutoBusiness();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
		
		int nroOrdine=Integer.parseInt(param.get(0));
		String tariffaBase=param.get(1);
		TariffaBase tar=tarBus.getTariffaBase(tariffaBase);
		String mod=param.get(2);
		ModalitaNoleggio modal=ModalitaNoleggio.valueOf(mod);
		String kmIllim=param.get(3);
		boolean isIllim=Boolean.parseBoolean(kmIllim);
		double nroKm=Double.parseDouble(param.get(4));
		String auto=param.get(5);
		Auto autoNoleggiata=autoBusine.getAuto(auto);
		Date dataEffettivaRiconsegna=formatter.parse(param.get(6));
		double importoTot=Double.parseDouble(param.get(6));
		
		Noleggio nol=new Noleggio(nroOrdine,tar,modal,isIllim,nroKm,autoNoleggiata,dataEffettivaRiconsegna,importoTot);
		return nolb.modificaNoleggio(nol);
		
	}
	
	public Object eliminaNoleggio(ArrayList<String> param) throws InstantiationException, ParseException{
		if(nolb==null)
			return false;
		TariffaBaseBusiness tarBus=new TariffaBaseBusiness();
		AutoBusiness autoBusine=new AutoBusiness();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
		
		int nroOrdine=Integer.parseInt(param.get(0));
		String tariffaBase=param.get(1);
		TariffaBase tar=tarBus.getTariffaBase(tariffaBase);
		String mod=param.get(2);
		ModalitaNoleggio modal=ModalitaNoleggio.valueOf(mod);
		String kmIllim=param.get(3);
		boolean isIllim=Boolean.parseBoolean(kmIllim);
		double nroKm=Double.parseDouble(param.get(4));
		String auto=param.get(5);
		Auto autoNoleggiata=autoBusine.getAuto(auto);
		LocalDate dataEffettivaRiconsegna=formatter.parse(param.get(6));
		double importoTot=Double.parseDouble(param.get(6));
		
		Noleggio nol=new Noleggio(nroOrdine,tar,modal,isIllim,nroKm,autoNoleggiata,dataEffettivaRiconsegna,importoTot);
		return nolb.cancellaNoleggio(nol);
		
	}
	
}
