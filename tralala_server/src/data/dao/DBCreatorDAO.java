package data.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class DBCreatorDAO {
	private PersistenceManagerFactory pmf;
	private final int FETCHDEPTH=10;
	
	@SuppressWarnings("unused")
	public DBCreatorDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("tralala");
	}
	public void guardarObjeto(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		setFetchDepth(pm);
	    Transaction tx = pm.currentTransaction();
	   
	    try {
	       tx.begin();
	       pm.makePersistent(object);
	       tx.commit();
	    } catch (Exception ex) {
	    	System.out.println("   ERROR GUARDANDO OBJETO: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
    		pm.close();
	    }
	}
	private void setFetchDepth(PersistenceManager pm){
		pm.getFetchPlan().setMaxFetchDepth(FETCHDEPTH);
	}

}
