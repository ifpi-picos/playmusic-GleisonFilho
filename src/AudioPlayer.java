import javax.sound.sampled.*;
import java.io.File;
import Dominio.*;

public class AudioPlayer {
    private Clip audioClip;
    boolean isPlaying = false;
    private int currentTrack = 0;
    private Album currentAlbum;
    public String musicName = "Pagodim";

    public AudioPlayer(Album album){
        this.currentAlbum = album;
    }

    public void loadAudio(String filepath){
        try {
            File audioFile = new File(filepath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);

            System.out.println(audioFile);

            audioClip.open(audioStream);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro ao carregar o audio");
        }
    }

    public void playAudio(){
        if(audioClip != null && !isPlaying){
            audioClip.setFramePosition(0);
            audioClip.start();
            isPlaying = true;
        }
    }

    public void stopAudio(){
        if(audioClip != null && isPlaying){
            audioClip.stop();
            isPlaying = false;
        }
    }

    public String nextTrack() {
        if (currentTrack < currentAlbum.getMusicas().size() - 1) {
            currentTrack++;
            this.isPlaying = true;
            this.musicName = currentAlbum.getMusicas().get(currentTrack).getNome();
            stopAudio();
            loadAudio(currentAlbum.getMusicas().get(currentTrack).getArquivoAudio());
            playAudio();
            
        }
                return currentAlbum.getMusicas().get(currentTrack).getNome();
    }

    public void prevTrack() {
        if (currentTrack > 0) {
            currentTrack--;
            this.isPlaying = true;
            stopAudio();
            loadAudio(currentAlbum.getMusicas().get(currentTrack).getArquivoAudio());
            playAudio();
        }
    }
}