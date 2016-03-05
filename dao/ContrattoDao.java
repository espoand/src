package dao;

import java.util.ArrayList;
import java.util.Date;

import entity.Agenzia;
import entity.Cliente;
import entity.Contratto;

public interface ContrattoDao {
public boolean inserisciContratto(Cliente cliente,Date dataInizio,double acconto,int nroOrdine,Date finePrevista,Agenzia agenziaNoleggio,Agenzia agenziaRestituzione);
public boolean eliminaContratto(int nroOrdine);
public ArrayList<Contratto> getContratti();
}
