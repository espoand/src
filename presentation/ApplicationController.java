package presentation;

import java.util.ArrayList;

import presentation.command.*;

public class ApplicationController implements ApplicationControllerInterface{
ViewDispatcher dispatcher = new ViewDispatcher();
	@Override
	public Object handleRequest(String request) {
		// TODO Auto-generated method stub
		Command command;
		Object risultato = null;
		switch(request){
		case "AggiungiAuto":
			dispatcher.apriView("aggiungiAuto");break;
		case "AggiungiCliente":
			dispatcher.apriView("aggiungiCliente");break;
		case "AggiungiFascia":
			dispatcher.apriView("aggiungiFascia");break;
		case "AggiungiNoleggio":
			dispatcher.apriView("aggiungiNoleggio");break;
		case "AggiungiOperatore":
			dispatcher.apriView("aggiungiOperatore");break;
		case "AggiungiTariffaBase":
			dispatcher.apriView("aggiungiTariffaBase");break;
		
	
		case "GestioneAuto":
			dispatcher.apriView("gestioneAuto");break;
		case "GestioneCliente":
			dispatcher.apriView("gestioneCliente");break;
		case "GestioneFascia":
			dispatcher.apriView("gestioneFascia");break;
		case "GestioneNoleggio":
			dispatcher.apriView("gestioneNoleggio");break;
		case "GestioneOperatore":
			dispatcher.apriView("gestioneOperatore");break;
		case "GestioneTariffaBase":
			dispatcher.apriView("gestioneTariffaBase");break;
		case "ModificaAuto":
			dispatcher.apriView("gestioneAuto");break;
		case "ModificaFascia":
			dispatcher.apriView("modificaFascia");break;
		case "ModificaNoleggio":
			dispatcher.apriView("modificaNoleggio");break;
		case "ModificaOperatore":
			dispatcher.apriView("modificaOperatore");break;
		case "ModificaTariffaBase":
			dispatcher.apriView("modificaTariffaBase");break;
		case "MostraAuto":
			dispatcher.apriView("MostraAuto");break;
		case "MostraCliente":
			dispatcher.apriView("MostraCliente");break;
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
		case "MostraAuto":
			command = new MostraAuto();
			result = command.execute(parameters);break;
	
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

		
		}
		return result;
		
		}


}
