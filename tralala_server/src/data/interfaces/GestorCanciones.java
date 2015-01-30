package data.interfaces;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import data.dto.cancionDTO;

public interface GestorCanciones {
	
	public cancionDTO reproducirCancion(String song) throws RemoteException;
	public List<cancionDTO> buscar(String token, String patron) throws RemoteException;
}
