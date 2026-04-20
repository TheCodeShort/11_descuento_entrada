package models;

import java.util.Date;

public interface InfoBoleta {
	String getNombreEvento();
	Date getFechaHora();
	int getNumeroSilla();
	int getSerie();
	double getPrecio();
}
