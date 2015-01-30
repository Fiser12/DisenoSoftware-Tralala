package data.interfaces;

import java.rmi.RemoteException;

public interface GestorCompra {
	
	public double calcularPagoMes();
	public void comprarCancion(String song) throws RemoteException;
}
