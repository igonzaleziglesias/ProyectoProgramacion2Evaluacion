package niveles;

import static codigo.App.controlador;
import bolasDelJuego.BolaAvanzada;
import codigo.GestionarRistra;
import easterEgg.EasterEgg;
import ficheroPuntuaciones.FicheroAvanzado;
import static utilidades.Constantes.FIN;
import javax.swing.JOptionPane;

public class Avanzado {

    public FicheroAvanzado fich = new FicheroAvanzado();
    private BolaAvanzada bola = new BolaAvanzada();
    private BolaAvanzada bolaAvance;

    public Avanzado(GestionarRistra ristra) {
        do {
//            System.out.print("Avanzando la ristra de bolas ");
            ristra.avanzarRistra(bolaAvance = new BolaAvanzada());

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
                    this.bola = new BolaAvanzada();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Has abandonado las partida\nPuntuacion: " + ristra.getPuntuacion());
                    fich.añadirPuntuacion(ristra.getPuntuacion());
//                    fich.leerFichero();
                    System.exit(FIN);
                default:
                    break;
            }
        } while (ristra.tamaño() < FIN);//condicion termina el programa 

        ristra.mostrarRistra();

        JOptionPane.showMessageDialog(null, "HAS PERDIDO 3 \nPuntuacion: " + ristra.getPuntuacion());
        fich.añadirPuntuacion(ristra.getPuntuacion());
//        fich.leerFichero();
        System.out.println("");
    }
}
