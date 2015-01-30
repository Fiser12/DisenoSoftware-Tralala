package data.dao;

import java.util.LinkedList;

import data.Cancion;
import data.Cliente;

public interface IclienteDAO {
	public Cliente sacarCliente(String token);
	public void guardarCliente(Cliente guardar);
	}
