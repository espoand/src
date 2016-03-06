package dao.mysql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.TariffaBaseDao;
import entity.Auto;
import entity.TariffaBase;
import exceptions.DatabaseConnectionException;

public class MySQLTariffaBaseDao implements TariffaBaseDao{

	@Override
	public boolean inserisciTariffaBase(String nome, double costoAlKm,
			double costoAlKmExtra, double costoAlGiornoExtra) {
		// TODO Auto-generated method stub
		boolean inserito = false;
		String query = "INSERT INTO TariffaBase(Nome,Costo_al_km,Costo_al_km_extra,Costo_al_giorno_extra) "+ "VALUES (?,?,?,?)";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, nome);
			statement.setBigDecimal(2,BigDecimal.valueOf(costoAlKm));
			statement.setBigDecimal(3,BigDecimal.valueOf(costoAlKmExtra));
			statement.setBigDecimal(2,BigDecimal.valueOf(costoAlGiornoExtra));
			statement.executeUpdate();
			inserito= true;

		}
		catch(DatabaseConnectionException | SQLException e){
				inserito = false;
				e.printStackTrace();
		}
		return inserito;
	}

	@Override
	public boolean eliminaTariffaBase(String nome) {
		// TODO Auto-generated method stub
		boolean eliminato= false;
		String query ="DELETE FROM TariffaBase WHERE Nome = '?'";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, nome);
			eliminato = true;
		}
		catch(DatabaseConnectionException | SQLException e){
			eliminato = false;
			e.printStackTrace();
			
		}
		return eliminato;
	}

	@Override
	public TariffaBase getTariffaBase(String nome) {
		// TODO Auto-generated method stub
		TariffaBase tariffaBase=null;
		String query = "SELECT Nome,Costo_al_km,Costo_al_km_extra,Costo_al_giorno_extra FROM TariffaBase WHERE Nome=?";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			ResultSet risultato = statement.executeQuery();
			tariffaBase = new TariffaBase(risultato.getString(0),risultato.getDouble(1),risultato.getDouble(2),risultato.getDouble(3));
				
		}
		catch(DatabaseConnectionException | SQLException e){
			e.printStackTrace();
		}
		return tariffaBase;
	}

	@Override
	public boolean modificaTariffaBase(String nome, double costoAlKm,
			double costoAlKmExtra, double costoAlGiornoExtra) {
		// TODO Auto-generated method stub
		boolean effettuato = false;
		String query = "UPDATE TariffaBase SET Costo_al_km = ?,Costo_al_km_extra =?,Costo_al_giorno_extra=?   WHERE Nome = ?";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setBigDecimal(1, BigDecimal.valueOf(costoAlKm));
			statement.setBigDecimal(2, BigDecimal.valueOf(costoAlKmExtra));
			statement.setBigDecimal(3, BigDecimal.valueOf(costoAlGiornoExtra));
			statement.executeUpdate();
			effettuato = true;
		}
		catch(SQLException | DatabaseConnectionException e){
			e.printStackTrace();
		}
		return effettuato;
		
	}

	@Override
	public ArrayList<TariffaBase> getTariffe() {
		// TODO Auto-generated method stub
		
		ArrayList<TariffaBase>  tutteTariffe= null;
		String query = "SELECT * FROM TariffaBase";
		
			Connection connessione;
			try {
				connessione = MySqlDaoFactory.getConnection();
				Statement statement = connessione.createStatement();
			ResultSet risultato= statement.executeQuery(query);
			tutteTariffe=new ArrayList<TariffaBase>();
			while(risultato.next()){
				
				tutteTariffe.add(new TariffaBase(risultato.getString("Nome"),risultato.getDouble("Costo_al_km"),risultato.getDouble("Costo_al_giorno_extra"),risultato.getDouble("Costo_al_giorno_extra")));
			}
			} catch (DatabaseConnectionException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tutteTariffe;
		
	}
	

}
