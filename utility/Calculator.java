package utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import entity.Noleggio;
import entity.TariffaBase;
import presentation.FrontController;

public class Calculator {
	
	public  double calcolaTotale(LocalDate riconsegna,boolean illimitati,TariffaBase tariffa,double kmDaPercorrere){
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
	public int calcolaNroOrdine(){
		FrontController fc = new FrontController();
		ArrayList<Noleggio> tuttiNoleggi = (ArrayList<Noleggio>) fc.handleRequest("TuttiNoleggi");
		Iterator<Noleggio> it1 = tuttiNoleggi.iterator();
		int nroOrdine = 0;
		while(it1.hasNext()){
			nroOrdine++;
			}
		nroOrdine++;
	
	return nroOrdine;
	}
		
}
