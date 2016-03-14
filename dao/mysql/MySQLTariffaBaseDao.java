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
			statement.setDouble(2,costoAlKm);
			statement.setDouble(3,costoAlKmExtra);
			statement.setDouble(4,costoAlGiornoExtra);
			statement.executeUpdate();
			inserito= true;
			statement.close();

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
		String query ="DELETE FROM TariffaBase WHERE Nome = ?";
		try{
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, nome);
			statement.executeUpdate();
			eliminato = true;
			statement.close();

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
			statement.setString(1, nome);
			ResultSet risultato = statement.executeQuery();
			risultato.next();
			tariffaBase = new TariffaBase(risultato.getString(1),risultato.getDouble(2),risultato.getDouble(3),risultato.getDouble(4));
			statement.close();

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
			statement.setString(4, nome);
			statement.executeUpdate();
			effettuato = true;
			statement.close();

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
		String query = "SELECT Nome,Costo_al_km,Costo_al_km_extra,Costo_al_giorno_extra FROM TariffaBase";
		
			Connection connessione;
			try {
				connessione = MySqlDaoFactory.getConnection();
				PreparedStatement statement = connessione.prepareStatement(query);
			ResultSet risultato= statement.executeQuery(query);
			tutteTariffe=new ArrayList<TariffaBase>();
			while(risultato.next()){
				
				tutteTariffe.add(new TariffaBase(risultato.getString("Nome"),risultato.getDouble("Costo_al_km"),risultato.getDouble("Costo_al_giorno_extra"),risultato.getDouble("Costo_al_giorno_extra")));
			}
			statement.close();

			} catch (DatabaseConnectionException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tutteTariffe;
		
	}
	

}
