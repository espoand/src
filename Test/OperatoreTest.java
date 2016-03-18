package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.GestisciOperatore;
import entity.Operatore;

public class OperatoreTest {
GestisciOperatore go ;
ArrayList<String> parameters;
	@Before
	public void setUp() throws Exception {
		go = new GestisciOperatore();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserisciOperatore() {
		//inserisco un operatore
		parameters = new ArrayList<String>();
		parameters.add("1234567890123456");
		parameters.add("Admin");
		parameters.add("Admin");
		parameters.add("admin");
		parameters.add("21232f297a57a5a743894a0e4a801fc3");
		parameters.add(Boolean.toString(false));
		assert(go.inserisciOperatore(parameters) == true);
		
		//inserisco un amministratore
		parameters = new ArrayList<String>();
		parameters.add("2345678901234567");
		parameters.add("Admin2");
		parameters.add("Admin2");
		parameters.add("admin2");
		parameters.add("21232f297a57a5a743894a0e4a801fc3");
		parameters.add(Boolean.toString(false));
		assert(go.inserisciOperatore(parameters) == true);
		assert(go.getOperatore("2345678901234567").isAmministratore() == true);
		//provo ad inserire un operatore che già esiste
		assert(go.inserisciOperatore(parameters) == false);

	}
	@Test
	public void testGetOperatore() {
		Operatore op1 = new Operatore("1234567890123456","Admin","Admin","admin","21232f297a57a5a743894a0e4a801fc3",false);
		Operatore op2 = new Operatore("2345678901234567","Admin2","Admin2","admin2","21232f297a57a5a743894a0e4a801fc3",true);
		assert(op1.compareTo(go.getOperatore("1234567890123456")) == 0);
		assert(op2.compareTo(go.getOperatore("2345678901234567")) == 0);
		
		//provo a cercare un operatore che non esiste
		
		assert(go.getOperatore("inesistente") == null);
	}
	@Test
	public void testCancellaOperatore() {
		
		assert(go.cancellaOperatore("2345678901234567")== true);
		assert(go.cancellaOperatore("1234567890123456") == true);
		//provo a cancellare un operatore che non esiste
		assert(go.cancellaOperatore("inesistente") == false);
	}

	

}
