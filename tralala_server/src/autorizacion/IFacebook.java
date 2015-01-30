package autorizacion;

import java.rmi.RemoteException;

public interface IFacebook {
	
	public String comprobarToken(String email) throws RemoteException;
}
