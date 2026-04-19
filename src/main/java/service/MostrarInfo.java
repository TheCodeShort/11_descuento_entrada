package service;

import model.Ticket;

import java.util.Date;

public class MostrarInfo {

    PedirInfoService pedirInfo = new PedirInfoService();
    BoleteriaService menu = new BoleteriaService();

    String nombreActividad = pedirInfo.pedirNombre();
    Date fechaActual = (Date) menu.obtenerFecha();
    int TotalSilla = pedirInfo.pedirNumeroSilla();
    int totalSillas = menu.numeroSilla(TotalSilla);


    Ticket ticket = new Ticket(123, nombreActividad, fechaActual, totalSillas, 1234);

    public void mostrarInfoBoleta (){
        System.out.printf("""
                Informacion de tu Boleta %n
                Nombre del evento: %s %n
                Fecha y hora: %tc %n
                Numero de silla %d %n
                Numero de serie %d %n
                Precio %.2f %n""",
                ticket.getNombreEvento(),ticket.getFechaHora(),
                ticket.getNumeroSilla(),ticket.getSerie(),
                ticket.getPrecio());
    }

}
