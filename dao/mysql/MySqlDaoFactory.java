package dao.mysql;

import java.sql.Connection;

import dao.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import dao.mysql.MySQLAgenziaDao;
import exceptions.DatabaseConnectionException;
/**
 * Classe per le operazioni di comunicazione con il DBMS MySQL
 * @author Andrea Esposito e Mauro De Cesare
 *
 */
public class MySqlDaoFactory extends DaoFactory {
	
//Nome del driver da caricare
public static String DRIVER_NAME="com.mysql.jdbc.Driver";
//DBMS che si sta utilizzando
public static String DBMS = "jdbc:mysql";
//Host del database
public static String HOST = "localhost";
//Nome del database
public static String DATABASE_NAME = "CarloanDB";
//Username per accedere al database
public static String USER_NAME = "root";
//Password per accedere al database
public static String PASSWORD = "Carloan";
static Connection connessione = null;
/**
 * Metodo per effettuare la connessione del database
 * 
 * @return Connection 
 * @throws DatabaseConnectionException 
 * 
 */
public static Connection getConnection() throws DatabaseConnectionException{
	
	
	try{
		Class.forName(DRIVER_NAME);	
	}

	catch(ClassNotFoundException e){
	throw new DatabaseConnectionException(e);
	}
	
	
	try{
		connessione= DriverManager.getConnection((DBMS + "://" + HOST + "/" + DATABASE_NAME),USER_NAME,PASSWORD);
		
	}
	catch(SQLException e){
		throw new DatabaseConnectionException(e);}
	return connessione;
	
	
}
/**
 * Metodo per effettuare la chiusura della connessione con il database
 * 
 * 
 */
public static void chiudiConnessione(){
	try{
		if(connessione!=null && !connessione.isClosed()){
			connessione.close();
		}}
	catch(SQLException e){
		e.printStackTrace();
	}
	}


	@Override
	public AgenziaDao getAgenziaDao() throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		return (AgenziaDao) createDao(MySQLAgenziaDao.class);
	}

	@Override
	
	  public AutoDao getAutoDao() {
	 
		// TODO Auto-generated method stub
		try {
			return (AutoDao) createDao(MySQLAutoDAO.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ClienteDao getClienteDao() {
		// TODO Auto-generated method stub
	try {
		return (ClienteDao) createDao(MySQLClienteDao.class);
	} catch (InstantiationException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	@Override
	public ContrattoDao getContrattoDao() {
		// TODO Auto-generated method stub
		try {
			return (ContrattoDao) createDao(MySQLContrattoDao.class);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FasciaDao getFasciaDao() {
		// TODO Auto-generated method stub
	try {
		return (FasciaDao) createDao(MySQLFasciaDao.class);
	} catch (InstantiationException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}


	

	@Override
	public OperatoreDao getOperatoreDao() {
		// TODO Auto-generated method stub
		try {
			return (OperatoreDao) createDao(MySQLOperatoreDao.class);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public TariffaBaseDao getTariffaBaseDao() {
		// TODO Auto-generated method stub
		try {
			return (TariffaBaseDao) createDao(MySQLTariffaBaseDao.class);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public LoginDao getLoginDao() {
		// TODO Auto-generated method stub
		try {
			return (LoginDao) createDao(MySQLLoginDao.class);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
