package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import entity.Agenzia;
import entity.Auto;
import entity.Cliente;
import entity.Contratto;
import entity.TariffaBase;


public interface ContrattoDao {
public boolean inserisciContratto(Cliente cliente,LocalDate dataInizio,double acconto,LocalDate finePrevista,Agenzia agenziaNoleggio,Agenzia agenziaRestituzione,TariffaBase tariffaBase,boolean kmIllimitato,double nroKm,Auto autoNoleggiata,double importoTotale);
public boolean eliminaContratto(int nroOrdine);
public ArrayList<Contratto> getContratti();
public boolean modificaContratto(Cliente cliente,LocalDate dataInizio,double acconto,int nroOrdine,LocalDate finePrevista,Agenzia agenziaNoleggio,Agenzia agenziaRestituzione,TariffaBase tariffaBase,boolean kmIllimitato,double nroKm,Auto autoNoleggiata,double importoTotale);
public boolean chiudiContratto(int nroOrdine);

}
