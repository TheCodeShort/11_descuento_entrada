package service;

import java.util.Date;
import java.util.Scanner;

public class BoleteriaService {
	Scanner teclado = new Scanner(System.in);

	public int numeroSilla(int numeroSilla) {
		while (true){
			System.out.printf("\nIngresa la opcion%n" +
			                   "1.Asignar sillas\n" +
			                   "2.Salir\n" +
			                   "3.Respuesta: ");
			int opcion = teclado.nextInt();

			if(opcion == 1){
				System.out.print("\nIngresar cantidad de personas: ");
				int totalPersonas = teclado.nextInt();

				numeroSilla = (numeroSilla - totalPersonas);
				if (numeroSilla != -1){
					System.out.printf("Sillas restantes: %d%n", numeroSilla);
				}return numeroSilla;

			}else if (opcion == 2) {
			return numeroSilla;
			}
		}
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


	public Date obtenerFecha(){
		return new Date();
	}

}

/*%s: Para Strings (cadenas de texto).
%d: Para números enteros (int, long).
%f: Para números con decimales (float, double).
%t: Para fechas (seguido de otra letra, por ejemplo %tF).
%n: Para un salto de línea (es más limpio que usar \n).*/

