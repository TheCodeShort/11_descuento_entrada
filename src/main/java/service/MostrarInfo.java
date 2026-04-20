package service;

import models.Ticket;

public class MostrarInfo {
    // Instanciamos los objetos
    private PedirInfoService pedirInfo = new PedirInfoService();
    private BoleteriaService menu = new BoleteriaService();

    // estos atributos mantienen el estado del programa
    private String nombreActividad;
    private int sillaDisponible;
    private int cantidadPersona;
    private int contadorSerie = 1;
    private boolean[] mapaSillas; //cantidad de sillas
    private double valorBoleta;
    private double boletaPrecio;

    public int getSillaDisponible() {
        return sillaDisponible;
    }// muestra la cantidad de sillas

    // metodo para configurar el evento al iniciar el programa
    public void inicializarEvento(){
        this.nombreActividad = pedirInfo.pedirNombre();
        this.sillaDisponible = pedirInfo.pedirNumeroSilla();
        this.valorBoleta = pedirInfo.valorBoleta();
        this.mapaSillas = new  boolean[this.sillaDisponible];


    }

    // Metodo principal para vender y mostrar recibo
    public void realizarVenta(){
        this.cantidadPersona = pedirInfo.totalPersonas();
        int sillasAnterior = this.sillaDisponible;
        this.sillaDisponible = menu.numeroSilla(this.sillaDisponible, this.cantidadPersona);
        this.boletaPrecio = menu.precioBoleta(this.cantidadPersona, this.valorBoleta);

        int cantidadComprada = sillasAnterior - sillaDisponible;

        if (0 < cantidadComprada){
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

    public void imprimirTicket (int numeroDeSilla){
        Ticket ticket = new Ticket(
                this.boletaPrecio,
                this.nombreActividad,
                menu.obtenerFecha(),
                numeroDeSilla,
                contadorSerie++
        );

        System.out.printf("""
                ===============================
                %nInformacion de tu Boleta %n
                Nombre del evento: %s %n
                Fecha y hora: %tc %n
                Numero de silla No.%d %n
                Numero de serie No.%d %n
                Precio %.2f %n
                ===============================%n""",
                ticket.getNombreEvento(),ticket.getFechaHora(),
                ticket.getNumeroSilla(),ticket.getSerie(),
                ticket.getPrecio());
    }


}
