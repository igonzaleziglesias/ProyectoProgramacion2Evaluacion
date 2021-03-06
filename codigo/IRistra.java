package codigo;

import bolasDelJuego.Bola;
import excepciones.FueraDeRango;
import excepciones.ListaVacia;
import java.util.ArrayList;

public interface IRistra {//metodos esenciales de la ristra
   public abstract void nuevaBola(Bola bola);
   public abstract void mostrarConFormato(ArrayList<Bola> bola);
   public abstract ArrayList<Bola> disparar(Bola bola,int pos)throws FueraDeRango,ListaVacia ;
   public abstract void explotar(int posicion, int acumulador, int acumulador2) throws ListaVacia;
   public abstract int puntuacion(int bolasJuntas);
   public abstract int puntuacionConcatenacion();
  
}
