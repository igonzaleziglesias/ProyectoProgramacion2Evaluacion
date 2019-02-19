package Codigo;

import Excepciones.FueraDeRango;
import java.util.ArrayList;

public class GestionarRistra {

    private Bola bola;
    private Ristra ristraBolas = new Ristra();

    public void avanzarRistra() {
        bola = new Bola();
        ristraBolas.nuevaBola(bola);

    }

    public boolean dispararBola(Bola bola) {
        try {
            ristraBolas.disparar(bola);
            System.out.println("Disparada");
            return true;
        } catch (FueraDeRango ex) {
            System.out.println(ex.getMessage());
        } return false;
    }

    public int tamaño() {
        return ristraBolas.longitud();
    }

    public void mostrarRistra() {
        ristraBolas.mostrarSegunVanSaliendo(ristraBolas.invertir());

    }

}
