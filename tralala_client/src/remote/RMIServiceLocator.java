package remote;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Fachada.IFacade;


public class RMIServiceLocator{

	/** 
	 * The Cache - Limitation: one server at a time
	 * Proposed improvement: list of services
	 */
	static RMIServiceLocator instance;
	private IFacade service;
    /** Creates a new instance of RMIServiceLocator */

	private RMIServiceLocator() {
		// TODO Auto-generated constructor stub
		}
	public static RMIServiceLocator getInstance()
	{
		if(instance==null)
			instance = new RMIServiceLocator();
		return instance;		
	}
	public void setService(String ip, String port, String serviceName) {    
    	// Add your code to get the TARGET reference HERE
		String name = "//" + ip + ":" + port + "/" + serviceName;
		if(System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
    	try {
			service =  (IFacade) java.rmi.Naming.lookup(name);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public IFacade getService() {    	
    	return service;
    }
}