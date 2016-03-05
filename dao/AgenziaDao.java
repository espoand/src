package dao;

import java.util.ArrayList;

import entity.Agenzia;
import exceptions.DatabaseConnectionException;

public interface AgenziaDao {
public boolean inserisciAgenzia(int id,String nome,String indirizzo,String telefono) ;
public boolean modificaAgenzia(int id,String nome,String indirizzo,String telefono);
public boolean rimuoviAgenzia(int id);
public ArrayList<Agenzia> getAgenzie() ;
public Agenzia getAgenzia(int id);

}
