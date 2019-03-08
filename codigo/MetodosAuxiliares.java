package codigo;

import bolasDelJuego.Bola;
import excepciones.FueraDeRango;
import utilidades.Pedir;
import java.util.ArrayList;

public class MetodosAuxiliares {

    public int contarBolasPorDelante(int posicion, ArrayList<Bola> ristraBolas, int acumulador2) {//cuenta las bolas que hay despues del disparo iguales a la bola disparada(cuenta la bola disparada)
        for (int i = posicion - 1; i >= 0; i--) {
            try {
                if (ristraBolas.get(posicion).getColor().equals(ristraBolas.get(i).getColor())) {
                    acumulador2++;
                } else {
                    break;
                }
            } catch (Exception ex) {
                //no hace nada, impide que el programa rompa si intenta acceder a una posicion inexistente
            }
        }
//        System.out.println("der: " + (acumulador2 - 1) + " " + ristraBolas.get(posicion).getColor());
        return acumulador2;
    }

    public int contarBolasDetras(int posicion, ArrayList<Bola> ristraBolas, int acumulador, int longitud) {//cuenta las bolas que hay antes del disparo iguales a la bola disparada(cuenta la bola disparada)
        for (int i = posicion + 1; i <= longitud; i++) {
            try {
                if (ristraBolas.get(posicion).getColor().equals(ristraBolas.get(i).getColor())) {
                    acumulador++;
                } else {
                    break;
                }
            } catch (Exception ex) {
                //no hace nada, impide que el programa rompa si intenta acceder a una posicion inexistente
            }
        }
//        System.out.println("izq: " + (acumulador - 1) + " " + ristraBolas.get(posicion).getColor());
        return acumulador;
    }

    public int pedirPosicion(int longitud) throws FueraDeRango {//Metodo para pedir la posicion en la que insertar la bola disparada
        boolean numero = true;
        int posicion = 0;
        do {
            numero = true;
            try {
                posicion = Pedir.pedirInt("A que posicion quiere disparar?") - 1;//indicar la posicion a la que disparar
            } catch (NumberFormatException ex) {
                System.out.println("No es una posicion");
                numero = false;
            }
        } while (numero != true);
        if (posicion < 0) {//comprueba que el disparo sea a la ristra de bolas y si no lanza una excepcion fuera de rango
            throw new FueraDeRango("Disparo fallido");
        }
        if (posicion > longitud) {//comprueba que el disparo sea a la ristra de bolas y si no lanza una excepcion fuera de rango
            throw new FueraDeRango("Disparo fallido");
        }
        return posicion;
    }
}
