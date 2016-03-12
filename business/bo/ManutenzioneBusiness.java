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
