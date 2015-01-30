package data.dao;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import data.Cliente;
import data.clienteNormal;

public class clienteDAO implements IclienteDAO {
	private static PersistenceManagerFactory pmf;
	private final static int FETCHDEPTH=10;
	public clienteDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("tralala");
	}
	public Cliente sacarCliente(String token)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
		Transaction tx = pm.currentTransaction();
		Cliente member=null;
		try {
			System.out.println("   * Retrieving an Extent for Member.");
			
			tx.begin();			
			Extent<clienteNormal> extent = pm.getExtent(clienteNormal.class, true);
			
			for (Cliente memberE : extent) {
				System.out.println(memberE.getToken());
				if (memberE.getToken().equals(token)){
					member=memberE;
				}
			}
			System.out.println("Antes de hacer el commit de sacar cliente");
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
		return member;

	}
	public void guardarCliente(Cliente guardar){
		
	}
	private static void setFetchDepth(PersistenceManager pm){
		pm.getFetchPlan().setMaxFetchDepth(FETCHDEPTH);
	}

}