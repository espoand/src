package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.GestisciAuto;
import business.GestisciFascia;
import business.GestisciManutenzione;
import business.GestisciTariffaBase;
import entity.Manutenzione;
import utility.TipoManutenzione;

public class ManutenzioneTest {
GestisciManutenzione gm ;
ArrayList<String> parameters;
GestisciFascia gf ;
GestisciTariffaBase gt;
GestisciAuto ga ;
	@Before
	public void setUp() throws Exception {
		gm = new GestisciManutenzione();
		ga = new GestisciAuto();
		parameters = new ArrayList<String>();
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
		ga.rimuoviAuto("EA111BB");
		gf.eliminaFascia("Self Drive");
		gt.eliminaTariffaBase("SelfDrive");
	}

	@Test
	public void testInserisciManutenzione() {
		parameters = new ArrayList<String>();
		parameters.add("EA111BB");
		parameters.add(LocalDate.now().toString());
		parameters.add(TipoManutenzione.ORDINARIA.toString());
		parameters.add("300.00");
		assert(gm.inserisciManutenzione(parameters) == true);
		parameters = new ArrayList<String>();
		parameters.add("EA111BB");
		parameters.add(LocalDate.now().toString());
		parameters.add(TipoManutenzione.STRAORDINARIA.toString());
		parameters.add("500.00");
		
		assert(gm.inserisciManutenzione(parameters) == true);
		
		parameters = new ArrayList<String>();
		parameters.add("EA111BB");
		parameters.add(LocalDate.now().toString());
		parameters.add("PROGRAMMATA");
		parameters.add("500.00");
		assert(gm.inserisciManutenzione(parameters) == false);
	}

	

	
	
}
