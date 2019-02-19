package Codigo;

import Excepciones.FueraDeRango;
import java.util.ArrayList;

public interface IRistra {
    void nuevaBola(Bola bola);
    int longitud();
    void mostrarAñadiendoDerecha();
    ArrayList<Bola> invertir();
    void mostrarSegunVanSaliendo(ArrayList<Bola> bola);
    ArrayList<Bola> disparar(Bola bola)throws FueraDeRango ;
    void explotar(int posicion, int acumulador, int acumulador2);
    void puntuacion(int bolasJuntas);
}
