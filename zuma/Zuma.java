package zuma;

import Codigo.Bola;
import Codigo.Constantes;
import static Codigo.Constantes.FIN;
import Codigo.GestionarRistra;
import javax.swing.JOptionPane;

public class Zuma implements Constantes {

    public static void main(String[] args) {

        String[] opciones = {"PRINCIPIANTE", "INTERMEDIO", "AVANZADO"};
        int opcion = JOptionPane.showOptionDialog(
                null,
                "Elegir nivel",
                null,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                null
        );

        GestionarRistra ristra = new GestionarRistra();
        Bola bola = new Bola();

        do {
            boolean disparada = false;

            switch (opcion) {
                case 0:

                    ristra.avanzarRistra();
                    ristra.mostrarRistra();
                    System.out.println("\nBola a disparar: " + bola.toString());

                    String[] elecciones = {"SI", "NO","EXIT"};
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
                            disparada = ristra.dispararBola(bola);
                            bola = new Bola();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Has abandonado las partida");
                            System.exit(FIN);
                        default:
                            break;
                    }

                    break;

                case 1:
                    break;
                case 2:
                    break;
                default:
                    break;
            }

        } while (ristra.tamaño() < FIN);
        ristra.mostrarRistra();
        System.out.println("");

    }

}
