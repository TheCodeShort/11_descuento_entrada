package main;

import service.MostrarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MostrarInfo sistema = new MostrarInfo();

        // asigna el nombre y hace el conteo de las sillas
        sistema.inicializarEvento();

        boolean continuar = true;
        while (continuar){

            // se usa el metodo de venta
            sistema.realizarVenta();
            //System.out.println("\nTotal de sillas: " + sistema.getSillaRestante());

            System.out.print("\nQuiere hacer otra accion? s/n: ");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("n")){
                continuar = false;
                System.out.println("Sillas disponibles: " + sistema.getSillaDisponible());
            }
        }
        System.out.println("Sillas disponibles: " + sistema.getSillaDisponible());
        System.out.println("Cerrando sistema gracias");
    }
}
