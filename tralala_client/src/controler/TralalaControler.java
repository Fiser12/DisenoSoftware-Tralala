package controler;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.RemoteException;
import java.util.LinkedList;

import remote.RMIServiceLocator;
import data.dto.cancionDTO;

public class TralalaControler {
	
	private String token;
	public TralalaControler(String ip, String port, String name) throws IOException{
		RMIServiceLocator.getInstance().setService(ip, port, name);
	}
	public boolean login(String correo)
	{
		try
		{
			token =  RMIServiceLocator.getInstance().getService().login(correo);
			return true;
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public void reproducirCancion(String song)
	{
		if (token != null)
		{
			try
			{
				cancionDTO cancion = RMIServiceLocator.getInstance().getService().reproducirCancion(song);
				System.out.println("Cancion que se esta reproduciendo: " + cancion.getTitulo());
				 try {
			            Desktop.getDesktop().browse(new URI(cancion.getUrl()));
			        } catch (URISyntaxException ex) {
			            System.out.println(ex);
			        }catch(IOException e){
			            System.out.println(e);
			        }
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	@SuppressWarnings("static-access")
	public LinkedList<cancionDTO> listaCanciones()
	{
		try {
			return RMIServiceLocator.getInstance().getInstance().getService().listaCanciones();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new LinkedList<cancionDTO>();
	}
}
