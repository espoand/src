package dao;

import entity.Operatore;

public interface OperatoreDao {
public boolean inserisciOperatore(String cf,String nome,String cognome,String username,String password,boolean amministratore);
public boolean cancellaOperatore(String cf);
public Operatore getOperatore(String cf);

}
