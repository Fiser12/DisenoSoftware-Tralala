package data;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;




import data.dao.cancionDAO;
import data.dto.assamblerCancion;
import data.dto.cancionDTO;
import data.interfaces.GestorPago;
import data.interfaces.GestorSubida;

public class Artista extends Cliente implements GestorSubida, GestorPago {
	private List <Cancion> propiedad;

	public Artista(String email, String nombre, String token) {
		super(email, nombre, token);
		this.setTipoCliente(2);
		propiedad = new ArrayList<Cancion>();
	}
	public void addPropiedad(Cancion anadir)
	{
		propiedad.add(anadir);
	}
	@Override
	public double calcularPagoMes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void comprarCancion(String song) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public cancionDTO reproducirCancion(String song) throws RemoteException {
		persistencia = new cancionDAO();
		Cancion c = persistencia.sacarCancion(song);
		persistencia.crearReproducion(c, this);
		return assamblerCancion.construir(c);
	}

	@Override
	public List<cancionDTO> buscar(String token, String patron)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void subirCancion(cancionDTO song) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pasarDineroMes() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public List <Cancion> getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(List <Cancion> propiedad) {
		this.propiedad = propiedad;
	}
}
