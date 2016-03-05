package dao;

import java.util.ArrayList;

import entity.Fascia;
import entity.TariffaBase;

public  interface  FasciaDao {
public boolean inserisciFascia(String idFascia,String descrizioneFascia,TariffaBase tariffaFascia);
public boolean eliminaFascia(String idFascia);
public boolean modificaFascia(String idFascia,TariffaBase tariffaBase);
public ArrayList<Fascia> getFasce();
public Fascia getFascia(String idFascia);
}
