package data.dto;

import java.util.LinkedList;

import data.Cancion;

public class assamblerCancion {

	public static cancionDTO construir(Cancion c)
	{
		return new cancionDTO(c.getTitulo(), c.getUrl(),c.getGenero(), c.getPrecioC(), c.getPrecioR(), c.getDuracion(), c.getVecesComprada());
	}
	public static Cancion construir(cancionDTO c)
	{
		return new Cancion(c.getTitulo(), c.getPrecioC(),c.getPrecioR(), c.getDuracion(), c.getUrl(), c.getVecesComprada(), c.getGenero());
	}
	public static LinkedList<cancionDTO> construir(LinkedList<Cancion>lista)
	{
		LinkedList <cancionDTO> listaDevolver = new LinkedList<cancionDTO>();
		for(Cancion temp: lista)
		{
			listaDevolver.add(construir(temp));
		}
		return listaDevolver;
	}
}
