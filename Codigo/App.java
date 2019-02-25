package Codigo;

import Excepciones.ListaVacia;
import Niveles.*;
import static Utilidades.Constantes.FIN;
import javax.swing.JOptionPane;

public class App {
    public static int controlador;
    public App(){
        String[] inicio = {"INICIAR PARTIDA", "EXIT"};
        int iniciar = JOptionPane.showOptionDialog(
                null,
                "Elegir nivel",
                null,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                inicio,
                null
        );

        switch (iniciar) {
            case 0:

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
                
                
                do {
                    boolean disparada = false;

                    switch (opcion) {
                        case 0:
                                Principiante principiante = new Principiante(ristra);              
                            break;
                        case 1:
                                Intermedio intermedio = new Intermedio(ristra);
                            break;
                        case 2:
                                Avanzado avanzado = new Avanzado(ristra);
                            break;
                        default:
                            break;
                    }

                } while (ristra.tamaño() < FIN);
                ristra.mostrarRistra();

                JOptionPane.showMessageDialog(null, "HAS PERDIDO \nPuntuacion: " + ristra.getPuntuacion());
                System.out.println("");
                break;
            default:
                break;
        }

    }

}
