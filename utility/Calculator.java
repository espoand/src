package utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import entity.Noleggio;
import entity.TariffaBase;
import presentation.FrontController;

public class Calculator {
	
	public  double calcolaTotale(LocalDate inizio,LocalDate riconsegna,boolean illimitati,TariffaBase tariffa,double kmDaPercorrere){
		LocalDate oggi = Sessione.today();
		long durata = ChronoUnit;
		double totale;
		if(illimitati){
			totale = tariffa.getCostoAlGiornoExtra() * durata;
		}
		else{
			totale = tariffa.getCostoAlKm() * kmDaPercorrere;
		}
		return totale;
		
	}
	
		
}
