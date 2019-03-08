package ficheroPuntuaciones;

public class Usuario implements Comparable {

    private String nick;
    private int puntuacion;

    public Usuario(String nick, int puntuacion) {
        this.nick = nick;
        this.puntuacion = puntuacion;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return nick + " " + puntuacion;
    }

    @Override
    public int compareTo(Object t) {
        Usuario o = (Usuario) t;
        if (this.puntuacion < o.puntuacion) {
            return 1;
        }
        if (this.puntuacion > o.puntuacion) {
            return -1;
        }
        return 0;
    }
}
