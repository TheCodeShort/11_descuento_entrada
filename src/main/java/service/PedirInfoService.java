package service;

import java.util.Scanner;

public class PedirInfoService {
	Scanner teclado = new Scanner(System.in);

	public String pedirNombre(){
		System.out.print("Ingrese el nombre del evento: ");
		String nombre = teclado.nextLine();
		return nombre;
	}

	public int pedirNumeroSilla(){
		System.out.print("Ingrese el numero de sillas totales: ");
		int sillaTotal = teclado.nextInt();
		System.out.print("Ingrese el numero de silla dañadas: ");
		int sillaDanada = teclado.nextInt();
		int finalSilla = sillaTotal - sillaDanada;
		System.out.printf("Numero de sillas totales: %d%n", finalSilla );
		return finalSilla;
	}



}
