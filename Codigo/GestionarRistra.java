package Codigo;

import Excepciones.FueraDeRango;
import Excepciones.ListaVacia;

public class GestionarRistra {

    private Bola bola;
    private Ristra ristraBolas = new Ristra();

    public void avanzarRistra() {//avanza una posicion la ristra de bolas añadiendo una nueva bola
        bola = new Bola();
        ristraBolas.nuevaBola(bola);

    }

    public Bola getPrimerElementoRistra() {//obtenemos primer elemento (EasterEgg)
        return ristraBolas.primerElemento();
    }

    public Bola getSegundoElementoRistra() {//Obtenemos segundo elemento (EasterEgg)
        return ristraBolas.segundoElemento();
    }

    public Bola getTercerElementoRistra() {//Obtenemos tercer elemento (EasterEgg)
        return ristraBolas.tercerElemento();
    }

    public Bola getCuartoElementoRistra() {//Obtenemos cuarto elemento (EasterEgg)
        return ristraBolas.cuartoElemento();
    }

    public Bola getQuintoElementoRistra() {//Obtenemos quinto elemento (EasterEgg)
        return ristraBolas.quintoElemento();
    }

    public Bola getSextoElementoRistra() {//Obtenemos sexto elemento (EasterEgg)
        return ristraBolas.sextoElemento();
    }

    public void dispararBola(Bola bola) {//gestionamos Disparar una bola contra la ristara y capturamos las excepciones que puedan surgir
        try {//intenta disparar una bola contra la ristra y lanza la excepcion si no consigue alcanzarla
            ristraBolas.disparar(bola, 0);
            System.out.println("Disparada");
        } catch (FueraDeRango ex) {
            System.out.println(ex.getMessage());
        } catch (ListaVacia ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int tamaño() {//Obtenemos el tamaño de la ristra
        return ristraBolas.longitud();
    }

    public void mostrarRistra() {//ostramos la ritra de bolas con el formato que queremos
        ristraBolas.mostrarConFormato(ristraBolas.invertir());

    }

    public int getPuntuacion() {//Obtenemos la puntuacion
        return ristraBolas.getPuntuacion();
    }

    public void setPuntuacion(int puntos) {//Metodo para introducir el Bonus del EasterEgg en la puntuacion
        ristraBolas.setPuntuacion(puntos);
    }

}
