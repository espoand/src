package dao.mysql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import dao.ManutenzioneDao;
import entity.Auto;
import entity.Manutenzione;
import exceptions.DatabaseConnectionException;
import utility.DateConverter;
import utility.TipoManutenzione;

public class MySQLManutenzioneDao implements ManutenzioneDao{

	@Override
	public boolean inserisciManutenzione(Auto auto, LocalDate data, TipoManutenzione tipo, double costo) {
		// TODO Auto-generated method stub
		boolean aggiunto = false;
		DateConverter dateC = new DateConverter();
		String query = "INSERT INTO Manutenzione(Targa,Data,Costo,Tipo) " + "VALUES (?,?,?,?)";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, auto.getTarga());
			statement.setDate(2,dateC.LocalDateToSQLDate(data));
			statement.setBigDecimal(3,BigDecimal.valueOf(costo));
			statement.executeUpdate();
			aggiunto = true;
			
		}
		catch(SQLException | DatabaseConnectionException e){
			aggiunto = false;
			e.printStackTrace();
		}
		return aggiunto;
	}

	@Override
	public Manutenzione getManutenzione(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT (Id,Targa,Data,Costo,Tipo) FROM Manutenzione WHERE Id= ?";
		MySQLAutoDAO autoDao = new MySQLAutoDAO();
		Connection connessione;
		try {
			connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet risultato = statement.executeQuery();
			risultato.next();
			return new Manutenzione(risultato.getInt("Id"),autoDao.getAuto(risultato.getString("Targa")),risultato.getDate("Data").toLocalDate(),(TipoManutenzione)risultato.getObject("Tipo"),risultato.getDouble("Costo"));
			
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean eliminaManutenzione(int id) {
		// TODO Auto-generated method stub
		boolean eseguito = false;
		String query = "DELETE FROM Manutenzione WHERE Id= ?";
		
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
		PreparedStatement statement;
			statement = connessione.prepareStatement(query);
			statement.setInt(0, id);
		statement.executeUpdate();
		eseguito = true;
		} catch (SQLException | DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eseguito;

	}

	@Override
	public ArrayList<Manutenzione> getManutenzioni() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Manutenzione";
		ArrayList<Manutenzione> tutteManutenzioni = null;
		MySQLAutoDAO autoDao = new MySQLAutoDAO();
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			java.sql.Statement statement = connessione.createStatement();
			ResultSet risultato = statement.executeQuery(query);
			tutteManutenzioni = new ArrayList<Manutenzione>();
			
			while(risultato.next()){}
			tutteManutenzioni.add(new Manutenzione(risultato.getInt("Id"),autoDao.getAuto(risultato.getString("Targa")),risultato.getDate("Data").toLocalDate(),(TipoManutenzione)risultato.getObject("Tipo"),risultato.getDouble("Costo")));
		}
		catch(SQLException | DatabaseConnectionException e){
			
		}
		return tutteManutenzioni;
	}

}
