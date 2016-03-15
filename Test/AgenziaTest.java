package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.GestisciAgenzia;
import entity.Agenzia;

public class AgenziaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserisciAgenzia() {
		GestisciAgenzia agBu = new GestisciAgenzia();

		ArrayList<String> parametri = new ArrayList<String>();
		parametri.add("1");
		parametri.add("Hertz Ostuni");
		parametri.add("Via indipendenza 15");
		parametri.add("Bari");
		parametri.add("70125");
		parametri.add("0831778990");
		Agenzia a = new Agenzia(Integer.parseInt(parametri.get(0)),parametri.get(1),parametri.get(2),parametri.get(3),parametri.get(4),parametri.get(5));
		assertEquals(agBu.inserisciAgenzia(parametri),true);
		
		//numero di telefono un pò più lungo del limite
		parametri = new ArrayList<String>();
		parametri.add("1");
		parametri.add("Hertz Ostuni");
		parametri.add("Via indipendenza 15");
		parametri.add("Bari");
		parametri.add("70125");
		parametri.add("0831747333338990");
		assertEquals(agBu.inserisciAgenzia(parametri),false);
		
	}

	@Test
	public void testModificaAgenzia() {
		GestisciAgenzia agBu = new GestisciAgenzia();

		ArrayList<String> parametri = new ArrayList<String>();
		parametri.add("1");
		parametri.add("Hertz Ostuni");
		parametri.add("Via indipendenza 15");
		parametri.add("Bari");
		parametri.add("70124");
		parametri.add("0831778990");
		Agenzia a = new Agenzia(Integer.parseInt(parametri.get(0)),parametri.get(1),parametri.get(2),parametri.get(3),parametri.get(4),parametri.get(5));

		assertEquals(agBu.modificaAgenzia(parametri),true);
		assert(agBu.getAgenzia(parametri.get(0)).getCap() != a.getCap());
		
		
	}

	@Test
	public void testEliminaAgenzia() {
		GestisciAgenzia agBu = new GestisciAgenzia();
		assertEquals(agBu.eliminaAgenzia("3"),true);
		assert(agBu.getAgenzia("3") == null);
	}

}
