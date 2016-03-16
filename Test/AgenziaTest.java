package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.GestisciAgenzia;
import entity.Agenzia;

public class AgenziaTest {
GestisciAgenzia agBu;
	@Before
	public void setUp() throws Exception {
		agBu = new GestisciAgenzia();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserisciAgenzia() {
		
		//agenzia non presente nel database
		ArrayList<String> parametri = new ArrayList<String>();
		parametri.add("1");
		parametri.add("Hertz Ostuni");
		parametri.add("Via indipendenza 15");
		parametri.add("Bari");
		parametri.add("70125");
		parametri.add("0831778990");
		assert(agBu.inserisciAgenzia(parametri) == true);
		
		//provo a reinserire la stessa agenzia
		assert(agBu.inserisciAgenzia(parametri) == false);
		
	}

	@Test
	public void testModificaAgenzia() {
		//modifica un'agenzia che esiste
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
		//provo a modificare un'agenzia che non esiste
		parametri.set(0, "20");
		assert(agBu.modificaAgenzia(parametri) == false);
		
	}
	public void testGetAgenzia(){
		
		ArrayList<String> parametri = new ArrayList<String>();
		parametri.add("1");
		parametri.add("Hertz Ostuni");
		parametri.add("Via indipendenza 15");
		parametri.add("Bari");
		parametri.add("70124");
		parametri.add("0831778990");
		Agenzia agenzia1 = new Agenzia(Integer.parseInt(parametri.get(0)),parametri.get(1),parametri.get(2),parametri.get(3),parametri.get(4),parametri.get(5));
		assertEquals(agenzia1,agBu.getAgenzia("3"));
		 // test del metodo su un'agenzia che non esiste
		assertEquals(agBu.getAgenzia("40"), null);
	}
	@Test
	public void testEliminaAgenzia() {
		//elimino un'agenzia esistente
		assertEquals(agBu.eliminaAgenzia("3"),true);
		assert(agBu.getAgenzia("3") == null);
		
		//provo ad eliminare un'agenzia che non esiste
		assert(agBu.eliminaAgenzia("30") == false);
	}
	

}
