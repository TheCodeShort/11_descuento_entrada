package main;

import service.BoleteriaService;
import service.PedirInfoService;

public class Main {
    public static void main(String[] args) {


        PedirInfoService pedirInfo = new PedirInfoService();
        BoleteriaService menu = new BoleteriaService();

        //String nombreActividad = pedirInfo.pedirNombre();
        int TotalSilla = pedirInfo.pedirNumeroSilla();

        menu.numeroSilla(TotalSilla);





    }
}
