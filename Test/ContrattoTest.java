package Test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.GestisciAgenzia;
import business.GestisciAuto;
import business.GestisciCliente;
import business.GestisciContratto;
import business.GestisciFascia;
import business.GestisciTariffaBase;
import entity.Contratto;

public class ContrattoTest {
	GestisciContratto gc ;
	GestisciCliente gcli;
	GestisciTariffaBase gtb ;
	GestisciAuto ga ;
	GestisciAgenzia gag;
	ArrayList<String> parameters;
	@Before
	public void setUp() throws Exception {
		gc = new GestisciContratto();
		gcli = new GestisciCliente();
		gtb = new GestisciTariffaBase();
		ga = new GestisciAuto();
		parameters = new ArrayList<String>();
		parameters.add("ABCDEFGHILMNOPQR");
		parameters.add("Car");
		parameters.add("Loan");
		parameters.add("08888888");
		parameters.add("Via Orabona");
		parameters.add("Bari");
		parameters.add("70125");
		gcli.inserisciCliente(parameters);
		ga = new GestisciAuto();
		GestisciFascia gf = new GestisciFascia();
		GestisciTariffaBase gt = new GestisciTariffaBase();
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
		ga.inserisciAuto(parameters);
		 parameters = new ArrayList<String>();
		parameters.add("1");
		parameters.add("Hertz Ostuni");
		parameters.add("Via indipendenza 15");
		parameters.add("Bari");
		parameters.add("70125");
		parameters.add("0831778990");
		gag = new GestisciAgenzia();
		gag.inserisciAgenzia(parameters);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserisciContratto() {
		parameters = new ArrayList<String>();
		parameters.add("ABCDEFGHILMNOPQR");
		LocalDate data = LocalDate.now();
		parameters.add(data.toString());
		parameters.add("50.0");
		data = LocalDate.of(2016, 04, 12);
		parameters.add(data.toString());
		parameters.add("1");
		parameters.add("1");
		parameters.add("SelfDrive");
		parameters.add(Boolean.toString(false));
		parameters.add(Double.toString(300.00));
		parameters.add("EA111BB");
		try {
			assert(gc.InserisciContratto(parameters) == true);
		} catch (InstantiationException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	

	
}
