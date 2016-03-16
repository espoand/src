package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dao.FasciaDao;
import entity.Agenzia;
import entity.Fascia;
import entity.TariffaBase;
import exceptions.DatabaseConnectionException;

public class MySQLFasciaDao implements FasciaDao{

	@Override
	public boolean inserisciFascia(String idFascia, String descrizioneFascia,
			TariffaBase tariffaFascia) {
		// TODO Auto-generated method stub
		boolean inserito = false;
		String query = "INSERT INTO Fascia(Id_fascia,Descrizione,Tariffa_fascia) "+ "VALUES (?,?,?)";
		try{
			Connection connection = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idFascia);
			statement.setString(2,descrizioneFascia);
			statement.setString(3,tariffaFascia.getNome());
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
	public boolean eliminaFascia(String idFascia) {
		// TODO Auto-generated method stub
		boolean rimosso = false;
		String query = "DELETE FROM Fascia WHERE Id_fascia=?";
		try{
			Connection connection = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idFascia);
			statement.executeUpdate();
			rimosso = true;
		}
		catch(SQLException | DatabaseConnectionException e){
			e.printStackTrace();
		}
		return rimosso;
	}

	@Override
	public boolean modificaFascia(String idFascia, TariffaBase tariffaBase) {
		// TODO Auto-generated method stub
		boolean eseguito = false;
		String query = "UPDATE Fascia SET Tariffa_fascia = ? WHERE Id_fascia = ?";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, tariffaBase.getNome());
			statement.setString(2, idFascia);
			statement.executeUpdate();
			eseguito = true;
			
		}
		catch(SQLException | DatabaseConnectionException e){ 
			e.printStackTrace();
		}
		return eseguito;
	}

	@Override
	public ArrayList<Fascia> getFasce() {
		// TODO Auto-generated method stub
		MySQLTariffaBaseDao tbDao=new MySQLTariffaBaseDao();
		String query = "SELECT Id_fascia,Descrizione,Tariffa_fascia FROM Fascia";
		ArrayList<Fascia> tutteFasce= null;
		try {
			Connection connessione =MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			ResultSet risultato = statement.executeQuery(query);
			tutteFasce= new ArrayList<Fascia>();
			while(risultato.next()){
				
				tutteFasce.add(new Fascia(risultato.getString("Id_fascia"),risultato.getString("Descrizione"),tbDao.getTariffaBase(risultato.getString("Tariffa_fascia"))));
			}
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tutteFasce;
		
	}
public Fascia getFascia(String idFascia){
	MySQLTariffaBaseDao tbDao=new MySQLTariffaBaseDao();
	String query = "SELECT Id_fascia,Descrizione,Tariffa_fascia FROM Fascia WHERE Id_fascia = ? ";
	Connection connessione;
	Fascia fascia = null;
	try {
		connessione = MySqlDaoFactory.getConnection();
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, idFascia);
		ResultSet risultato = statement.executeQuery();
		risultato.first();
		
		fascia = new Fascia(risultato.getString("Id_fascia"),risultato.getString("Descrizione"),tbDao.getTariffaBase(risultato.getString("Tariffa_fascia")));
		statement.close();

	} catch (DatabaseConnectionException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return fascia;
}
}
