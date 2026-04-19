package main;

import model.Ticket;
import service.BoleteriaService;
import service.MostrarInfo;
import service.PedirInfoService;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        MostrarInfo mostrarInfo = new MostrarInfo();
        mostrarInfo.mostrarInfoBoleta();

    }
}
