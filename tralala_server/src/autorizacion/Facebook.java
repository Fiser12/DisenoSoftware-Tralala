package autorizacion;

import java.rmi.RemoteException;
import java.util.HashMap;

public class Facebook implements IFacebook{
	
	private HashMap<String, String>	users;

	public Facebook() throws RemoteException
	{
		users = new HashMap<>();

		users.put("vero.merino@opendeusto.es", "4321");
		users.put("ruben.garcia@opendeusto.es", "1234");
		users.put("mikel.unzueta@opendeusto.es", "123abc");
		users.put("jokin.saiz@opendeusto.es", "abc123");
		users.put("nach@gmail.com", "5678");
	}

	@Override
	public String comprobarToken(String email) throws RemoteException
	{
		return users.get(email);
	}

}
