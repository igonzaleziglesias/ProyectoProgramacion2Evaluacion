package ficheroPuntuaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import utilidades.Pedir;

public class Fichero {

    private File fich = null;
    private PrintWriter f = null;
    Scanner sc;

    public Fichero() {//creamos el fichero
//        fich = new File("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/puntuaciones.txt");
        fich = new File("C:\\Users\\Usuario\\Desktop\\puntuaciones.txt");
    }

    public void añadirPuntuacion(int puntuacion) {//añadimos una puntuacion de un usuario
        try {
//            f = new PrintWriter(new FileWriter("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/puntuaciones.txt", true));
            f = new PrintWriter(new FileWriter("C:\\Users\\Usuario\\Desktop\\puntuaciones.txt", true));//abrimos canal
            Usuario jugador = new Usuario(Pedir.pedirString("Nick Name: "), puntuacion);//pedimos el nick y asignamos la puntuacion
            f.println(jugador);//escribimos en el fichero
        } catch (IOException ex) {
            System.out.println("error1 " + ex.getMessage());
        } finally {
            f.close();//cerramos canal
        }
    }

    public void leerFichero() {
        try {
            sc = new Scanner(fich);
            System.out.println("Tabla puntuaciones: ");
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());//leemos cada linea del fichero y la imprimimos
            }
        } catch (FileNotFoundException ex) {
            System.out.println("error2" + ex.getMessage());
        } finally {
            sc.close();//cerramos el canal
        }
    }
}
