package Codigo;

import Excepciones.FueraDeRango;
import Excepciones.ListaVacia;
import Utilidades.Pedir;
import java.util.ArrayList;

public class Ristra implements IRistra {

    private int puntuacion;
    private ArrayList<Bola> ristraBolas = new ArrayList<Bola>();

    public int getPuntuacion() {
        return puntuacion;
    }

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

    public void mostrarConFormato(ArrayList<Bola> bola) {
        System.out.println("");
        System.out.println("Ristra: ");
        System.out.println("");
        System.out.print("  ");
        for (int i = longitud(); i >= 1; i--) {
            System.out.printf("%4d", i);
        }
        System.out.println("");
//        int i;
//        for (i = FIN - longitud() + 1; i > 1; i--) {
//            System.out.printf("%4s", "");
//        }
        System.out.print("\033[30m==");
        for (Bola ele : bola) {
            System.out.printf("%3s", "");
            System.out.print(ele.toString());
        }
        System.out.println("");
        System.out.println("\nPuntuacion: " + puntuacion);
    }

    public ArrayList<Bola> disparar(Bola bola) throws FueraDeRango, ListaVacia {

//        System.out.println(longitud());
//tratar con una excepcion que introduzca un int
        int posicion = 0;
        boolean numero = true;
        int controlador = 0;
        int puntos = 0;
        do {
            numero = true;
            try {
                posicion = Pedir.pedirInt("A que posicion quiere disparar?") - 1;//indicar la posicion a la que disparar
            } catch (NumberFormatException ex) {
                System.out.println("No es una posicion");
                numero = false;
            }
        } while (numero != true);

        if (posicion < 0) {
            throw new FueraDeRango("Disparo fallido");
        }
        if (posicion > longitud()) {//comprueba que el disparo sea a la ristra de bolas y si no lanza una excepcion fuera de rango
            throw new FueraDeRango("Disparo fallido");
        }
        int acumulador = 1;
        int acumulador2 = 1;
        MetodosAuxiliares ayuda = new MetodosAuxiliares();

        if (posicion == longitud()) {//dispara al final del array y cuenta las bolas del mismo color que hay a su lado
            ristraBolas.add(bola);

            acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);
            controlador = acumulador2;
            try {
                Bola bolaComodin = ristraBolas.get(posicion - controlador);
                ristraBolas.remove(posicion - controlador);
                System.out.println("Eliminando Elemento");

                puntos = concatenarExplosiones(bolaComodin, posicion - controlador, puntos);
                System.out.println("puntuacion.this: " + this.puntuacion+" puntos a sumar: "+puntos );

            } catch (Exception ex) {
                System.out.println("Siguiente Posicion nula");
            }finally{}

        } else {

            ristraBolas.add(posicion, bola);
            int longitud = longitud();
            if (longitud() > 1) {//comprueba si la ristra tiene elementos

                acumulador = ayuda.contarBolasDetras(posicion, ristraBolas, acumulador, longitud);//cuenta las bolas que hay despues del disparo iguales a la bola disparada(cuenta la bola disparada)

                acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);//cuenta las bolas que hay antes del disparo iguales a la bola disparada(cuenta la bola disparada)

                controlador = acumulador2 - 1;
//                System.out.println("controlador: "+controlador);

                int bolasJuntas = (acumulador + acumulador2 - 1);
                System.out.println("acumuladorBolasExplotan: " + bolasJuntas);//restamos 1 para no contar dos veces la posicion del elemento introducido

                if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                    explotar(posicion, acumulador, acumulador2);
                    puntos = puntuacion(bolasJuntas);

                    try {
                        Bola bolaComodin = ristraBolas.get(posicion - controlador);
                        ristraBolas.remove(posicion - controlador);
                        System.out.println("Eliminando Elemento");

                        puntos = concatenarExplosiones(bolaComodin, posicion - controlador, puntos);
                        System.out.println("puntuacion.this: " + this.puntuacion+" puntos a sumar: "+puntos );
                    } catch (Exception ex) {
                        System.out.println("Siguiente Posicion nula");
                    }finally{}
                    
                }
            }
        } this.puntuacion = this.puntuacion + puntos;
                
        return ristraBolas;
    }

    public void explotar(int posicion, int acumulador, int acumulador2) throws ListaVacia {
        if (ristraBolas.isEmpty()) {
            throw new ListaVacia("Lista Vacia");
        }
        ristraBolas.remove(posicion);//elimina la bola insertada
        acumulador = acumulador - 1;//quitamos la posicion en la que introducimos que ya la eliminamos
        acumulador2 = acumulador2 - 1;//quitamos la posicion en la que introducimos 

        while (acumulador != 0) {//borra las bolas iguales a la de la posicion que estaban situdas detras de la que disparamos
            if (ristraBolas.isEmpty()) {
                throw new ListaVacia("Lista Vacia");
            }
            ristraBolas.remove(posicion);
            acumulador--;
        }
        int i = 1;
        while (acumulador2 != 0) {//borra las bolas iguales a la de la posicion que estaban situadas por delante de la que disparamos
            if (ristraBolas.isEmpty()) {
                throw new ListaVacia("Lista Vacia");
            }
            ristraBolas.remove(posicion - i);
            i++;
            acumulador2--;
        }

    }

    public int puntuacion(int bolasJuntas) {
        int puntos = 1;
        if (bolasJuntas > 3) {
            for (int i = 4; i <= bolasJuntas; i++) {
                puntos++;
                puntos++;
            }
        }

        return puntos;
    }

    public int concatenarExplosiones(Bola bola, int control, int puntos) throws FueraDeRango, ListaVacia {
        if (!ristraBolas.isEmpty()) {
//        System.out.println(longitud());
//tratar con una excepcion que introduzca un int
            int posicion = control;//indicar la posicion a la que disparar

            if (posicion < 0) {
                throw new FueraDeRango("Disparo fallido");
            }
            if (posicion > longitud()) {//comprueba que el disparo sea a la ristra de bolas y si no lanza una excepcion fuera de rango
                throw new FueraDeRango("Disparo fallido");
            }
            int acumulador = 1;
            int acumulador2 = 1;
            MetodosAuxiliares ayuda = new MetodosAuxiliares();
            int controlador = 0;
            int bolasJuntas = 0;
            if (posicion == longitud()) {//dispara al final del array y cuenta las bolas del mismo color que hay a su lado
                ristraBolas.add(bola);

                acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);

                controlador = acumulador2 - 1;
                System.out.println("controlador: " + posicion + "-" + controlador);
                bolasJuntas = (acumulador + acumulador2 - 1);
                System.out.println("acumuladorBolasExplotan2 " + bolasJuntas);//restamos 1 para no contar dos veces la posicion del elemento introducido

                if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                    explotar(posicion, acumulador, acumulador2);
                    puntos = puntos + puntuacion(bolasJuntas) + 5;
                    System.out.println("puntua:" + puntos);
                    Bola bolaComodin = ristraBolas.get(posicion - controlador);
                    ristraBolas.remove(posicion - controlador);
                    concatenarExplosiones(bolaComodin, posicion - controlador, puntos);
                }
            } else {

                ristraBolas.add(posicion, bola);
                int longitud = longitud();
                if (longitud() > 1) {//comprueba si la ristra tiene elementos

                    acumulador = ayuda.contarBolasDetras(posicion, ristraBolas, acumulador, longitud);//cuenta las bolas que hay despues del disparo iguales a la bola disparada(cuenta la bola disparada)

                    acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);//cuenta las bolas que hay antes del disparo iguales a la bola disparada(cuenta la bola disparada)

                    controlador = acumulador2 - 1;
                    System.out.println("controlador: " + posicion + "-" + controlador);

                    bolasJuntas = (acumulador + acumulador2 - 1);
                    System.out.println("acumuladorBolasJuntas2 " + bolasJuntas);//restamos 1 para no contar dos veces la posicion del elemento introducido

                    if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                        explotar(posicion, acumulador, acumulador2);
                        puntos = puntos + puntuacion(bolasJuntas) + 5;
                        System.out.println("puntua:" + puntos);
                        Bola bolaComodin = ristraBolas.get(posicion - controlador);
                        ristraBolas.remove(posicion - controlador);
                        concatenarExplosiones(bolaComodin, posicion - controlador, puntos);

                    }
                }
            }

        }
        return puntos;
    }

}
