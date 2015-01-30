package data;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Reproduccion {
	private Cancion song;
	private Cliente cliente;
	private long fechaReproduccion;

	public Reproduccion(Cancion song, Cliente cliente, long fechaReproduccion) {
		super();
		this.setSong(song);
		this.setCliente(cliente);
		this.fechaReproduccion = fechaReproduccion;
	}

	public long getFechaReproduccion() {
		return fechaReproduccion;
	}

	public void setFechaReproduccion(long fechaReproduccion) {
		this.fechaReproduccion = fechaReproduccion;
	}

	public Cancion getSong() {
		return song;
	}

	public void setSong(Cancion song) {
		this.song = song;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
