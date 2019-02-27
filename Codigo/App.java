package Codigo;

import Excepciones.ListaVacia;
import Niveles.*;
import static Utilidades.Constantes.FIN;
import javax.swing.JOptionPane;

public class App {
    public static int controlador;
    public App(){//menu iniciar partida o no
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

        switch (iniciar) { //menu elegir nivel de dificultad
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
                                Principiante principiante = new Principiante(ristra);   //nivel principiante           
                            break;
                        case 1:
                                Intermedio intermedio = new Intermedio(ristra); //nivel intermedio
                            break;
                        case 2:
                                Avanzado avanzado = new Avanzado(ristra); //nivel avanzado
                            break;
                        default:
                            break;
                    }

                } while (ristra.tamaño() < FIN);//condicion termina el programa 
                ristra.mostrarRistra();

                JOptionPane.showMessageDialog(null, "HAS PERDIDO \nPuntuacion: " + ristra.getPuntuacion());
                System.out.println("");
                break;
            default:
                break;
        }

    }

}
