package GUI;


import java.io.IOException;
import controler.TralalaControler;
import data.dto.cancionDTO;

public class mainSimple {

	public static void main(String []args)
	{
		if (args.length != 3) {
			System.out.println("uso: java [policy] [codebase] cliente.Cliente [host] [port] [server]");
			System.exit(0);
		}
		try {
			TralalaControler controler = new TralalaControler(args[0], args[1], args[2]);

			System.out.println(controler.login("ruben.garcia@opendeusto.es"));
			
			for(cancionDTO temp: controler.listaCanciones()){
				System.out.println(temp.getTitulo());
			}
			controler.reproducirCancion("Esclavos del destino");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
