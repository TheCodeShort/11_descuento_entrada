package service;

import model.Ticket;

public class MostrarInfo {
    // Instanciamos los objetos
    private PedirInfoService pedirInfo = new PedirInfoService();
    private BoleteriaService menu = new BoleteriaService();

    // estos atributos mantienen el estado del programa
    private String nombreActividad;
    private int sillaDisponible;
    private int contadorSerie = 100;
    private boolean[] mapaSillas; //cantidad de sillas

    public int getSillaDisponible() {
        return sillaDisponible;
    }// muestra la cantidad de sillas


    public void asignarSilla(int cantidadSillas) {
        // Creamos el arreglo. Por defecto, todas nacen en 'false' (libres)
        this.mapaSillas = new boolean[cantidadSillas];
        this.sillaDisponible = cantidadSillas;
        menu.asignarSillaPersona(this.mapaSillas);
    }

    // metodo para configurar el evento al iniciar el programa
    public void inicializarEvento(){
        this.nombreActividad = pedirInfo.pedirNombre();
        this.sillaDisponible = pedirInfo.pedirNumeroSilla();
        this.mapaSillas = new  boolean[this.sillaDisponible];
    }

    // Metodo principal para vender y mostrar recibo
    public void realizarVenta(){
        int sillasAnterior = this.sillaDisponible;

        this.sillaDisponible = menu.numeroSilla(this.sillaDisponible);

        int cantidadComprada = sillasAnterior - sillaDisponible;

        if (cantidadComprada > 0){
            for (int i = 0; i < cantidadComprada; i++){
                int sillaAsignada = menu.asignarSillaPersona(this.mapaSillas);

                if (sillaAsignada != -1){
                    imprimirTicket(sillaAsignada);

                }else{
                    System.out.println("Se acabaron las sillas disponibles.");
                }
            }
        }else {
            System.out.println("No se realizo ninguna venta o se cancelo");
        }
    }
            /*    if (this.sillaDisponible < sillasAnterior ) {
            imprimirTicket();
        }else {
            System.out.println("No se realizo ninguna venta o se cancelo");
        }
        }*/


    /*public void inicializarEvento(int cantidadSillas) {
		// Creamos el arreglo. Por defecto, todas nacen en 'false' (libres)
		this.mapaSillas = new boolean[cantidadSillas];
		this.sillaRestante = cantidadSillas;
	}*/

    public void imprimirTicket (int numeroDesilla){
        Ticket ticket = new Ticket(
                50.0,
                this.nombreActividad,
                menu.obtenerFecha(),
                numeroDesilla,
                contadorSerie++
        );

        System.out.printf("""
                %nInformacion de tu Boleta %n
                Nombre del evento: %s %n
                Fecha y hora: %tc %n
                Numero de silla No.%d %n
                Numero de serie %d %n
                Precio %.2f %n""",
                ticket.getNombreEvento(),ticket.getFechaHora(),
                ticket.getNumeroSilla(),ticket.getSerie(),
                ticket.getPrecio());
    }


}
