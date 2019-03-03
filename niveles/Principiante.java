package niveles;

import static codigo.App.controlador;
import bolasDelJuego.Bola;
import bolasDelJuego.BolaPrincipiante;
import codigo.GestionarRistra;
import easterEgg.EasterEgg;
import static utilidades.Constantes.FIN;
import javax.swing.JOptionPane;

public class Principiante {

    private BolaPrincipiante bola = new BolaPrincipiante();
    private BolaPrincipiante bolaAvance;
    public Principiante(GestionarRistra ristra) {

        do {
            System.out.print("Avanzando la ristra de bolas ");
            ristra.avanzarRistra(bolaAvance=new BolaPrincipiante());

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
                    this.bola = new BolaPrincipiante();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Has abandonado las partida\nPuntuacion: " + ristra.getPuntuacion());
                    System.exit(FIN);
                default:
                    break;
            }
        } while (ristra.tamaño() < FIN);//condicion termina el programa 
        ristra.mostrarRistra();

        JOptionPane.showMessageDialog(null, "HAS PERDIDO \nPuntuacion: " + ristra.getPuntuacion());
        System.out.println("");
    }
}
