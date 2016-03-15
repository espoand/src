package dao;

import java.util.ArrayList;

import entity.Operatore;

public interface OperatoreDao {
public boolean inserisciOperatore(String cf,String nome,String cognome,String username,String password,boolean amministratore);
public boolean cancellaOperatore(String cf);
public Operatore getOperatore(String cf);
public ArrayList<Operatore> getOperatori();
}
