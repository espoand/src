package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import entity.Auto;
import entity.Noleggio;
import entity.TariffaBase;

public interface NoleggioDao {
public boolean inserisciNoleggio(int nroOrdine,TariffaBase tariffaBase,boolean kmIllimitato,double nroKm,Auto autoNoleggiata,LocalDate dataEffettivaRiconsegna,double importoTotale);
public boolean cancellaNoleggio(int nroOrdine);
public Noleggio getNoleggio(int nroOrdine);
public boolean modificaNoleggio(int nroOrdine,TariffaBase tariffaBase,boolean kmIllimitato,double nroKm,Auto autoNoleggiata,LocalDate dataEffettivaRiconsegna,double importoTotale);
public ArrayList<Noleggio> getNoleggi();
}
