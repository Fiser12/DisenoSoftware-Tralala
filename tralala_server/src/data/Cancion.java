package data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
public class Cancion {
	private String titulo;
	private String url;
	private String genero;
	private double precioC,precioR;
	private long duracion;
	private int vecesComprada;
    @Persistent(table="TIENE")
    @Join(column="CANCION_ID")
    @Element(column="CLIENTE_ID")
	private List<Cliente> clientes;
	@Persistent(mappedBy="song", dependentElement="true")
	@Join
	private List <Reproduccion> reproduce;
	
	public Cancion(String titulo, double precioC, double precioR, long duracion, String url, int vecesComprada, String genero) {
		super();
		this.titulo = titulo;
		this.precioC = precioC;
		this.precioR = precioR;
		this.duracion = duracion;
		this.url = url;
		this.vecesComprada = vecesComprada;
		this.genero = genero;
		this.reproduce = new ArrayList<Reproduccion>();
		this.clientes = new ArrayList<Cliente>();
	}	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUrl() {
		return url;
	}
	public void setArtista(String url) {
		this.url = url;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getPrecioC() {
		return precioC;
	}
	public void setPrecioC(double precioC) {
		this.precioC = precioC;
	}
	public double getPrecioR() {
		return precioR;
	}
	public void setPrecioR(double precioR) {
		this.precioR = precioR;
	}
	public long getDuracion() {
		return duracion;
	}
	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}
	public int getVecesComprada() {
		return vecesComprada;
	}
	public void setVecesComprada(int vecesComprada) {
		this.vecesComprada = vecesComprada;
	}
	public List <Reproduccion> getReproduce() {
		return reproduce;
	}
	public void setReproduce(List <Reproduccion> reproduce) {
		this.reproduce = reproduce;
	}
	public void addReproduce(Reproduccion anadir)
	{
		reproduce.add(anadir);
	}
	public void addTiene(Cliente anadir)
	{
		clientes.add(anadir);
	}

}
