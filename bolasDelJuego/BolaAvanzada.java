package bolasDelJuego;

import utilidades.DarColores;

public class BolaAvanzada extends Bola {

    private String color;
    private String bolita;

    public BolaAvanzada() {//crear una bola de un color asignado a un valor numerico genereado aleatoriamente
        DarColores color = new DarColores();
        int n = ((int) (Math.random() * 5) + 1);
        switch (n) {
            case 1:
                this.color = "R";
                this.bolita = color.DarColores(1);
                break;
            case 2:
                this.color = "V";
                this.bolita = color.DarColores(2);
                break;
            case 3:
                this.color = "Z";
                this.bolita = color.DarColores(3);
                break;
            case 4:
                this.color = "A";
                this.bolita = color.DarColores(4);
                break;
            case 5:
                this.color = "M";
                this.bolita = color.DarColores(5);
                break;
            default:
                break;
        }
    }

    @Override
    public String getColor() {//obtener el color, usamos el valor del string y no el numerico para hacer las comparaciones
        return color;
    }

    @Override
    public String toString() {//imprimir la bola de color
        return bolita;
    }

}
