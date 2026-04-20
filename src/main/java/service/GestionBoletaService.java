package service;

import models.Evento;
import models.Ticket;

public class GestionBoletaService {
    private InputService pedirInfo = new InputService();
    private BoleteriaService menu = new BoleteriaService();
    private Evento evento;

    private int cantidadPersona;
    private double boletaPrecio;

    public int getSillaDisponible() {
        // operador ternario
        return (evento != null) ? evento.getSillaDisponible() : 0;
    }

    public void inicializarEvento(){
        String nombre = pedirInfo.pedirNombre();
        int sillas = pedirInfo.pedirNumeroSilla();
        double precio = pedirInfo.valorBoleta();
        this.evento = new Evento(nombre, sillas, precio);
    }

    public void realizarVenta(){
        this.cantidadPersona = pedirInfo.totalPersonas();
        int sillasAnterior = evento.getSillaDisponible();
        int nuevasSillas = menu.numeroSilla(sillasAnterior, this.cantidadPersona);
        this.boletaPrecio = menu.precioBoleta(this.cantidadPersona, evento.getPrecioBase());

        int cantidadComprada = sillasAnterior - nuevasSillas;

        if (0 < cantidadComprada){
            evento.setSillaDisponible(nuevasSillas);
            for (int i = 0; i < cantidadComprada; i++){
                int sillaAsignada = menu.asignarSillaPersona(evento.getMapaSillas());
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
                evento.getNombre(),
                menu.obtenerFecha(),
                numeroDeSilla,
                evento.getContadorSerie()
        );
        
        evento.incrementarSerie();

        System.out.printf("""
                ===============================
                %nInformacion de tu Boleta %n
                Nombre del evento: %s %n
                Fecha y hora: %tc %n
                Numero de silla No.%d %n
                Numero de serie No.%d %n
                Precio %.2f %n
                ===============================%n""",
                ticket.getNombreEvento(), ticket.getFechaHora(),
                ticket.getNumeroSilla(), ticket.getSerie(),
                ticket.getPrecio());
    }
}
