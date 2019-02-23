package Utilidades;

public class DarColores {

    public String DarColores(int color) {
        switch (color) {
            case 1:
                return ("\033[31m*\033[30m");

            case 2:
                return ("\033[32m*\033[30m");

            case 3:

                return ("\033[34m*\033[30m");
            case 4:

                return ("\033[33m*\033[30m");
            default:
                break;
        }
        return "Error";
    }
}
