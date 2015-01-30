package data.dao;

import java.util.LinkedList;

import data.Cancion;
import data.Cliente;

public interface IcancionDAO {
	public Cancion sacarCancion(String titulo);
	public LinkedList<Cancion> sacarCanciones();
	public void crearReproducion(Cancion can, Cliente cl);
	public void guardarCancion(Cancion guardar);
}
