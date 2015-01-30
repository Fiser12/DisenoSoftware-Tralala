package data;

import java.rmi.RemoteException;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

import data.dao.cancionDAO;
import data.dto.assamblerCancion;
import data.dto.cancionDTO;
@PersistenceCapable(detachable = "true")
public class clienteNormal extends Cliente{
	public clienteNormal(String email, String nombre, String token) {
		super(email, nombre, token);
		this.setTipoCliente(0);
	}

	@Override
	public double calcularPagoMes() {
		return 0;
	}

	@Override
	public void comprarCancion(String song) throws RemoteException {
		
	}

	@Override
	public List<cancionDTO> buscar(String token, String patron)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public cancionDTO reproducirCancion(String song) throws RemoteException {
		persistencia = new cancionDAO();
		Cancion c = persistencia.sacarCancion(song);
		persistencia.crearReproducion(c, this);
		return assamblerCancion.construir(c);
	}

}
