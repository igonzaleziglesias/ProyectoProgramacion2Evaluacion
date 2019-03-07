package codigo;

import niveles.Avanzado;
import niveles.Intermedio;
import niveles.Principiante;
import ficheroPuntuaciones.Fichero;
import javax.swing.JOptionPane;

public class App {
    public Fichero fich = new Fichero();
    public static int controlador;

    public App() {//menu iniciar partida o no
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

                boolean disparada = false;

                switch (opcion) {
                    case 0:
                        Principiante principiante = new Principiante(ristra);   //nivel principiante           
                        fich.añadirPuntuacion(ristra.getPuntuacion());
                        fich.leerFichero();
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

                break;
            default:
                break;
        }

    }

}
