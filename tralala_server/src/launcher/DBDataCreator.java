package launcher;

import data.Cancion;
import data.Cliente;
import data.Reproduccion;
import data.clienteNormal;
import data.dao.DBCreatorDAO;

import java.util.ArrayList;

public class DBDataCreator {
	public static void main(String[]argv){
		ArrayList<Object>lista=new ArrayList<Object>();
		Cliente cl1 = new clienteNormal("ruben.garcia@opendeusto.es", "Fiser", "1234");

		Cancion c1 = new Cancion("Anochece",0.99,0.05,4,"http://grooveshark.com/s/Anochece/3W0ORn",0, "RAP");
		Cancion c2 = new Cancion("Pensando en voz alta",1.99,0.15,3,"http://grooveshark.com/s/Pensando+En+Voz+Alta/3N0ATQ", 1, "RAP");
		Cancion c3 = new Cancion("Esclavos del destino",0.99,0.05,2,"http://grooveshark.com/s/Pensando+En+Voz+Alta/3N0ATQ",2, "RAP");

		lista.add(cl1);
		lista.add(c2);
		lista.add(c3);
		c1.addTiene(cl1);
		Reproduccion r1 = new Reproduccion(c1, cl1, 123424124);
		
		cl1.addReproduce(r1);
		c1.addReproduce(r1);

		DBCreatorDAO dao=new DBCreatorDAO();
		for(Object o: lista){
			dao.guardarObjeto(o);
		}

	}
}