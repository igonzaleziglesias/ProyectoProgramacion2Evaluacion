package Codigo;

public class Bola{

    private int n;
    private String color;

    public Bola() {
        this.n = ((int) (Math.random() * 4) + 1);
        switch (n) {
            case 1:
                this.color = "R";
                break;
            case 2:
                this.color = "V";
                break;
            case 3:
                this.color = "A";
                break;
            case 4:
                this.color = "Z";
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
        return color ;
    }


    
    

}
