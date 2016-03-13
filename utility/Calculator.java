package utility;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

import entity.TariffaBase;
import presentation.FrontController;

public class Calculator {
	
	public  double calcolaTotale(LocalDate inizio,LocalDate riconsegna,boolean illimitati,TariffaBase tariffa,double kmDaPercorrere){
		Period days = Period.between(inizio, riconsegna);
		double totale;
		int durata = days.getDays();
		if(illimitati){
			totale = tariffa.getCostoAlGiornoExtra() * durata;
		}
		else{
			totale = tariffa.getCostoAlKm() * kmDaPercorrere;
		}
		return totale;
		
	}
	public  double calcoloTotale(LocalDate inizio,LocalDate riconsegna){
		Period days = Period.between(inizio, riconsegna);
		int durata = days.getDays();
		return durata;
		
	}
		
	public static void main(String[] args){
		Calculator c = new Calculator();
		LocalDate oggi = LocalDate.parse("2016-03-13");
		LocalDate esame = LocalDate.parse("2016-04-12");
		System.out.println(c.calcoloTotale(oggi, esame));
	}
}
