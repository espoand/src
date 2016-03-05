package dao.mysql;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import dao.*;
import entity.Agenzia;
import entity.Cliente;
import exceptions.DatabaseConnectionException;

public class MySQLAgenziaDao implements AgenziaDao{
	
	/**
	 * Il metodo restituisce un ArrayList con tutte le agenzie presenti nel database
	 * @return ArrayList<Agenzia> se la ricerca ha prodotto risultati,null se la ricerca non ha prodotto risultati
	 *@throws DatabaseConnectionException
	 *
	 */
public ArrayList<Agenzia> getAgenzie() {
	ArrayList<Agenzia> result = new ArrayList<Agenzia>();
	String query = "SELECT * FROM Agenzia";
	boolean eseguito= false;
	try{
		Connection connessione = MySqlDaoFactory.getConnection();
		Statement statement =connessione.createStatement();
		ResultSet risultato=statement.executeQuery(query);
		
		Agenzia tmp ;
		while(risultato.next()){
			tmp=new Agenzia(risultato.getInt(1),risultato.getString(2),risultato.getString(3),risultato.getString(4));
			result.add(tmp);
			
			
		}
		eseguito=true;
		
		
	}
	catch(SQLException | DatabaseConnectionException e){
		eseguito=false;
		e.printStackTrace();
		
	}
	
	if(eseguito) return result;
	else return null;
	
	
}
/**
 * Inserisce un'agenzia nel database 
 * @param id l'identificativo dell'agenzia,nome il nome dell'agenzia,indirizzo l'indirizzo dell'agenzia,telefono il numero di telefono dell'agenzia
 * @return true se l'inserimento va a buon fine,false altrimenti
 * @throws DatabaseConnectionException 
 * @throw DatabaseConnectionException
 */
	@Override
	public boolean inserisciAgenzia(int id, String nome, String indirizzo,
			String telefono)  {
		// TODO Auto-generated method stub
	boolean inserito;
	String query="INSERT INTO Agenzia(Identificativo,Nome,Indirizzo,Telefono) " + "VALUES (?,?,?,?);";
	try{
		Connection connessione = MySqlDaoFactory.getConnection();
		PreparedStatement statement =connessione.prepareStatement(query);
		statement.setInt(1, id);
		statement.setString(2, nome);
		statement.setString(3,indirizzo);
		statement.setString(4,telefono);
		statement.executeUpdate();
		
		inserito = true;
		
		
		
	}
		catch(SQLException | DatabaseConnectionException e ){
			
			inserito = false;
			e.printStackTrace();
			
		}
	return inserito;
		
	}
	

	@Override
	/**
	 * Il metodo permette di aggiornare i dati relativi ad un'agenzia;non è possibile modificare 
	 * l'identificativo.
	 * In una prima fase vengono recuperati i dati dell'agenzia che si vogliono modificare,successivamente
	 * analizza le differenze fra i dati passati come argomento e i dati recuperati dal database e quando vi sono
	 * differenze effettua l'aggiornamento.
	 * @param id l'id dell'agenzia,nome il nome dell'agenzia,indirizzo,telefono
	 * @return true se la modifica è avvenuta correttamente,false se la modifica non è avvenuta
	 * @throw DatabaseConnectionException
	 */
	public boolean modificaAgenzia(int id, String nome, String indirizzo,String telefono)  {
		// TODO Auto-generated method stub
		
		String queryAggiornamento="UPDATE Agenzia SET Nome = ' ?' ,Indirizzo = '?' ,Telefono= '?' " + "WHERE Identificativo = " + Integer.toString(id);
		//effettua la connessione al database e modifica i dati
		boolean effettuato = false;
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statementAggiornamento = connessione.prepareStatement(queryAggiornamento);
			statementAggiornamento.setString(1, nome);
			statementAggiornamento.setString(2,indirizzo);
			statementAggiornamento.setString(3, telefono);
			statementAggiornamento.executeUpdate();
			effettuato=true;
			}
			
			
			catch(SQLException | DatabaseConnectionException e){
				effettuato=false;
			
				e.printStackTrace();
				}
			return effettuato;
			}

	@Override
	/**
	 * Elimina un'agenzia dal database
	 * @param id l'id dell'agenzia che si vuole eliminare
	 * @return true se l'operazione va a buon fine,false altrimenti
	 * @throw DatabaseConnectionException();
	 */
	public boolean rimuoviAgenzia(int id)  {
		// TODO Auto-generated method stub
		boolean cancellato = false;
		String query = "DELETE FROM Agenzia WHERE Identificativo = ?";
		try{
			
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement1 = connessione.prepareStatement(query);
			statement1.setInt(1, id);
			statement1.executeUpdate();
			cancellato = true;
			
			
		}
		catch(SQLException | DatabaseConnectionException e){
			e.printStackTrace();
		}
		return cancellato;
		
	}
	public Agenzia getAgenzia(int id){
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Agenzia WHERE Identificativo = ? ";
		Connection connessione;
		Agenzia agenzia = null;
		try {
			connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet risultato = statement.executeQuery();
			risultato.first();
			agenzia = new Agenzia(risultato.getInt("Identificativo"),risultato.getString("Nome"),risultato.getString("Indirizzo"),risultato.getString("Telefono"));
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agenzia;
		
	}
public static void main(String args[]) throws DatabaseConnectionException{
	int id =1;
	String nome="Hertz Carovigno";
	String indirizzo="Via san michele 28/A ";
	String telefono="3474794237";
	MySQLAgenziaDao dao  = new MySQLAgenziaDao();
	boolean inserito = dao.inserisciAgenzia(id, nome, indirizzo, telefono);
	if(inserito){System.out.println("INSERITO");}
	else System.out.println("NON INSERITO");
	ArrayList<Agenzia> tutte = dao.getAgenzie();
	System.out.println(tutte.get(0).getIdentificativo());
	boolean rimosso= dao.rimuoviAgenzia(1);
	if(rimosso) System.out.println("Rimosso");
	else System.out.println("NON rimosso");
	System.out.println("TESTO LA MODIFICA");
	dao.inserisciAgenzia(id, nome, indirizzo, telefono);
	String newName="Hertz Bari";
	boolean modificato = dao.modificaAgenzia(id, newName, indirizzo, telefono);
	tutte = dao.getAgenzie();
	System.out.println(tutte.get(0).getNome());
	
	
}

	
}
