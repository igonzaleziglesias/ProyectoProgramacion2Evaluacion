package bolasDelJuego;

import utilidades.DarColores;

public class Bola {

    private String color;
    private String bolita;

    public Bola() {//crear una bola de un color asignado a un valor numerico genereado aleatoriamente

    }

    public String getColor() {//obtener el color, usamos el valor del string y no el numerico para hacer las comparaciones
        return color;
    }

    @Override
    public String toString() {//imprimir la bola de color
        return bolita;
    }

}
