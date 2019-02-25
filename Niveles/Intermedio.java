package Niveles;

import Codigo.Bola;
import Codigo.GestionarRistra;
import static Utilidades.Constantes.FIN;
import javax.swing.JOptionPane;

public class Intermedio {

    public Intermedio(GestionarRistra ristra) {
        Bola bola = new Bola();
        
        ristra.mostrarRistra();
        System.out.print("Avanzando la ristra de bolas ");
        ristra.avanzarRistra();
        ristra.avanzarRistra();
        if (ristra.tamaño() == FIN) {
            System.exit(0);
        }
        ristra.mostrarRistra();

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
