package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.GestisciFascia;
import business.GestisciTariffaBase;
import entity.Fascia;

public class FasciaTest {
GestisciFascia gf;
GestisciTariffaBase gtb;
ArrayList<String> parameters;
	@Before
	public void setUp() throws Exception {
		gf = new GestisciFascia();
		gtb = new GestisciTariffaBase();
		parameters = new ArrayList<String>();
		parameters.add("SelfDrive");
		parameters.add("5.0");
		parameters.add("10.0");
		parameters.add("50.0");
		gtb.inserisciTariffaBase(parameters);
		parameters = new ArrayList<String>();
		parameters.add("Test");
		parameters.add("3.0");
		parameters.add("5.0");
		parameters.add("10.0");
		gtb.inserisciTariffaBase(parameters);
	}

	@After
	public void tearDown() throws Exception {
		gtb.eliminaTariffaBase("SelfDrive");
		
	}

	@Test
	public void testInserisciFascia() {
		parameters = new ArrayList<String>();
		parameters.add("TEST1");
		parameters.add("Fascia di test 1");
		parameters.add("SelfDrive");
		assert(gf.inserisciFascia(parameters) == true);
		parameters = new ArrayList<String>();
		parameters.add("TEST2");
		parameters.add("Fascia di test 2");
		parameters.add("Test");
		assert(gf.inserisciFascia(parameters) == true);
		
		//provo ad inserire la stessa fascia un'altra volta
		assert(gf.inserisciFascia(parameters) == false);

		
	}

	@Test
	public void testModificaFascia() {
		
		parameters = new ArrayList<String>();
		parameters.add("TEST1");
		parameters.add("Fascia di test 1");
		parameters.add("Test");
		assert(gf.modificaFascia(parameters) == true);
		parameters = new ArrayList<String>();
		parameters.add("TEST2");
		parameters.add("Fascia di test 2");
		parameters.add("SelfDrive");
		assert(gf.modificaFascia(parameters) == true);
		//modifico una fascia che non esiste
		parameters = new ArrayList<String>();
		parameters.add("TEST3");
		parameters.add("Fascia di test 2");
		parameters.add("SelfDrive");
		assert(gf.modificaFascia(parameters)== false);
		
	}

	@Test
	public void testGetFascia() {
		Fascia test1 = new Fascia("TEST1","Fascia di test 1",gtb.getTariffaBase("Test"));
		Fascia test2 = new Fascia("TEST2","Fascia di test2",gtb.getTariffaBase("SelfDrive"));
		assert(test1.compareTo(gf.getFascia("TEST1")) == 0);
		assert(test2.compareTo(gf.getFascia("TEST2")) == 0);
		//provo ad ottenere una fascia che non esiste
		assert(gf.getFascia("Test3") == null);
	}

	@Test
	public void testEliminaFascia() {
		assert(gf.eliminaFascia("TEST1") == true);
		assert(gf.eliminaFascia("TEST2") == true);
		//fascia che non esiste
		assert(gf.eliminaFascia("TEST3") == false);
	}

}
