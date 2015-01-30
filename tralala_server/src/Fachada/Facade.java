package Fachada;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

import data.Cancion;
import data.Cliente;
import data.Sesion;
import data.dao.IcancionDAO;
import data.dao.cancionDAO;
import data.dto.assamblerCancion;
import data.dto.cancionDTO;

@SuppressWarnings("deprecation")
public class Facade extends UnicastRemoteObject implements IFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sesion inicio;
	private Cliente sesion;
	private IcancionDAO persistencia;
	protected Facade() throws RemoteException {
		super();
		inicio = new Sesion();
	}

	@Override
	public String login(String correo) throws RemoteException {
		sesion = inicio.login(correo);
		String token = sesion.getToken();
		if(token.equals(""))
			throw new RemoteException();
		return token;
	}

	@Override
	public boolean registrarse(String email, String password)
			throws RemoteException {
		return false;
	}

	@Override
	public void subirCancion(cancionDTO song) throws RemoteException {
		
	}

	@Override
	public void pasarDineroMes() throws RemoteException {
		
	}

	@Override
	public cancionDTO reproducirCancion(String song) throws RemoteException {
		return sesion.reproducirCancion(song);
	}

	@Override
	public List<cancionDTO> buscar(String patron) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcularPagoMes() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void comprarCancion(String song) throws RemoteException {

	}
	@Override
	public LinkedList<cancionDTO> listaCanciones()
	{
		persistencia = new cancionDAO();
		LinkedList<Cancion> lista = persistencia.sacarCanciones();
		return assamblerCancion.construir(lista);
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IFacade objServidor = new Facade();
			Naming.rebind(name, objServidor);
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e){
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}


}
