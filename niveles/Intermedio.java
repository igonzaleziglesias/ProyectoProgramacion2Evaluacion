package niveles;

import static codigo.App.controlador;
import bolasDelJuego.BolaIntermedia;
import codigo.GestionarRistra;
import easterEgg.EasterEgg;
import ficheroPuntuaciones.FicheroIntermedio;
import static utilidades.Constantes.FIN;
import javax.swing.JOptionPane;

public class Intermedio {

    public FicheroIntermedio fich = new FicheroIntermedio();
    private BolaIntermedia bola = new BolaIntermedia();
    private BolaIntermedia bolaAvance;

    public Intermedio(GestionarRistra ristra) {
        do {
//            System.out.print("Avanzando la ristra de bolas ");
            ristra.avanzarRistra(bolaAvance = new BolaIntermedia());

            if ((ristra.tamaño() > 3) && (controlador == 0)) {//huevo de pascua
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

            String[] elecciones = {"SI", "NO", "EXIT"};//menu disparar
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
                    this.bola = new BolaIntermedia();
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

        JOptionPane.showMessageDialog(null, "HAS PERDIDO 2 \nPuntuacion: " + ristra.getPuntuacion());
        fich.añadirPuntuacion(ristra.getPuntuacion());
//        fich.leerFichero();
        System.out.println("");
    }
}
