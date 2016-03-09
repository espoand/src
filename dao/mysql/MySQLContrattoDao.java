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
import exceptions.DatabaseConnectionException;
import utility.DateConverter;

public class MySQLContrattoDao implements ContrattoDao{
DateConverter dateConverter = new DateConverter();
	@Override
	public boolean inserisciContratto(Cliente cliente, LocalDate dataInizio, double acconto, int nroOrdine,
			LocalDate finePrevista, Agenzia agenziaNoleggio, Agenzia agenziaRestituzione) {
		// TODO Auto-generated method stub
		DateConverter dateConverter = new DateConverter();
		boolean inserito = false;
		String query = "INSERT INTO Contratto(Cliente,Nro_ord,Data_inizio,Acconto,Fine_prevista,Agenzia_noleggio,Agenzia_restituzione) VALUES (?,?,?,?,?,?,?)";
		try {
			Connection connessione = MySqlDaoFactory.getConnection();
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, cliente.getCodiceFiscale());
			statement.setDate(2,dateConverter.LocalDateToSQLDate(dataInizio));
			statement.setDouble(3, acconto);
			statement.setInt(4, nroOrdine);
			statement.setDate(5, dateConverter.LocalDateToSQLDate(finePrevista));
			statement.setInt(6, agenziaNoleggio.getIdentificativo());
			statement.setInt(7, agenziaRestituzione.getIdentificativo());
			

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
					
					
				}
				catch(SQLException | DatabaseConnectionException e){
					e.printStackTrace();
				}
				return cancellato;
				
			}
	

	@Override
	public ArrayList<Contratto> getContratti() {
		// TODO Auto-generated method stub
			String query = "SELECT * FROM Contratto";
			Connection connessione;
			MySQLClienteDao clienteDao =new MySQLClienteDao();
			MySQLAgenziaDao agenziaDao = new MySQLAgenziaDao();
			ArrayList<Contratto> contratti = null;
			
			try {
				connessione = MySqlDaoFactory.getConnection();
				Statement statement = connessione.createStatement();
				ResultSet risultato = statement.executeQuery(query);
				contratti = new ArrayList<Contratto>();
				while(risultato.next()){
					contratti.add(new Contratto(risultato.getInt("Nro_ordine"),clienteDao.getCliente(risultato.getString("Cliente")),risultato.getDate("Data_inizio").toLocalDate(),risultato.getDouble("Acconto"),risultato.getDate("Fine_prevista").toLocalDate(),agenziaDao.getAgenzia(risultato.getInt("Agenzia_noleggio")),agenziaDao.getAgenzia(risultato.getInt("Agenzia_restituzione"))));
				}

			} catch (DatabaseConnectionException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return contratti;
	}

}
