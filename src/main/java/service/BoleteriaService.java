package service;

import java.util.Date;
import java.util.Scanner;

public class BoleteriaService {


	Scanner teclado = new Scanner(System.in);

	public int numeroSilla(int numeroSilla) {

		while (true){
			System.out.print("Ingresa la opcion\n" +
			                   "1.Asignar sillas\n" +
			                   "2.Salir\n" +
			                   "3.Respuesta: ");
			int opcion = teclado.nextInt();

			if(opcion == 1){
				while (true) {
					System.out.print("ingresa una opcion\n" +
					                 "1.Ingresar cantidad de personas\n" +
					                 "2.Salir\n" +
					                 "3.Respuesta:");
					int opcionDos = teclado.nextInt();
					if (opcionDos == 1) {
						System.out.print("Digite la cantidad de personas: ");
						int sillaAsignada = teclado.nextInt();
						numeroSilla = numeroSilla - sillaAsignada;
						System.out.printf("silla totales: %d%n", numeroSilla);

					} else if (opcionDos == 2) {
						break;
					}
				}
			} else if (opcion == 2) {
				return numeroSilla;
			}
		}
    }

	public Date obtenerFecha(){
		return new Date();
	}
}
/*public void imprimir() {
    Date miFecha = obtenerFecha();
    // Usa %tF para el formato ISO (AAAA-MM-DD)
    System.out.printf("La fecha es: %tF", miFecha);
}*/

/*%s: Para Strings (cadenas de texto).
%d: Para números enteros (int, long).
%f: Para números con decimales (float, double).
%t: Para fechas (seguido de otra letra, por ejemplo %tF).
%n: Para un salto de línea (es más limpio que usar \n).*/

