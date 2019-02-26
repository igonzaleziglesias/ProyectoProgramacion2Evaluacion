package Sonido;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SonidoExplotar {

    public SonidoExplotar(){
        try {
            Clip sonido = AudioSystem.getClip();
            File a = new File("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/Balloon.wav");
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.start();
            System.out.println("Reproduciendo 1s. de sonido...");
            Thread.sleep(1000); // 1000 milisegundos (1 segundos)
            sonido.close();
        } catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }
}
