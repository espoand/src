package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

import dao.OperatoreDao;
import entity.Operatore;
import exceptions.DatabaseConnectionException;

public class MySQLOperatoreDao implements OperatoreDao{

	@Override
	public boolean inserisciOperatore(String cf, String nome, String cognome, String username, String password,
			boolean amministratore) {
		// TODO Auto-generated method stub
		boolean inserito = false;
		String query = "INSERT INTO Operatore(CF,Nome,Cognome,Username,Password,Amministratore) VALUES (?,?,?,?,?,?)";
		try {
			java.sql.Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, cf);
			statement.setString(2, nome);
			statement.setString(3, cognome);
			statement.setString(4, username);
			statement.setString(5, password);
			statement.setBoolean(6, amministratore);
			
			statement.executeUpdate();
			inserito = true;
			statement.close();

		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inserito;
	}

	@Override
	public boolean cancellaOperatore(String cf) {
		// TODO Auto-generated method stub
		boolean eseguito = false;
		String query = "DELETE FROM Operatore WHERE CF= ?";
		Connection connessione;
		try {
			connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, cf);
			statement.executeUpdate();
			eseguito = true;
			statement.close();

		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return eseguito;
		
		
	}

	@Override
	public Operatore getOperatore(String cf)  {
		// TODO Auto-generated method stub
		String query = "SELECT CF,Nome,Cognome,Username,Password,Amministratore FROM Operatore WHERE CF= ?";
		Operatore operatore = null;
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, cf);
			ResultSet risultato = statement.executeQuery();
			risultato.next();
			operatore = new Operatore(cf,risultato.getString("Nome"),risultato.getString("Cognome"),risultato.getString("Username"),risultato.getString("Password"),risultato.getBoolean("Amministratore"));
			statement.close();

		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operatore;
	}

	@Override
	public ArrayList<Operatore> getOperatori() {
		// TODO Auto-generated method stub
		String query = "SELECT CF,Nome,Cognome,Username,Password,Amministratore FROM Operatore";
		ArrayList<Operatore> tuttiOperatori = null;
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			ResultSet risultato = statement.executeQuery();
			tuttiOperatori = new ArrayList<Operatore>();
			while(risultato.next()){
				tuttiOperatori.add(new Operatore(risultato.getString("CF"),risultato.getString("Nome"),risultato.getString("Cognome"),risultato.getString("Username")," ",risultato.getBoolean("Amministratore")));
				
			}
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tuttiOperatori;
	}

}
