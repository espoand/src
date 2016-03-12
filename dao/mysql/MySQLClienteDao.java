package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dao.ClienteDao;
import entity.Cliente;
import exceptions.DatabaseConnectionException;

public class MySQLClienteDao implements ClienteDao{

	@Override
	public boolean inserisciCliente(String nome, String cognome,
			String telefono, String codiceFiscale, String indirizzo) {
		// TODO Auto-generated method stub
		boolean inserito = false;
		String query = "INSERT INTO Cliente(Codice_fiscale,Nome,Cognome,Telefono,Indirizzo) VALUES (?,?,?,?,?)";
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, codiceFiscale);
			statement.setString(2, nome);
			statement.setString(3, cognome);
			statement.setString(4, telefono);
			statement.setString(5, indirizzo);
			statement.executeUpdate();
			inserito=true;
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inserito;
	}

	@Override
	public boolean cancellaCliente(String codiceFiscale) {
		// TODO Auto-generated method stub
		boolean eliminato = false;
		String query ="DELETE FROM Cliente WHERE Codice_fiscale = ? ";
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, codiceFiscale);
			statement.executeUpdate();
			eliminato = true;
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eliminato;
	}

	@Override
	public boolean modificaCliente(String cf, String nome, String cognome,
			String telefono,String indirizzo) {
		// TODO Auto-generated method stub
		boolean modificato = false;
		String query ="UPDATE Cliente SET Nome = ?,Cognome=?,Telefono=?,Indirizzo=? WHERE Codice_fiscale = ? ";
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, nome);
			statement.setString(2, cognome);
			statement.setString(3, telefono);
			statement.setString(4, indirizzo);
			statement.setString(5, cf);
			statement.executeUpdate();
			modificato = true;
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modificato;
	}

	@Override
	public Cliente getCliente(String cf) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Cliente WHERE Codice_fiscale = ? ";
		Connection connessione;
		Cliente cliente = null;
		try {
			connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, cf);
			ResultSet risultato = statement.executeQuery();
			risultato.first();
			cliente = new Cliente(risultato.getString(2),risultato.getString(3),risultato.getString(4),cf,risultato.getString(5));
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
		
	}

	@Override
	public ArrayList<Cliente> tuttiClienti() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Cliente";
		Connection connessione ;
		ArrayList<Cliente> tuttiClienti = null;
		try {
			connessione = MySqlDaoFactory.getConnection();
			java.sql.Statement statement  = connessione.createStatement();
			ResultSet result = statement.executeQuery(query);
			Cliente c = null;
			
			tuttiClienti = new ArrayList<Cliente>();
			while(result.next()){
				c = new Cliente(result.getString("Codice_fiscale"),result.getString("Nome"),result.getString("Cognome"),result.getString("Telefono"),result.getString("Indirizzo"));
				
			}
			
			
			
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tuttiClienti;
		
	}


}
