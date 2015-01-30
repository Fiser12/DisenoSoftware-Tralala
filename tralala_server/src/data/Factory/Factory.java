package data.Factory;

import data.Artista;
import data.Cliente;
import data.clienteNormal;
import data.clientePremium;

public class Factory {
	public static Cliente construir(Cliente cliente) {
		if(cliente.getTipoCliente()==0)
			cliente = new clienteNormal(cliente.getEmail(), cliente.getNombre(), cliente.getToken());
		else if(cliente.getTipoCliente()==1)
			cliente = new clientePremium(cliente.getEmail(), cliente.getNombre(), cliente.getToken());
		else if(cliente.getTipoCliente()==2)
			cliente = new Artista(cliente.getEmail(), cliente.getNombre(), cliente.getToken());
		return cliente;
	}
}
