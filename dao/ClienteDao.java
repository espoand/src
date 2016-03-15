package dao;

import java.util.ArrayList;

import entity.Cliente;

public interface ClienteDao {
/*Inserisce il  cliente ed i relativi dati nel database
 * @param nome : nome del cliente
 * @param cognome: cognome del cliente
 * @param telefono : numero di telefono del cliente
 * @param codiceFiscale : codice fiscale del cliente
 * @param indirizzo : indirizzo di residenza del cliente
 * @return true se l'inserimento è avvenuto correttamente
 * @return false se l'inserimento dei dati è fallito
 * 
 */
public boolean inserisciCliente(String nome,String cognome,String telefono,String codiceFiscale,String via,String citta,String cap);
public boolean cancellaCliente(String codiceFiscale);
public boolean modificaCliente(String cf,String nome,String cognome,String telefono,String via,String citta,String cap);
public Cliente getCliente(String cf);
public ArrayList<Cliente> tuttiClienti();


}
