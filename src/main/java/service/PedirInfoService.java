package service;

import java.util.Scanner;

public class PedirInfoService {
	Scanner teclado = new Scanner(System.in);

	public String pedirNombre() {
		System.out.print("Ingrese el nombre del evento: ");
		String nombre = teclado.nextLine();
		return nombre;
	}
	public int pedirNumeroSilla() {
		System.out.print("Ingrese el numero de sillas totales: ");
		int sillaTotal = teclado.nextInt();
		System.out.print("Ingrese el numero de silla dañadas: ");
		int sillaDanada = teclado.nextInt();
		int finalSilla = sillaTotal - sillaDanada;
		System.out.printf("Numero de sillas totales: %d%n", finalSilla);
		return finalSilla;
	}

	public int totalPersonas() {

		System.out.printf("\nIngresa la opcion%n" +
				"1.Asignar sillas\n" +
				"2.Salir\n" +
				"3.Respuesta: ");
		int opcion = teclado.nextInt();

		if (opcion == 1) {
			System.out.print("\nIngresar cantidad de personas: ");
			int total = teclado.nextInt();
			if(total > 4){
				System.out.printf("No se puede vander mas de 4 voletas");
				return 0;
			}else {
				return total;
			}

		}
		return 0;
	}

	public double valorBoleta(){
		System.out.print("Ingrece el precio de la Boleta: $");
		double precioBoleta = teclado.nextDouble();
		return precioBoleta;
	}
}