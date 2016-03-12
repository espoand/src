package business.bo;

import java.util.ArrayList;

import dao.ClienteDao;
import dao.DaoFactory;
import entity.Cliente;

public class ClienteBusiness {
	private static ClienteDao clienteDao = null;
public ClienteBusiness(){
	clienteDao = DaoFactory.getDaoFactory(DaoFactory.MySQL).getClienteDao();
	
}
public boolean inserisciCliente(Cliente c){
	return clienteDao.inserisciCliente(c.getNome(), c.getCognome(), c.getTelefono(), c.getCodiceFiscale(), c.getIndirizzo());
}
public boolean modificaCliente(Cliente c){
	return clienteDao.modificaCliente(c.getCodiceFiscale(), c.getNome(), c.getCognome(), c.getTelefono(),c.getIndirizzo());
}
public boolean rimuoviCliente(String cf){
	return clienteDao.cancellaCliente(cf);
}
public Cliente getCliente(String c){
	return clienteDao.getCliente(c);
}
public ArrayList<Cliente> tuttiClienti(){
	return clienteDao.tuttiClienti();
}
}
