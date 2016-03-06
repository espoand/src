package dao;

import java.util.ArrayList;

import entity.TariffaBase;

public interface TariffaBaseDao {
public boolean inserisciTariffaBase(String nome,double costoAlKm,double costoAlKmExtra,double costoAlGiornoExtra);
public boolean eliminaTariffaBase(String nome);
public TariffaBase getTariffaBase(String nome);
public boolean modificaTariffaBase(String nome,double costoAlKm,double costoAlKmExtra,double costoAlGiornoExtra);
public ArrayList<TariffaBase> getTariffe();

}
