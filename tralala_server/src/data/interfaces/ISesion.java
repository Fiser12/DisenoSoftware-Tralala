package data.interfaces;

import java.rmi.RemoteException;

import data.Cliente;

public interface ISesion {
	public Cliente login(String correo) throws RemoteException;
	public boolean registrarse(String email, String password)throws RemoteException;
}
