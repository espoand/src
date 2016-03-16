package business.bo;

import java.time.LocalDate;
import java.util.ArrayList;

import dao.DaoFactory;
import dao.ManutenzioneDao;
import entity.Auto;
import entity.Manutenzione;
import utility.TipoManutenzione;

public class ManutenzioneBusiness {
	private static ManutenzioneDao manutenzioneDao =null;
	public ManutenzioneBusiness(){
		manutenzioneDao=  DaoFactory.getDaoFactory(DaoFactory.MySQL).getManutenzioneDao();
	}
	/**
	 * Inserisce i dati riguardanti la manutenzione straordinaria o ordinaria
	 * @param a l'auto su cui è stata effettuata la manutenzione
	 * @param data la data in cui è stato eseguito l'intervento
	 * @param costo il costo sostenuto
	 * @param tipo se la manutenzione è ordinaria o straordinaria
	 * 
	 * @return true se l'inserimento va a buon fine,altrimenti false
	 */
	public boolean inserisciManutenzione(Manutenzione m){
		return manutenzioneDao.inserisciManutenzione(m.getAuto(), m.getData(),m.getTipoManutenzione(), m.getCosto());
	}
	public Manutenzione getManutenzione(int id){
		return manutenzioneDao.getManutenzione(id);
	}
	public boolean eliminaManutenzione(int id){
		return manutenzioneDao.eliminaManutenzione(id);
	}
	public ArrayList<Manutenzione> getManutenzioni(){
		return manutenzioneDao.getManutenzioni();
	}
}
