package dao.mysql;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.LoginDao;
import entity.Operatore;
import exceptions.DatabaseConnectionException;
import exceptions.GenericException;
import exceptions.UtenteInesistenteException;
import exceptions.WrongPasswordException;
import utility.Cifratura;
import utility.Sessione;
import utility.TipoUtente;

public class MySQLLoginDao implements LoginDao{

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		String query = "SELECT CF,Nome,Cognome,Username,Password,Amministratore FROM Operatore WHERE Username =?";
		String cf  = null;
		TipoUtente tipo = null;
		
		boolean loggato = false;
		
		String pw = null;
		 try {
			Connection connection = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet risultato = statement.executeQuery();
			
			if(!risultato.next()){ throw new UtenteInesistenteException();}
			
			pw= risultato.getString("Password");
			cf = risultato.getString("CF");
			
			
			if(pw.equalsIgnoreCase(password)){
				loggato = true;
				
			}
			else throw new WrongPasswordException();
			
			if(risultato.getBoolean("Amministratore") ==true){
				tipo = TipoUtente.AMMINISTRATORE;
			}
			else tipo=TipoUtente.OPERATORE;
			statement.close();

		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(username == null){
			 throw new GenericException("Utente inesistente");
		 }
		Sessione.setUsername(username);
		Sessione.setTipoUtente(tipo);
		Sessione.setCf(cf);
		
		return loggato;
	}

}
