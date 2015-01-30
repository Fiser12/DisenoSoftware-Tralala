package gateway;

import java.rmi.Remote;

public interface IPayGatewayStrategy extends Remote {
	public void enviarDinero(String cuantoOrigen, String cuentaDestino, int dinero);
}