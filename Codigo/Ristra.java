package Codigo;

import static Utilidades.Constantes.FIN;
import Excepciones.FueraDeRango;
import PedirDatos.Pedir;
import java.util.ArrayList;

public class Ristra implements IRistra {
    private int puntuacion;
    private ArrayList<Bola> ristraBolas = new ArrayList<Bola>();

    public void nuevaBola(Bola bola) {
        ristraBolas.add(bola);
    }

    public int longitud() {
        return ristraBolas.size();
    }

    public void mostrarAñadiendoDerecha() {
        System.out.println("");
        for (Bola ele : ristraBolas) {
            System.out.print(ele.toString());
        }
    }

    public ArrayList<Bola> invertir() {
        ArrayList<Bola> reverse;

        if (ristraBolas != null) {
            reverse = new ArrayList<>();
            for (int i = ristraBolas.size() - 1; i >= 0; i--) {
                reverse.add(ristraBolas.get(i));
            }
        } else {
            reverse = null;
        }
        return reverse;
    }

    public void mostrarSegunVanSaliendo(ArrayList<Bola> bola) {
        for (int i = FIN; i >= 1; i--) {
            System.out.printf("%4d", i);
        }
        System.out.println("");
        int i;
        for (i = FIN - longitud() + 1; i > 1; i--) {
            System.out.printf("%4s", "");
        }
        for (Bola ele : bola) {

            System.out.printf("%4s", ele.toString());

        }
       
        System.out.println("\nPuntuacion: "+puntuacion);
    }

    public ArrayList<Bola> disparar(Bola bola) throws FueraDeRango {

        System.out.println(longitud());

        int posicion = Pedir.pedirInt("A que posicion quiere disparar?") - 1;//indicar la posicion a la que disparar
        if (posicion < 0) {
            throw new FueraDeRango("Disparo fallido");
        }
        if (posicion > longitud()) {//comprueba que el disparo sea a la ristra de bolas y si no lanza una excepcion fuera de rango
            throw new FueraDeRango("Disparo fallido");
        }
        int acumulador = 1;
        int acumulador2 = 1;

        if (posicion == longitud()) {//dispara al final del array y cuenta las bolas del mismo color que hay a su lado
            ristraBolas.add(bola);
            for (int i = posicion - 1; i >= 0; i--) {
                if (ristraBolas.get(i).getColor() != null) {
                    if (ristraBolas.get(posicion).getColor().equals(ristraBolas.get(i).getColor())) {
                        acumulador2++;
                        System.out.println(ristraBolas.get(posicion).getColor() + " 2 " + acumulador2 + " " + ristraBolas.get(i).getColor());
                    } else {
                        break;
                    }
                }
            }
        } else {

            ristraBolas.add(posicion, bola);

            if (longitud() > 1) {//comprueba si la ristra tiene elementos
                for (int i = posicion + 1; i <= longitud(); i++) {//cuenta las bolas que hay a la izq del disparo iguales a la bola disparada(cuenta la bola disparada)
//          System.out.println(ristraBolas.get(i));System.out.println(ristraBolas.get(posicion));
                    try {
                        if (ristraBolas.get(posicion).getColor().equals(ristraBolas.get(i).getColor())) {
                            acumulador++;
                            System.out.println(ristraBolas.get(posicion).getColor() + " 1 " + acumulador + " " + ristraBolas.get(i).getColor());
                        } else {
                            break;
                        }
                    } catch (Exception ex) {
                        System.out.println("No hay mas elementos en la lista");//quitar el mensaje solo quiero que trate la excepcion
                    }
                }
                for (int i = posicion - 1; i >= 0; i--) { //cuenta las bolas que hay a la derecha del disparo iguales a la bola disparada(cuenta la bola disparada)
                    if (ristraBolas.get(i).getColor() != null) {
                        if (ristraBolas.get(posicion).getColor().equals(ristraBolas.get(i).getColor())) {
                            acumulador2++;
                            System.out.println(ristraBolas.get(posicion).getColor() + " 2 " + acumulador2 + " " + ristraBolas.get(i).getColor());
                        } else {
                            break;
                        }
                    }
                }
                int bolasJuntas=(acumulador + acumulador2 - 1);
                System.out.println("acumulador " + bolasJuntas);//restamos 1 para no contar dos veces la posicion del elemento introducido

                if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                    explotar(posicion, acumulador, acumulador2);
                    puntuacion(bolasJuntas);
                }
            }
        }
        return ristraBolas;
    }

    public void explotar(int posicion, int acumulador, int acumulador2) {
        ristraBolas.remove(posicion);//elimina la bola insertada
        acumulador = acumulador - 1;//quitamos la posicion en la que introducimos que ya la eliminamos
        acumulador2 = acumulador2 - 1;//quitamos la posicion en la que introducimos 

        while (acumulador != 0) {//borra las bolas iguales a la de la posicion que estaban situdas delante de la que disparamos
            ristraBolas.remove(posicion);
            acumulador--;
        }
        int i = 1;
        while (acumulador2 != 0) {//borra las bolas iguales a la de la posicion que estaban situadas por detras de la que disparamos
            ristraBolas.remove(posicion - i);
            i++;
            acumulador2--;
        }

    }
    
    public void puntuacion(int bolasJuntas){
        int puntos=0;
        
        for (int i=3;i<=bolasJuntas;i++){
            puntos++;
        }
        this.puntuacion=puntuacion+puntos;
        
    }

}
