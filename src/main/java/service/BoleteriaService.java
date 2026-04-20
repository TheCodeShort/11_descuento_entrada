package service;

import java.util.Date;
import java.util.Scanner;

public class BoleteriaService {

// para que si sea una clase de calculos no deberia mostar nada en pantalla solo retornar el resultado
	public int numeroSilla(int numeroSilla, int totalPersona) {
		numeroSilla = (numeroSilla - totalPersona);
		if (numeroSilla != -1){
			System.out.printf("\nSillas restantes: %d%n", numeroSilla);
		}return numeroSilla;
	}

	public int asignarSillaPersona(boolean[] totalSilla){
		for (int i = 0; i < totalSilla.length; i++) {
			if (totalSilla[i] == false) {
				totalSilla[i] = true;
				return (i + 1);
			}
		}
		return ( -1 );
	}


	public double precioBoleta(int cantidadBoleta, double costoBoleta){
		double porcentaje = 0;
		if(cantidadBoleta == 1) {
			System.out.println("No se aplica descuento");
			return costoBoleta;
		}else if (cantidadBoleta == 2){
			porcentaje = 0.10;
		} else if (cantidadBoleta == 3) {
			porcentaje = 0.15;
		} else if (cantidadBoleta == 4) {
			porcentaje = 0.20;

		}
		double descuento = costoBoleta * porcentaje;
		double precioFinal = costoBoleta - descuento;
		System.out.println("Se aplica descuento de: $" + descuento);

		return precioFinal;
	}


	public Date obtenerFecha(){
		return new Date();
	}

}

/*%s: Para Strings (cadenas de texto).
%d: Para números enteros (int, long).
%f: Para números con decimales (float, double).
%t: Para fechas (seguido de otra letra, por ejemplo %tF).
%n: Para un salto de línea (es más limpio que usar \n).*/

