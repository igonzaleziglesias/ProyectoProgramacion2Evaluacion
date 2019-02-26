package Sonido;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SonidoExplotar {

    public SonidoExplotar(){
        try {
            Clip sonido = AudioSystem.getClip();
            File a = new File("Balloon.wav.wav");
//            File a = new File("/home/local/DANIELCASTELAO/igonzaleziglesias/Escritorio/Balloon.wav");
            sonido.open(AudioSystem.getAudioInputStream(a));
            sonido.start();
//            System.out.println("Reproduciendo 0.2s. de sonido...");
            Thread.sleep(200); // 200 milisegundos (0.2segundos)
            sonido.close();
        } catch (Exception tipoError) {
            System.out.println("" + tipoError);
        }
    }
}
