package Niveles;

import static Codigo.App.controlador;
import Codigo.Bola;
import Codigo.GestionarRistra;
import EasterEgg.EasterEgg;
import static Utilidades.Constantes.FIN;
import javax.swing.JOptionPane;

public class Intermedio {

    public Intermedio(GestionarRistra ristra) {
        Bola bola = new Bola();

        System.out.print("Avanzando la ristra de bolas ");
        ristra.avanzarRistra();
        ristra.avanzarRistra();

        if ((ristra.tamaño() > 3) && (controlador == 0)) {
            if (ristra.getPrimerElementoRistra().getColor().equals("R")
                    && ristra.getSegundoElementoRistra().getColor().equals("Z")
                    && ristra.getTercerElementoRistra().getColor().equals("V")
                    && ristra.getCuartoElementoRistra().getColor().equals("R")
                    && ristra.getQuintoElementoRistra().getColor().equals("Z")
                    && ristra.getSextoElementoRistra().getColor().equals("V")) {
                EasterEgg egg = new EasterEgg(ristra);
                controlador = 1;
            }
        }

        ristra.mostrarRistra();

        if (ristra.tamaño() == FIN) {
            JOptionPane.showMessageDialog(null, "HAS PERDIDO \nPuntuacion: " + ristra.getPuntuacion());
            System.exit(0);
        }
        System.out.println("Bola a disparar: " + bola.toString());

        String[] elecciones = {"SI", "NO", "EXIT"};
        int eleccion = JOptionPane.showOptionDialog(
                null,
                "Desea disparar una bola??",
                null,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                elecciones,
                null
        );
        switch (eleccion) {
            case 0:
                ristra.dispararBola(bola);
                bola = new Bola();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Has abandonado las partida\nPuntuacion: " + ristra.getPuntuacion());
                System.exit(FIN);
            default:
                break;
        }

    }
}
