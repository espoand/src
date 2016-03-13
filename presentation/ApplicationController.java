package presentation;

import java.util.ArrayList;

import business.GestisciAuto;
import presentation.command.*;
import utility.Sessione;
import utility.TipoUtente;

public class ApplicationController implements ApplicationControllerInterface{
ViewDispatcher dispatcher = new ViewDispatcher();

	@Override
	public Object handleRequest(String request) {
		// TODO Auto-generated method stub
		Command command;
		Object risultato = null;
		switch(request){
		case "Home":
		dispatcher.home();
			break;
		case "AggiungiAuto":
			dispatcher.apriView("aggiungiAuto");break;
		case "AggiungiCliente":
			dispatcher.apriView("aggiungiCliente");break;
		case "AggiungiFascia":
			dispatcher.apriView("aggiungiFascia");break;
		case "AggiungiManutenzione":
			dispatcher.apriView("aggiungiManutenzione");break;
		case "AggiungiOperatore":
			dispatcher.apriView("aggiungiOperatore");break;
		case "AggiungiTariffaBase":
			dispatcher.apriView("aggiungiTariffaBase");break;
		case "AggiungiContratto":
			dispatcher.apriView("aggiungiContratto");break;
		case "AggiungiAgenzia":
			dispatcher.apriView("aggiungiAgenzia");break;
		case "GestioneManutenzione":
			dispatcher.apriView("gestioneManutenzione");break;
	
		case "GestioneAuto":
			dispatcher.apriView("gestioneAuto");break;
		case "GestioneCliente":
			dispatcher.apriView("gestioneCliente");break;
		case "GestioneContratto":
			dispatcher.apriView("gestioneContratto");break;
		case "GestioneFascia":
			dispatcher.apriView("gestioneFascia");break;
		case "GestioneAgenzia":
			dispatcher.apriView("gestioneAgenzia");break;
		case "GestioneOperatore":
			dispatcher.apriView("gestioneOperatore");break;
		case "GestioneTariffaBase":
			dispatcher.apriView("gestioneTariffaBase");break;
		case "ModificaAuto":
			dispatcher.apriView("modificaAuto");break;
		case "ModificaAgenzia":
			dispatcher.apriView("modificaAgenzia");break;
		case "ModificaContratto":
			dispatcher.apriView("modificaContratto");break;
		case "ModificaFascia":
			dispatcher.apriView("modificaFascia");break;
		
		case "ModificaOperatore":
			dispatcher.apriView("modificaOperatore");break;
		case "ModificaTariffaBase":
			dispatcher.apriView("modificaTariffaBase");break;
		case "MostraAgenzia":
			dispatcher.apriView("mostraAgenzia");break;
		case "MostraAuto":
			dispatcher.apriView("mostraAuto");break;
		case "MostraCliente":
			dispatcher.apriView("mostraCliente");break;
		
		case "MostraTariffaBase":
			dispatcher.apriView("mostraTariffaBase");break;
		case "MostraOperatore":
			dispatcher.apriView("mostraOperatore");break;
		case "SchermataAmministratore":
			dispatcher.apriView("SchermataAmministratore");break;
		case "SchermataOperatore":
			dispatcher.apriView("SchermataOperatore");break;
		case "Login":
			dispatcher.apriView("Login");break;
		case "TutteTariffe":
			command = new TutteTariffe();
			risultato = command.execute("");break;
		case "TutteAgenzie":
			command = new TutteAgenzie();
			risultato = command.execute("");break;
		case "TuttiClienti":
			command = new TuttiClienti();
			risultato = command.execute("");break;
		case "TutteAuto":
			command = new TutteAuto();
			risultato = command.execute("");break;
		case "TuttiContratti":
			command = new TuttiContratti();
			risultato = command.execute("");break;
		case "TutteFasce":
			command = new TutteFasce();
			risultato = command.execute("");break;
		
		}
		return risultato;
	}
	@Override
	public Object handleRequest(String request, ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		Object result = null;
		Command command;
		switch(request){
		case "Login":
			command = new Login();
			result = command.execute(parameters);break;
		case "InserisciAgenzia" :
			command = new InserisciAgenzia();
			result = command.execute(parameters);break;
		
		case "InserisciAuto":
			command = new InserisciAuto();
			result= command.execute(parameters);break;
		
	
		case "CercaAuto":
			command = new CercaAuto();
			result = command.execute(parameters.get(0));break;
			
		case "RimuoviAuto":
			command = new RimuoviAuto();
			result = command.execute(parameters.get(0));break;
		case "CercaCliente":
			command = new CercaCliente();
			result = command.execute(parameters.get(0));break;
		case "RimuoviCliente":
			command = new RimuoviCliente();
			result = command.execute(parameters.get(0));break;
			
		case "CercaAgenzia":
			command = new CercaAgenzia();
			result = command.execute(parameters.get(0));break;
		case "InserisciContratto":
			command = new InserisciContratto();
			result = command.execute(parameters);break;
		case "RimuoviFascia":
			command = new RimuoviFascia();
			result = command.execute(parameters.get(0));break;
		case "ModificaAuto":
			command = new ModificaAuto();
			result = command.execute(parameters);
		
		case "CercaOperatore":
			command = new CercaOperatore();
			result = command.execute(parameters.get(0));break;
		case "CercaTariffaBase":
			command = new CercaTariffaBase();
			result = command.execute(parameters.get(0));break;
		case "ModificaFascia":
			command = new ModificaFascia();
			result = command.execute(parameters);break;
		
		case "ModificaTariffaBase":
			command = new ModificaTariffaBase();
			result = command.execute(parameters);break;
		case "CercaContratto":
			command = new CercaContratto();
			result = command.execute(parameters.get(0));break;
		case "RimuoviContratto":
			command = new RimuoviContratto();
			result = command.execute(parameters.get(0));break;
		case "ChiudiContratto":
			command = new ChiudiContratto();
			result = command.execute(parameters.get(0));break;
		case "InserisciCliente":
			command = new InserisciCliente();
			result = command.execute(parameters);break;
		
		case "RimuoviAgenzia":
			command = new RimuoviAgenzia();
			result = command.execute(parameters.get(0));break;
		case "ModificaAgenzia":
			command = new ModificaAgenzia();
			result = command.execute(parameters);break;
		case "AggiungiManutenzione":
			command = new AggiungiManutenzione();
			result = command.execute(parameters);break;
		case "AggiungiOperatore":
			command = new InserisciOperatore();
			result = command.execute(parameters);break;
		}
		return result;
		
		}


}
