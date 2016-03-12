package dao.mysql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import utility.DateConverter;
import dao.AutoDao;
import entity.Auto;
import entity.Fascia;
import exceptions.DatabaseConnectionException;

public class MySQLAutoDAO implements AutoDao{
	public Auto getAuto(String targ){
		return null;
	
}
	@Override
	public boolean inserisciAuto(String targa, String modello, Fascia fascia,
			double ultimoKmtraggio)  {
		// TODO Auto-generated method stub
		boolean inserito= false;
		String query = "INSERT INTO AUTO(Targa,Modello,Fascia,Disponibile,Ultimo_kmtraggio) " + "VALUES (?,?,?,true,?)";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement =connessione.prepareStatement(query);
			statement.setString(1, targa);
			statement.setString(2, modello.toString());
			statement.setString(3, fascia.toString());
			statement.setBigDecimal(4, BigDecimal.valueOf(ultimoKmtraggio));
			statement.executeUpdate();
			inserito = true;
		}
		catch(SQLException | DatabaseConnectionException e){
			inserito = false;
			e.printStackTrace();
			
		}
		return inserito;
	}

	@Override
	public boolean rimuoviAuto(String targa) {
		// TODO Auto-generated method stub
		boolean rimosso = false;
		String query = "DELETE FROM AUTO WHERE Targa = ?";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, targa);
			statement.executeUpdate();
			rimosso = true;
		}
		catch(DatabaseConnectionException | SQLException e){
			rimosso = false;
			e.printStackTrace();
		}
			return rimosso;
	}

	@Override
	public boolean modificaAuto(String targa, double ultimoKm) {
		// TODO Auto-generated method stub
		boolean modificato;
		String query = "UPDATE AUTO SET Ultimo_kmtraggio = ? WHERE Targa = ?";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setDouble(1,ultimoKm);
			statement.setString(2, targa);
			statement.executeUpdate();
			modificato = true;
		}
		catch( DatabaseConnectionException | SQLException e){
			modificato=false;
			e.printStackTrace();
		}
		return modificato;
	}
	
//da finire dopo aver fatto il fasciadao
	//bisognerebbe gestire la ricerca della fascia salvando prima come stringa  e poi andando a ricercare la fascia e ottenerne l'oggetto
	
	@Override
	public ArrayList<Auto> getTutteAuto() {
		// TODO Auto-generated method stub
		MySQLFasciaDao fasciaDao= new MySQLFasciaDao();
		ArrayList<Auto>  tutteAuto= null;
		String query = "SELECT * FROM AUTO";
		
			Connection connessione;
			try {
				connessione = MySqlDaoFactory.getConnection();
				Statement statement = connessione.createStatement();
			ResultSet risultato= statement.executeQuery(query);
			tutteAuto=new ArrayList<Auto>();
			while(risultato.next()){
				
				tutteAuto.add(new Auto(risultato.getString("Targa"),risultato.getString("Modello"),fasciaDao.getFascia(risultato.getString("Fascia")),risultato.getBoolean("Disponibile"),risultato.getDouble("Ultimo_kmtraggio")));
				
			}
			} catch (DatabaseConnectionException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tutteAuto;
		
		
	}

	@Override
	public ArrayList<Auto> getAutoDisponibili() {
		// TODO Auto-generated method stub
	
		MySQLFasciaDao fasciaDao= new MySQLFasciaDao();
		ArrayList<Auto>  autoDisponibili= null;
		String query = "SELECT * FROM AUTO WHERE Disponibile=TRUE";
		
			Connection connessione;
			try {
				connessione = MySqlDaoFactory.getConnection();
				Statement statement = connessione.createStatement();
			ResultSet risultato= statement.executeQuery(query);
			autoDisponibili=new ArrayList<Auto>();
			while(risultato.next()){
				
					autoDisponibili.add(new Auto(risultato.getString("Targa"),risultato.getString("Modello"),fasciaDao.getFascia(risultato.getString("Fascia")),risultato.getBoolean("Disponibile"),risultato.getDouble("Ultimo_kmtraggio")));
				
			}
			} catch (DatabaseConnectionException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return autoDisponibili;
		
		
	}


	public boolean setStato(String targa,boolean disponibile){
		String query = "UPDATE AUTO SET Disponibile = ? WHERE Targa = ?";
		boolean modificato = false;
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, targa);
			statement.setBoolean(0, disponibile);
			statement.setString(2, targa);
			statement.executeUpdate();
			modificato = true;
		}
		catch( DatabaseConnectionException | SQLException e){
			modificato=false;
			e.printStackTrace();
		}
		return modificato;
	}

}
