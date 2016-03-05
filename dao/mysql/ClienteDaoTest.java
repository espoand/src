package dao.mysql;

import entity.Cliente;
import exceptions.DatabaseConnectionException;

public class ClienteDaoTest {

	public static void main(String[] args) throws DatabaseConnectionException{
		// TODO Auto-generated method stub
		MySQLClienteDao test = new MySQLClienteDao();
		test.inserisciCliente("andrea", "esposito", "124", "1234567890123456", "san michele ");
		test.modificaCliente("1234567890123456", "elena", "bottacci", "3333","carovigno");
		Cliente c = test.getCliente("1234567890123456");
		System.out.println(c.getCodiceFiscale() + c.getCognome() + c.getNome());
		test.cancellaCliente("1234567890123456");
	}

}
