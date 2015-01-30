package Fachada;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import data.dto.cancionDTO;

public interface IFacade extends Remote {
		
		public String login(String correo) throws RemoteException;
		public boolean registrarse(String email, String password)throws RemoteException;
		public void subirCancion(cancionDTO song) throws RemoteException;
		public void pasarDineroMes() throws RemoteException;
		public cancionDTO reproducirCancion(String song) throws RemoteException;
		public List<cancionDTO> buscar(String patron) throws RemoteException;
		public double calcularPagoMes() throws RemoteException;
		public void comprarCancion(String song) throws RemoteException;
		public LinkedList<cancionDTO> listaCanciones() throws RemoteException;
}
