package data.dto;

import java.io.Serializable;

public class cancionDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 364644554260410550L;

	private String titulo;
	private String url;
	private String genero;
	private double precioC,precioR;
	private long duracion;
	private int vecesComprada;
	public cancionDTO() {
		super();
	}
	public cancionDTO(String titulo, String url, String genero,
			double precioC, double precioR, long duracion, int vecesComprada) {
		super();
		this.titulo = titulo;
		this.url = url;
		this.genero = genero;
		this.precioC = precioC;
		this.precioR = precioR;
		this.duracion = duracion;
		this.vecesComprada = vecesComprada;
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
}