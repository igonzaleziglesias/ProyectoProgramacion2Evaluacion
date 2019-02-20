package Codigo;
import Utilidades.DarColores;
public class Bola{

    private int n;
    private String color;
    private String bolita;

    public Bola() {
        DarColores color = new DarColores();
        this.n = ((int) (Math.random() * 4) + 1);
        switch (n) {
            case 1:
                this.color = "R";
                this.bolita=color.DarColores(1);
                break;
            case 2:
                this.color = "V";
                this.bolita=color.DarColores(2);
                break;
            case 3:
                this.color = "A";
                this.bolita=color.DarColores(3);
                break;
            case 4:
                this.color = "Z";
                this.bolita=color.DarColores(4);
                break;
            default:
                break;
        }
    }

    public int getN() {
        return n;
    }

    public String getColor() {
        return color;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return bolita ;
    }


    
    

}
