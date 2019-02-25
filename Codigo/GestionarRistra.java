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

    public Bola getPrimerElementoRistra() {
        return ristraBolas.primerElemento();
    }

    public Bola getSegundoElementoRistra() {
        return ristraBolas.segundoElemento();
    }

    public Bola getTercerElementoRistra() {
        return ristraBolas.tercerElemento();
    }

    public Bola getCuartoElementoRistra() {
        return ristraBolas.cuartoElemento();
    }

    public Bola getQuintoElementoRistra() {
        return ristraBolas.quintoElemento();
    }

    public Bola getSextoElementoRistra() {
        return ristraBolas.sextoElemento();
    }

    public void dispararBola(Bola bola) {
        try {//intenta disparar una bola contra la ristra y lanza la excepcion si no consigue alcanzarla
            ristraBolas.disparar(bola, 0);
            System.out.println("Disparada");
        } catch (FueraDeRango ex) {
            System.out.println(ex.getMessage());
        } catch (ListaVacia ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int tamaño() {
        return ristraBolas.longitud();
    }

    public void mostrarRistra() {
        ristraBolas.mostrarConFormato(ristraBolas.invertir());

    }

    public int getPuntuacion() {
        return ristraBolas.getPuntuacion();
    }

    public void setPuntuacion(int puntos) {
        ristraBolas.setPuntuacion(puntos);
    }

}
