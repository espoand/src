package dao;

import java.time.LocalDate;
import java.util.ArrayList;

import entity.Auto;
import entity.Manutenzione;
import utility.TipoManutenzione;

public interface ManutenzioneDao {
public boolean inserisciManutenzione(Auto auto,LocalDate data,TipoManutenzione tipo,double costo);
public Manutenzione getManutenzione(int id);
public boolean eliminaManutenzione(int id);
public ArrayList<Manutenzione> getManutenzioni();
}
