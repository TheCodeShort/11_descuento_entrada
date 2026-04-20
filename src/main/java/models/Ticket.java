package models;
import java.util.Date;

public class Ticket implements Informacion{
	private String nombreEvento;
	private Date fehcaHora;
	private int numeroSilla;
	private int serie;
	private double precio;

	public Ticket(double precio, String nombreEvento, Date fehcaHora, int numeroSilla, int serie) {
		this.precio = precio;
		this.nombreEvento = nombreEvento;
		this.fehcaHora = fehcaHora;
		this.numeroSilla = numeroSilla;
		this.serie = serie;
	}
	@Override
	public String getNombreEvento() {
		return nombreEvento;
	}
	@Override
	public double getPrecio() {
		return precio;
	}
	@Override
	public int getSerie() {
		return serie;
	}
	@Override
	public int getNumeroSilla() {
		return numeroSilla;
	}
	@Override
	public Date getFechaHora() { return fehcaHora; }
}
