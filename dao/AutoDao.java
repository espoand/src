package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import utility.Manutenzione;
import entity.Auto;
import entity.Fascia;
import exceptions.DatabaseConnectionException;

public interface AutoDao {
public boolean inserisciAuto(String targa,String modello,Fascia fascia,double ultimoKmtraggio) throws DatabaseConnectionException;
public boolean rimuoviAuto(String targa);
public boolean modificaAuto(String targa,double ultimoKm);
public ArrayList<Auto> getTutteAuto();
public ArrayList<Auto> getAutoDisponibili();
public boolean aggiungiManutenzione(String targa,LocalDate data,double costo,Manutenzione tipo);
public Auto getAuto(String targa);
public boolean setStato(String targa,boolean disponibile);



}
