package data;

import gateway.IPayGatewayStrategy;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.DiscriminatorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import data.dao.IcancionDAO;
import data.dao.cancionDAO;
import data.dto.assamblerCancion;
import data.dto.cancionDTO;
import data.interfaces.GestorCanciones;
import data.interfaces.GestorCompra;

@PersistenceCapable(detachable = "true")
@Discriminator(strategy=DiscriminatorStrategy.CLASS_NAME)
public abstract class Cliente implements GestorCanciones, GestorCompra{
    private String email;
	private String nombre;
	private String token;
	private int tipoCliente;
	@Persistent(mappedBy="cliente", dependentElement="true")
	@Join
	private List <Reproduccion> reproduce;
    @Persistent(mappedBy="clientes")
	private List <Cancion> tiene;
	private IPayGatewayStrategy formaPago;
	protected IcancionDAO persistencia;
	
	public Cliente(String email, String
			nombre, String token) {
		this.email = email;
		this.nombre = nombre;
		this.token = token;
		this.reproduce = new ArrayList<Reproduccion>();
		this.tiene = new ArrayList<Cancion>();
	}
	public String getEmail() {
		return email;
	}
	public void setStrategy(IPayGatewayStrategy strategy)
	{
		setFormaPago(strategy);
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setToken(String token){
		this.token = token;
	}
	public String getToken(){
		return token;
	}
	public int getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public List <Reproduccion> getReproduce() {
		return reproduce;
	}
	public void setReproduce(List <Reproduccion> reproduce) {
		this.reproduce = reproduce;
	}
	public List <Cancion> getTiene() {
		return tiene;
	}
	public void setTiene(List <Cancion> tiene) {
		this.tiene = tiene;
	}
	public void addReproduce(Reproduccion anadir)
	{
		reproduce.add(anadir);
	}
	public void addTiene(Cancion anadir)
	{
		tiene.add(anadir);
	}
	public cancionDTO reproducirCancion(String song) throws RemoteException {
		persistencia = new cancionDAO();
		Cancion c = persistencia.sacarCancion(song);
		persistencia.crearReproducion(c, this);
		return assamblerCancion.construir(c);
	}
	public IPayGatewayStrategy getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(IPayGatewayStrategy formaPago) {
		this.formaPago = formaPago;
	}
	public IcancionDAO getPersistencia() {
		return persistencia;
	}
	public void setPersistencia(IcancionDAO persistencia) {
		this.persistencia = persistencia;
	}

	
}
