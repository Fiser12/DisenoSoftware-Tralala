package data;

import java.rmi.RemoteException;

import autorizacion.Facebook;
import data.Factory.Factory;
import data.dao.IclienteDAO;
import data.dao.clienteDAO;
import data.interfaces.ISesion;

public class Sesion implements ISesion{
	private IclienteDAO persistencia;
	public Sesion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cliente login(String correo) throws RemoteException {
		Facebook autorizacion = new Facebook();
		String token = autorizacion.comprobarToken(correo);
		System.out.println("Antes de llamar a sacar cliente");
		persistencia = new clienteDAO();
		Cliente cliente = persistencia.sacarCliente(token);//Sale como un cliente generico, no tiene atribuido ninguno en herencia que es lo que nos importa
		cliente = Factory.construir(cliente);
		return cliente;
	}

	@Override
	public boolean registrarse(String email, String password)
			throws RemoteException {
		return false;
	}
}
