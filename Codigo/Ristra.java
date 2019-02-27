package Codigo;

import Excepciones.FueraDeRango;
import Excepciones.ListaVacia;
import Sonido.SonidoExplotar;
import static Utilidades.Constantes.PUNTOSCONCA;
import java.util.ArrayList;

public class Ristra implements IRistra {

    int control = 0;
    private int puntuacion;
    private ArrayList<Bola> ristraBolas = new ArrayList<Bola>();

    public Bola primerElemento() {//obtenemos primer elemento (EasterEgg)
        return ristraBolas.get(0);
    }

    public Bola segundoElemento() {//obtenemos segundo elemento (EasterEgg)
        return ristraBolas.get(1);
    }

    public Bola tercerElemento() {//obtenemos tercer elemento (EasterEgg)
        return ristraBolas.get(2);
    }

    public Bola cuartoElemento() {//obtenemos cuarto elemento (EasterEgg)
        return ristraBolas.get(3);
    }

    public Bola quintoElemento() {//obtenemos quinto elemento (EasterEgg)
        return ristraBolas.get(4);
    }

    public Bola sextoElemento() {//obtenemos sexto elemento (EasterEgg)
        return ristraBolas.get(5);
    }

    public int getPuntuacion() {//metodo par obtener la puntuacion de la partida
        return puntuacion;
    }

    public void setPuntuacion(int puntos) {//Metodo para introducir el Bonnus del EasterEgg
        this.puntuacion = puntos;
    }

    public void nuevaBola(Bola bola) {//añadir nueva bola
        ristraBolas.add(bola);
    }

    public int longitud() {//Obtener el tamaño de la ristra de bolas
        return ristraBolas.size();
    }

    public void mostrarAñadiendoDerecha() {//mostrar ristra bolas sin formato
        System.out.println("");
        for (Bola ele : ristraBolas) {
            System.out.print(ele.toString());
        }
    }

    public ArrayList<Bola> invertir() {//dar formato a la ristra(invirtiendo el orden en el que se muestra
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

    public void mostrarConFormato(ArrayList<Bola> bola) {//mostrar con el formato 
        System.out.println("");
        System.out.println("Ristra: ");
        System.out.println("");
        System.out.print("  ");
        for (int i = longitud(); i >= 1; i--) {
            System.out.printf("%4d", i);
        }
        System.out.println("");

        System.out.print("==");
        for (Bola ele : bola) {
            System.out.printf("%3s", "");
            System.out.print(ele.toString());
        }
        System.out.println("");
        System.out.println("\nPuntuacion: " + puntuacion);
    }

    public void explotar(int posicion, int acumulador, int acumulador2) throws ListaVacia {//metodo para explotar si hay mas de 3 bolas juntas
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
        SonidoExplotar sonido = new SonidoExplotar();
    }

    public int puntuacion(int bolasJuntas) {//metodo para puntuar las explosiones
        int puntos = 1;
        if (bolasJuntas > 3) {
            for (int i = 4; i <= bolasJuntas; i++) {
                puntos++;
                puntos++;
            }
        }

        return puntos;
    }

    public int puntuacionConcatenacion() {//metodo que suma 5 si concatena explosiones(bonnus concatenacion de explosiones)
        return PUNTOSCONCA;
    }

    public ArrayList<Bola> disparar(Bola bola, int posicionConcatena) throws FueraDeRango, ListaVacia {//metodo para disparar una bola a la ristra
        MetodosAuxiliares ayuda = new MetodosAuxiliares();

        int posicion = 0;
        if (control == 0) {
            posicion = ayuda.pedirPosicion(longitud());
        } else {
            posicion = posicionConcatena;
        }

        int acumulador = 1, acumulador2 = 1, controlador = 0/*necesario?*/, bolasJuntas = 0, longitud = longitud();

        if (control == 0) {
            if (posicion == longitud()) {//dispara al final del array y cuenta las bolas del mismo color que hay a su lado
                ristraBolas.add(bola);

                acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);//cuenta el numero de bolas iguales que hay delante de la posicion insertada(cuenta la bola insertada)
                controlador = acumulador2;
                bolasJuntas = acumulador2;
                System.out.println("1.Bolas a explotar: " + bolasJuntas);
                if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                    explotar(posicion, acumulador, acumulador2);
                    this.puntuacion = this.puntuacion + puntuacion(bolasJuntas);
                    System.out.println("1.explotando");
//                this.puntuacion = this.puntuacion + puntuacion(bolasJuntas);

                    try {
                        control = 1;
                        Bola bolaComodin = ristraBolas.get(posicion - controlador);
                        ristraBolas.remove(posicion - controlador);
                        System.out.println("1.Eliminando conjunto bolas");
                        disparar(bolaComodin, posicion - controlador);

                    } catch (Exception ex) {
                        System.out.println("1.Siguiente Posicion nula");
                    }
                }
            } else {

                ristraBolas.add(posicion, bola);

                if (longitud() > 1) {//comprueba si la ristra tiene elementos

                    acumulador = ayuda.contarBolasDetras(posicion, ristraBolas, acumulador, longitud);//cuenta las bolas que hay despues del disparo iguales a la bola disparada(cuenta la bola disparada)
                    acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);//cuenta las bolas que hay antes del disparo iguales a la bola disparada(cuenta la bola disparada)
                    controlador = acumulador2 - 1;
//                System.out.println("controlador: "+controlador);

                    bolasJuntas = (acumulador + acumulador2 - 1);
                    System.out.println("2.Bolas a explotar: " + bolasJuntas);//restamos 1 para no contar dos veces la posicion del elemento introducido

                    if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                        explotar(posicion, acumulador, acumulador2);
                        this.puntuacion = this.puntuacion + puntuacion(bolasJuntas);
                        System.out.println("2.explotando");
                        try {
                            control = 1;
                            Bola bolaComodin = ristraBolas.get(posicion - controlador);
                            ristraBolas.remove(posicion - controlador);
                            System.out.println("2.Eliminando Elemento");
                            disparar(bolaComodin, posicion - controlador);
                        } catch (Exception ex) {
//                        System.out.println("puntos: "+puntos+" puntua: "+puntua);
//                        if(puntua==0){this.puntuacion=this.puntuacion+puntos;
//                        return ristraBolas;}
//                        this.puntuacion=this.puntuacion+puntua;
                            System.out.println("2.Siguiente Posicion nula");
                        }
                    }
                }
            }
        } else {
            System.out.println("añadiendo de nuevo");
            ristraBolas.add(posicion, bola);

            if (longitud() > 0) {//comprueba si la ristra tiene elementos

                acumulador = ayuda.contarBolasDetras(posicion, ristraBolas, acumulador, longitud);//cuenta las bolas que hay despues del disparo iguales a la bola disparada(cuenta la bola disparada)
                acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);//cuenta las bolas que hay antes del disparo iguales a la bola disparada(cuenta la bola disparada)
                controlador = acumulador2 - 1;
                System.out.println("bola añadidada de nuevo en posicion: " + (posicion + 1) + " bolas por delante: " + controlador + " bolas por detras: " + (acumulador - 1));
                bolasJuntas = (acumulador + acumulador2 - 1);
                System.out.println("3.Bolas a explotar: " + bolasJuntas);//restamos 1 para no contar dos veces la posicion del elemento introducido
                System.out.println("izq: " + (acumulador - 1) + " der: " + (acumulador2 - 1));

                if ((bolasJuntas >= 3) && (acumulador - 1 >= 0) && (acumulador2 - 1 != 0)) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                    explotar(posicion, acumulador, acumulador2);
                    this.puntuacion = this.puntuacion + puntuacion(bolasJuntas) + puntuacionConcatenacion();
                    System.out.println("3.explotando");

                    Bola bolaComodin = ristraBolas.get(posicion - controlador);
                    ristraBolas.remove(posicion - controlador);
                    disparar(bolaComodin, posicion - controlador);

                }
            }
        }
        control = 0;
        return ristraBolas;
    }

}
