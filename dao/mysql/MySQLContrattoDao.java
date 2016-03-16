package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import dao.ContrattoDao;
import entity.Agenzia;
import entity.Auto;
import entity.Cliente;
import entity.Contratto;
import entity.TariffaBase;
import exceptions.DatabaseConnectionException;
import utility.DateConverter;

public class MySQLContrattoDao implements ContrattoDao{
DateConverter dateConverter = new DateConverter();
	@Override
	public boolean inserisciContratto(Cliente cliente, LocalDate dataInizio, double acconto,
			LocalDate finePrevista, Agenzia agenziaNoleggio, Agenzia agenziaRestituzione,TariffaBase tariffa,boolean kmIllimitato,double nroKm,Auto auto,double importoTotale) {
		// TODO Auto-generated method stub
		DateConverter dateConverter = new DateConverter();
		boolean inserito = false;
		String query = "INSERT INTO Contratto(Cliente,Data_inizio,Acconto,Fine_prevista,Agenzia_noleggio,Agenzia_restituzione,Tariffa_base,Km_illimitato,Nro_km,Auto_noleggiata,Importo_totale) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, cliente.getCodiceFiscale());
			statement.setDate(2,dateConverter.LocalDateToSQLDate(dataInizio));
			statement.setDouble(3, acconto);
			
			statement.setDate(4, dateConverter.LocalDateToSQLDate(finePrevista));
			statement.setInt(5, agenziaNoleggio.getIdentificativo());
			statement.setInt(6, agenziaRestituzione.getIdentificativo());
			statement.setString(7, tariffa.getNome());
			statement.setBoolean(8, kmIllimitato);
			statement.setDouble(9, nroKm);
			statement.setString(10, auto.getTarga());
			statement.setDouble(11, importoTotale);
			
			

			statement.executeUpdate();
			inserito=true;
			statement.close();

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
	public boolean eliminaContratto(int nroOrdine) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				boolean cancellato = false;
				String query = "DELETE FROM Contratto WHERE Nro_ord = ?";
				try{
					
					Connection connessione = MySqlDaoFactory.getConnection();
					PreparedStatement statement1 = connessione.prepareStatement(query);
					statement1.setInt(1, nroOrdine);
					statement1.executeUpdate();
					cancellato = true;
					statement1.close();

					
				}
				catch(SQLException | DatabaseConnectionException e){
					e.printStackTrace();
				}
				return cancellato;
				
			}
	

	@Override
	public ArrayList<Contratto> getContratti() {
		// TODO Auto-generated method stub
			String query = "SELECT Nro_ord,Cliente,Data_inizio,Acconto,Fine_prevista,Agenzia_noleggio,Agenzia_restituzione,Tariffa_base,Km_illimitato,Nro_km,Auto_noleggiata,Importo_totale,Chiuso FROM Contratto";
			Connection connessione;
			MySQLClienteDao clienteDao =new MySQLClienteDao();
			MySQLAgenziaDao agenziaDao = new MySQLAgenziaDao();
			MySQLTariffaBaseDao tbDao = new MySQLTariffaBaseDao();
			MySQLAutoDAO autoDao= new MySQLAutoDAO();
			ArrayList<Contratto> contratti = null;
			
			try {
				connessione = MySqlDaoFactory.getConnection();
				PreparedStatement statement = connessione.prepareStatement(query);
				ResultSet risultato = statement.executeQuery(query);
				contratti = new ArrayList<Contratto>();
				while(risultato.next()){
					contratti.add(new Contratto(risultato.getInt("Nro_ord"),clienteDao.getCliente(risultato.getString("Cliente")),risultato.getDate("Data_inizio").toLocalDate(),risultato.getDouble("Acconto"),risultato.getDate("Fine_prevista").toLocalDate(),agenziaDao.getAgenzia(risultato.getInt("Agenzia_noleggio")),agenziaDao.getAgenzia(risultato.getInt("Agenzia_restituzione")),tbDao.getTariffaBase(risultato.getString("Tariffa_base")),risultato.getBoolean("Km_illimitato"),risultato.getDouble("Nro_km"),autoDao.getAuto(risultato.getString("Auto_noleggiata")),risultato.getDouble("Importo_totale"),risultato.getBoolean("Chiuso")));
				}
				statement.close();

			} catch (DatabaseConnectionException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return contratti;
	}

	@Override
	public boolean modificaContratto(Cliente cliente,LocalDate dataInizio,double acconto,int nroOrdine,LocalDate finePrevista,Agenzia agenziaNoleggio,Agenzia agenziaRestituzione,TariffaBase tariffaBase,boolean kmIllimitato,double nroKm,Auto autoNoleggiata,double importoTotale) {
		// TODO Auto-generated method stub
		boolean eseguito = false;
		String query ="UPDATE Contratto SET Data_inizio = ?, Acconto = ?, Fine_prevista = ?,Agenzia_noleggio = ?,Agenzia_restituzione = ?,Tariffa_base =?,Km_illimitato = ?,Nro_km = ?,Auto_noleggiata = ?,Importo_totale = ? WHERE Cliente = ? AND Nro_ord = ?";
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setDate(1,dateConverter.LocalDateToSQLDate(dataInizio) );
			statement.setDouble(2, acconto);
			statement.setDate(3, dateConverter.LocalDateToSQLDate(finePrevista));
			statement.setInt(4,agenziaNoleggio.getIdentificativo());
			statement.setInt(5, agenziaRestituzione.getIdentificativo());
			statement.setString(6, tariffaBase.getNome());
			statement.setBoolean(7, kmIllimitato);
			statement.setDouble(8, nroKm);
			statement.setString(9, autoNoleggiata.getTarga());
			statement.setDouble(10, importoTotale);
			statement.setString(11, cliente.getCodiceFiscale());
			statement.setInt(12, nroOrdine);
			
		
			statement.executeUpdate();
			eseguito  = true;
			statement.close();

		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eseguito;
		

	}

	
	

	@Override
	public boolean chiudiContratto(int nroOrdine) {
		// TODO Auto-generated method stub
		boolean eseguito = false;
		String query = "UPDATE Contratto SET Chiuso = TRUE WHERE Nro_ord = ?";
		Connection connessione;
		try {
			connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setInt(1, nroOrdine);
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
	public Contratto getContratto(int nroOrdine) {
		// TODO Auto-generated method stub
		MySQLClienteDao clienteDao = new MySQLClienteDao();
		MySQLAgenziaDao agenziaDao = new MySQLAgenziaDao();
		MySQLTariffaBaseDao tbDao = new MySQLTariffaBaseDao();
		MySQLAutoDAO autoDao = new MySQLAutoDAO();
		Contratto c = null;
		String query = "SELECT Cliente,Nro_ord,Data_inizio,Acconto,Fine_prevista,Agenzia_noleggio,Agenzia_restituzione,Tariffa_base,Km_illimitato,Nro_km,Auto_noleggiata,Importo_totale,Chiuso FROM Contratto WHERE Nro_ord = ?";
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setInt(1, nroOrdine);
			ResultSet risultato = statement.executeQuery();
			risultato.next();
			c = new Contratto(risultato.getInt("Nro_ord"),clienteDao.getCliente(risultato.getString("Cliente")),risultato.getDate("Data_inizio").toLocalDate(),risultato.getDouble("Acconto"),risultato.getDate("Fine_prevista").toLocalDate(),agenziaDao.getAgenzia(risultato.getInt("Agenzia_noleggio")),agenziaDao.getAgenzia(risultato.getInt("Agenzia_restituzione")),tbDao.getTariffaBase(risultato.getString("Tariffa_base")),risultato.getBoolean("Km_illimitato"),risultato.getDouble("Nro_km"),autoDao.getAuto(risultato.getString("Auto_noleggiata")),risultato.getDouble("Importo_totale"),risultato.getBoolean("Chiuso"));
		} catch (DatabaseConnectionException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

}
