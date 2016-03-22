package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.GestisciTariffaBase;
import entity.TariffaBase;

public class TariffaBaseTest {
GestisciTariffaBase gtb;
ArrayList<String> parameters;
	@Before
	public void setUp() throws Exception {
		gtb = new GestisciTariffaBase();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserisciTariffaBase() {
		parameters = new ArrayList<String>();
		parameters.add("SelfDrive");
		parameters.add("5.0");
		parameters.add("10.0");
		parameters.add("50.0");
		assert(gtb.inserisciTariffaBase(parameters) == true);
		parameters = new ArrayList<String>();
		parameters.add("Test");
		parameters.add("3.0");
		parameters.add("5.0");
		parameters.add("10.0");
		assert(gtb.inserisciTariffaBase(parameters) == true);
		
	}

	@Test
	public void testModificaTariffaBase() {
		parameters = new ArrayList<String>();
		parameters.add("SelfDrive");
		parameters.add("6.0");
		parameters.add("11.0");
		parameters.add("51.0");
		assert(gtb.modificaTariffaBase(parameters) == true);
		parameters = new ArrayList<String>();
		parameters.add("Test");
		parameters.add("4.0");
		parameters.add("6.0");
		parameters.add("11.0");
		assert(gtb.modificaTariffaBase(parameters) == true);
		//modifica una tariffa che non esiste
		parameters = new ArrayList<String>();
		parameters.add("Test3");
		parameters.add("4.0");
		parameters.add("6.0");
		parameters.add("11.0");
		assert(gtb.modificaTariffaBase(parameters) == false);
	}

	

	@Test
	public void testGetTariffaBase() {
		TariffaBase test1 = new TariffaBase("SelfDrive",6.0,11.0,51.0);
		TariffaBase test2 = new TariffaBase("Test",4.0,6.0,11.0);
		assert(test1.compareTo(gtb.getTariffaBase("SelfDrive")) == 0);
		assert(test2.compareTo(gtb.getTariffaBase("Test")) == 0);
		//provo ad ottenere una tariffa che non esiste
		assert(gtb.getTariffaBase("Test3")==  null);
	}
	@Test
	public void testEliminaTariffaBase() {
		assert(gtb.eliminaTariffaBase("SelfDrive") == true);
		assert(gtb.eliminaTariffaBase("Test") == true);
		//provo ad eliminare una tariffa che non esiste
		assert(gtb.eliminaTariffaBase("Test") == true);
	}
}
