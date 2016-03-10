package dao.mysql;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.LoginDao;
import entity.Operatore;
import exceptions.DatabaseConnectionException;
import exceptions.WrongPasswordException;
import utility.Cifratura;
import utility.Sessione;
import utility.TipoUtente;

public class MySQLLoginDao implements LoginDao{
static String testPassword;
static String myPassword;
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Operatore WHERE Username =?";
		String cf  = null;
		TipoUtente tipo = null;
		Cifratura cifratore = new Cifratura();
		boolean loggato = false;
		String criptata = cifratore.cripta(password);
		String pw = null;
		 try {
			Connection connection = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet risultato = statement.executeQuery();
			risultato.next();
			pw= risultato.getString("Password");
			cf = risultato.getString("CF");
			
			
			if(pw.compareTo(criptata)==0){
				loggato = true;
				
			}
			else throw new WrongPasswordException();
			if(risultato.getBoolean("Amministratore") ==true){
				tipo = TipoUtente.AMMINISTRATORE;
			}
			else tipo=TipoUtente.OPERATORE;
			
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sessione.setUsername(username);
		Sessione.setTipoUtente(tipo);
		Sessione.setCf(cf);
		return loggato;
	}
public static void main(String[] args){
	MySQLLoginDao logindao  = new MySQLLoginDao();
	boolean logged = logindao.login("Espoand", "Andrea");	
	

	System.out.println(Boolean.toString(logged));

}
}
