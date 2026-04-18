package service;

import java.util.Scanner;

public class BoleteriaService {

	CalculoSillasService TotalSilla = new CalculoSillasService();
	Scanner teclado = new Scanner(System.in);

	public int numeroSilla(int numeroSilla) {

		while (true){
			System.out.print("Infresa la opcion\n" +
			                   "1.Ingresar personas\n" +
			                   "2.Salir\n" +
			                   "3.Respuesta:");
			int opcion = teclado.nextInt();

			if(opcion == 1){
				int totalSilla;
				while (true) {
					System.out.print("ingresa una opcion\n" +
					                 "1.Ingresar cantidad de personas\n" +
					                 "2.Salir\n" +
					                 "3.Respuesta:");

					int opcionDos = teclado.nextInt();
					if (opcionDos == 1) {
						System.out.print("Digite la cantidad de perosnas: ");
						int sillaAsignada = teclado.nextInt();
						totalSilla = numeroSilla - sillaAsignada;
						System.out.printf("silla totales: %d%n", totalSilla);
						break;
					}
				}
			}
		}
	}
}