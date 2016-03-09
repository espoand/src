package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import entity.Agenzia;
import entity.Cliente;
import entity.Contratto;

public interface ContrattoDao {
public boolean inserisciContratto(Cliente cliente,LocalDate dataInizio,double acconto,int nroOrdine,LocalDate finePrevista,Agenzia agenziaNoleggio,Agenzia agenziaRestituzione);
public boolean eliminaContratto(int nroOrdine);
public ArrayList<Contratto> getContratti();
}
