package models;

public class Evento {
    private String nombre;
    private int sillaDisponible;
    private boolean[] mapaSillas;
    private double precioBase;
    private int contadorSerie;

    public Evento(String nombre, int sillaDisponible, double precioBase) {
        this.nombre = nombre;
        this.sillaDisponible = sillaDisponible;
        this.precioBase = precioBase;
        this.mapaSillas = new boolean[sillaDisponible];
        this.contadorSerie = 1;
    }

    public String getNombre() { return nombre; }
    public int getSillaDisponible() { return sillaDisponible; }
    public boolean[] getMapaSillas() { return mapaSillas; }
	public double getPrecioBase() { return precioBase; }
	public int getContadorSerie() { return contadorSerie; }

	public void incrementarSerie() { this.contadorSerie++; }
	public void setSillaDisponible(int sillaDisponible) { this.sillaDisponible = sillaDisponible; }
}
