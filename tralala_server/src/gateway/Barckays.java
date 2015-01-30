package gateway;

public class Barckays implements IPayGatewayStrategy{
	String nombreBanco = "Barckays";
	@Override
	public void enviarDinero(String cuantoOrigen, String cuentaDestino,
			int dinero) {
		//Envía el dineroa  través de la api de Barklays
	}
}
