package data.dao;

import data.Cancion;
import data.Cliente;
import data.Reproduccion;

import javax.jdo.*;
import java.util.LinkedList;

public class cancionDAO implements IcancionDAO{
	private static PersistenceManagerFactory pmf;
	private final static int FETCHDEPTH=10;
	public cancionDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("tralala");
	}
	public Cancion sacarCancion(String titulo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
		Transaction tx = pm.currentTransaction();
		Cancion cancion=null;
		try {
			System.out.println("   * Retrieving an Extent for Member.");
			
			tx.begin();			
			Extent<Cancion> extent = pm.getExtent(Cancion.class, true);
			
			for (Cancion temp : extent) {
				if (temp.getTitulo().equals(titulo)){
					cancion=temp;
				}
			}
			
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
		return cancion;

	}
	public LinkedList<Cancion> sacarCanciones()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
		Transaction tx = pm.currentTransaction();
		LinkedList<Cancion> cancion= new LinkedList<Cancion>();
		try {
			System.out.println("   * Retrieving an Extent for Member.");
			
			tx.begin();			
			Extent<Cancion> extent = pm.getExtent(Cancion.class, true);
			
			for (Cancion temp : extent) {
				cancion.add(temp);
			}
			
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }
		return cancion;
	}
	public void crearReproducion(Cancion can, Cliente cl)
	{
		Reproduccion nuevo = new Reproduccion(can, cl, System.currentTimeMillis());
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
	    Transaction tx = pm.currentTransaction();
	    try
	    {
	        tx.begin();

			Reproduccion rep = new Reproduccion(can, cl, System.currentTimeMillis());
			pm.makePersistent(rep);

	        tx.commit();
	    }
	    catch (Exception e)
	    {
	        if (tx.isActive())
	        {
	            tx.rollback();
	        }
	    }

	}
	public void guardarCancion(Cancion guardar){
		
	}
	private static void setFetchDepth(PersistenceManager pm){
		pm.getFetchPlan().setMaxFetchDepth(FETCHDEPTH);
	}

}