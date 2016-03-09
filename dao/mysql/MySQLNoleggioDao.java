package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import dao.NoleggioDao;
import entity.Auto;
import entity.Noleggio;
import entity.TariffaBase;
import exceptions.DatabaseConnectionException;
import utility.DateConverter;

public class MySQLNoleggioDao implements NoleggioDao{
DateConverter dateConverter = new DateConverter();
	@Override
	public boolean inserisciNoleggio(int nroOrdine, TariffaBase tariffaBase, boolean kmIllimitato, double nroKm,
			Auto autoNoleggiata, LocalDate dataEffettivaRiconsegna, double importoTotale) {
		// TODO Auto-generated method stub
		boolean eseguito = false;
		String query = "INSERT INTO Noleggio(Nro_ordine,TariffaBase,Km_illimitato,Nro_km,Auto_noleggiata,Data_effettiva_riconsegna,Importo_totale) "+ "VALUES(?,?,?,?,?,?,?)";
		
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setInt(1, nroOrdine);
			statement.setString(2, tariffaBase.getNome());
			statement.setBoolean(3, kmIllimitato);
			statement.setDouble(4, nroKm);
			statement.setString(5, autoNoleggiata.getTarga());
			statement.setDate(6,dateConverter.LocalDateToSQLDate(dataEffettivaRiconsegna) );
			statement.setDouble(7, importoTotale);
			statement.executeUpdate();
			eseguito=true;
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eseguito;
	}

	@Override
	public boolean cancellaNoleggio(int nroOrdine) {
		// TODO Auto-generated method stub
		boolean eseguito = false;
		String query= "DELETE FROM Noleggio WHERE Nro_ordine = ?";
		Connection connessione;
		try {
			connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setInt(1, nroOrdine);
			statement.executeQuery();
			eseguito = true;
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eseguito;
	}

	@Override
	public Noleggio getNoleggio(int nroOrdine) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Noleggio WHERE Nro_ordine =?";
		MySQLTariffaBaseDao tbDao = new MySQLTariffaBaseDao();
		MySQLAutoDAO autoDao = new MySQLAutoDAO();
		Noleggio noleggioResult = null;
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement  = connessione.prepareStatement(query);
			statement.setInt(1, nroOrdine);
			ResultSet risultato = statement.executeQuery();
			risultato.next();
			TariffaBase tariffa = tbDao.getTariffaBase(risultato.getString("Tariffa_base"));
			Auto auto = autoDao.getAuto(risultato.getString("Auto_noleggiata"));
			noleggioResult = new Noleggio(risultato.getInt("Nro_ordine"),tariffa,risultato.getBoolean("Km_illimitato"),risultato.getDouble("Nro_km"),auto,risultato.getDate("Data_effettiva_riconsegna").toLocalDate(),risultato.getDouble("Importo_totale"));
			
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noleggioResult;
	}

	@Override
	public boolean modificaNoleggio(int nroOrdine, TariffaBase tariffaBase, boolean kmIllimitato, double nroKm,
			Auto autoNoleggiata, LocalDate dataEffettivaRiconsegna, double importoTotale) {
		// TODO Auto-generated method stub
		boolean eseguito = false;
		String query = "UPDATE Noleggio SET Tariffa_base = ?,Km_illmitato= ? ,Auto_noleggiata=?,Data_effettiva_riconsegna=?,Importo_totale = ? WHERE Nro_ordine = ?";
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, tariffaBase.getNome());
			statement.setBoolean(2, kmIllimitato);
			statement.setDouble(3,nroKm);
			statement.setString(4, autoNoleggiata.getTarga());
			statement.setDate(5, dateConverter.LocalDateToSQLDate(dataEffettivaRiconsegna));
			statement.setDouble(6, importoTotale);
			statement.executeUpdate();
			eseguito = true;
			
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return eseguito;
		
	}

	@Override
	public ArrayList<Noleggio> getNoleggi() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Noleggio";
		Connection connessione;
		ArrayList<Noleggio> noleggi = null;
		MySQLTariffaBaseDao tbDao = new MySQLTariffaBaseDao();
		MySQLAutoDAO autoDao = new MySQLAutoDAO();
		try {
			connessione = MySqlDaoFactory.getConnection();
			Statement statement = connessione.createStatement();
			ResultSet risultato = statement.executeQuery(query);
			noleggi = new ArrayList<Noleggio>();
			Auto auto; 
			TariffaBase tariffa;
			while(risultato.next()){
				noleggi.add(new Noleggio(risultato.getInt("Nro_ordine"),tbDao.getTariffaBase(risultato.getString("Tariffa_base")),risultato.getBoolean("Km_illimitato"),risultato.getDouble("Nro_km"),autoDao.getAuto(risultato.getString("Auto_noleggiata")),risultato.getDate("Data_effettiva_riconsegna").toLocalDate(),risultato.getDouble("Importo_totale")));
			}
			
		
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return noleggi;
	}

}
