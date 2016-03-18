package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.GestisciCliente;
import entity.Cliente;

public class ClienteTest {
GestisciCliente gc;
ArrayList<String> parameters;

	@Before
	public void setUp() throws Exception {
		gc = new GestisciCliente();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testInserisciCliente() {
		parameters = new ArrayList<String>();
		parameters.add("ABCDEFGHILMNOPQR");
		parameters.add("Car");
		parameters.add("Loan");
		parameters.add("08888888");
		parameters.add("Via Orabona");
		parameters.add("Bari");
		parameters.add("70125");
		assert(gc.inserisciCliente(parameters) == true);
		
		//provo a reinserire lo stesso cliente
		assert(gc.inserisciCliente(parameters) == false);

	}

	@Test
	public void testModificaCliente() {
		parameters = new ArrayList<String>();
		parameters.add("ABCDEFGHILMNOPQR");
		parameters.add("Ingegneria");
		parameters.add("Loan");
		parameters.add("08888888");
		parameters.add("Via Orabona");
		parameters.add("Bari");
		parameters.add("70125");
		assert(gc.modificaCliente(parameters) == true);
		
		//provo a modificare un cliente che non esiste
		parameters = new ArrayList<String>();
		parameters.add("ABCDEFGHILMNOP12");
		parameters.add("Ingegneria");
		parameters.add("Loan");
		parameters.add("08888888");
		parameters.add("Via Orabona");
		parameters.add("Bari");
		parameters.add("70125");
		assert(gc.modificaCliente(parameters) == false);
	}

	

	@Test
	public void testGetCliente() {
		Cliente cliente1 = new Cliente("ABCDEFGHILMNOPQR","Ingegneria","Loan","08888888","Via Orabona","Bari","70125");
		assert(cliente1.compareTo(gc.getCliente("ABCDEFGHILMNOPQR")) == 0);
		
		//provo ad ottenere un cliente che non esiste nel database
		assert(gc.getCliente("1234") == null);
	}
	@Test
	public void testRimuoviCliente() {
		assert(gc.rimuoviCliente("ABCDEFGHILMNOPQR") == true);
		
		//provo a rimuovere un cliente che non esiste
		assert(gc.rimuoviCliente("ABCDEFGHILMNOPQR") == false);

	}
}
