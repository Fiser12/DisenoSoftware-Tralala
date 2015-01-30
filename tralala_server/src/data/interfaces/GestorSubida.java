package data.interfaces;


import java.rmi.RemoteException;

import data.dto.cancionDTO;

public interface GestorSubida {
	
	public void subirCancion(cancionDTO song) throws RemoteException;

}
