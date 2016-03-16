package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.GestisciAuto;
import business.GestisciFascia;
import business.GestisciTariffaBase;
import entity.Auto;

public class AutoTest {
	GestisciAuto ga ;
	GestisciFascia gf ;
	GestisciTariffaBase gt ;
	ArrayList<String> parameters;
		@Before
		public void setUp() throws Exception {
			ga = new GestisciAuto();
			gf = new GestisciFascia();
			gt = new GestisciTariffaBase();
			parameters = new ArrayList<String>();
			parameters.add("SelfDrive");
			parameters.add("5.0");
			parameters.add("10.0");
			parameters.add("50.0");
			gt.inserisciTariffaBase(parameters);
			parameters = new ArrayList<String>();
			parameters.add("Self Drive");
			parameters.add("Auto che si guidano da sole");
			parameters.add("SelfDrive");
			gf.inserisciFascia(parameters);
			parameters = new ArrayList<String>();
			parameters.add("EA111BB");
			parameters.add("Google Car");
			parameters.add("Self Drive");
			parameters.add("0.0");
			
			
			
		}

		@After
		public void tearDown() throws Exception {
			ga.rimuoviAuto(parameters.get(0));
			gf.eliminaFascia("Self Drive");
			gt.eliminaTariffaBase("SelfDrive");
			
			
		}

	@Test
	public void testInserisciAuto() {
		assertEquals(ga.inserisciAuto(parameters),true);
	}

	/*@Test
	public void testModificaAuto() {
		
	}
*/
	@Test
	public void testRimuoviAuto() {
		assertEquals(ga.rimuoviAuto(parameters.get(0)),true);
	}

	@Test
	public void testGetAuto() {
		ga.inserisciAuto(parameters);
		Auto a1 = new Auto("EA111BB","Google Car",gf.getFascia("Self Drive"),true,0.0);
		Auto a2 = ga.getAuto("EA111BB");
		assertEquals(a1.getTarga(),a2.getTarga());
		assertEquals(a1.getFascia().getIdFascia(),a2.getFascia().getIdFascia());
		assertEquals(a1.getModello(),a2.getModello());
		assertEquals(a1.isDisponibile(),a2.isDisponibile());
		assert(a1.getUltimoKmtraggio() == a2.getUltimoKmtraggio());
	}

	/*@Test
	public void testGetAutoDisponibili() {
		
	}

	@Test
	public void testSetStato() {
	}
*/
}
