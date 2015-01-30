package gateway;

public class Paypal implements IPayGatewayStrategy{
	String nombreBanco = "Paypal";
	@Override
	public void enviarDinero(String cuantoOrigen, String cuentaDestino,
			int dinero) {
		//Envia el dinero usando la api de Paypal
	}



}
