package ficheroPuntuaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;
import utilidades.Pedir;

public class Fichero {

    private File fich = null;
    private PrintWriter f = null;
    Scanner sc;

    public Fichero() {
        fich = new File("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/puntuaciones.txt");
//        fich = new File("C:\\Users\\Usuario\\Desktop\\puntuaciones.txt");
    }

    public void añadirPuntuacion(int puntuacion) {
        try {
            f = new PrintWriter(new FileWriter("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/puntuaciones.txt", true));
//            f = new PrintWriter(new FileWriter("C:\\Users\\Usuario\\Desktop\\puntuaciones.txt", true));
            Usuario jugador = new Usuario(Pedir.pedirString("\nMejores 5 puntuaciones: \n"+primerasCincoPuntuaciones()+"\nNick: "), puntuacion);
            f.println(jugador);
        } catch (IOException ex) {
            System.out.println("error1 " + ex.getMessage());
        } finally {
            f.close();
        }
    }

//    public void leerFichero() {
//        try {
//            sc = new Scanner(fich);
//            System.out.println("puntuaciones:");
//            while (sc.hasNext()) {
//                System.out.println(sc.nextLine());
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("error2" + ex.getMessage());
//        } finally {
//            sc.close();
//        }
//    }

    public String primerasCincoPuntuaciones() {//muestra las 5 mejores puntuaciones ordenadas por puntuacion y por antiguedad
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        String devolver = "no hay puntuaciones";
        try {
            sc = new Scanner(fich);
            while (sc.hasNextLine()) {//leer linea 
                String[] nicks = sc.nextLine().split(" ");
                Usuario user = new Usuario(nicks[0], (Integer.parseInt(nicks[1])));//convertirla a usuario
                lista.add(user);//añadir al array
            }
            Collections.sort(lista);

            switch (lista.size()) {//mostar numero de puntuaciones dependiendo del tamaño del array
                case 1:

                    return "-" + lista.get(0).getNick() + " " + lista.get(0).getPuntuacion();

                case 2:

                    return "-" + lista.get(0).getNick() + " " + lista.get(0).getPuntuacion() + "\n"
                            + "-" + lista.get(1).getNick() + " " + lista.get(1).getPuntuacion() + "\n";

                case 3:
                    return "-" + lista.get(0).getNick() + " " + lista.get(0).getPuntuacion() + "\n"
                            + "-" + lista.get(1).getNick() + " " + lista.get(1).getPuntuacion() + "\n"
                            + "-" + lista.get(2).getNick() + " " + lista.get(2).getPuntuacion() + "\n";

                case 4:
                    return "-" + lista.get(0).getNick() + " " + lista.get(0).getPuntuacion() + "\n"
                            + "-" + lista.get(1).getNick() + " " + lista.get(1).getPuntuacion() + "\n"
                            + "-" + lista.get(2).getNick() + " " + lista.get(2).getPuntuacion() + "\n"
                            + "-" + lista.get(3).getNick() + " " + lista.get(3).getPuntuacion() + "\n";

                default:
                    return "-" + lista.get(0).getNick() + " " + lista.get(0).getPuntuacion() + "\n"
                            + "-" + lista.get(1).getNick() + " " + lista.get(1).getPuntuacion() + "\n"
                            + "-" + lista.get(2).getNick() + " " + lista.get(2).getPuntuacion() + "\n"
                            + "-" + lista.get(3).getNick() + " " + lista.get(3).getPuntuacion() + "\n"
                            + "-" + lista.get(4).getNick() + " " + lista.get(4).getPuntuacion() + "\n";

            }
        } catch (FileNotFoundException ex) {
            System.out.println("");
        } finally {
            sc.close();//cerrar canal
        }
        return devolver;
    }
}
