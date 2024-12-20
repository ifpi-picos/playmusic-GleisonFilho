import Dominio.Musica;
import Dominio.Album;
import Dominio.Artista;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class App {  
    public static String musicName = "Depressão";
    public static void main(String[] args) throws Exception {

        Musica musica1 = new Musica("PÉRICLES - ATÉ QUE DUROU (AO VIVO) - VÍDEO OFICIAL", 310, "src\\Ativos\\AteQueDurou.wav", "Pagode");
        Musica musica2 = new Musica("Sozinho", 203, "src\\Ativos\\Sozinho.wav", "Pagode");
        Musica musica3 = new Musica("Você Não Me Ensinou A Te Esquecer", 212, "src\\Ativos\\VCNME.wav", "MPB");

        Album album1 = new Album();
        album1.setNome("Pagodeira");
        album1.addMusica(musica1);
        album1.addMusica(musica2);
        album1.addMusica(musica3);

        Artista Pericles = new Artista();
        Pericles.setNome("Pericles");
        Pericles.addAlbum(album1);

        AudioPlayer player = new AudioPlayer(album1);
        player.loadAudio(musica1.getArquivoAudio());

        // Criação dos botões com ícones
        JButton prevButton = new JButton(new ImageIcon("src\\Ativos\\Imagens\\previous.png"));
        prevButton.setToolTipText("Voltar");

        JButton playStopButton = new JButton(new ImageIcon("src\\Ativos\\Imagens\\play.png"));
        playStopButton.setToolTipText("Pausar");

        JButton nextButton = new JButton(new ImageIcon("src\\Ativos\\Imagens\\next.png"));
        nextButton.setToolTipText("Próxima");

        playStopButton.addActionListener(_ -> {
            if (player.isPlaying) {
                player.stopAudio();
                playStopButton.setIcon(new ImageIcon("src\\Ativos\\Imagens\\play.png"));
            } else {
                player.playAudio();
                playStopButton.setIcon(new ImageIcon("src\\Ativos\\Imagens\\pause.png"));
            }
        });

        nextButton.addActionListener(_ -> {
            player.nextTrack();
            playStopButton.setIcon(new ImageIcon("src\\Ativos\\Imagens\\pause.png"));
        });

        prevButton.addActionListener(_ -> {
            player.prevTrack();
            playStopButton.setIcon(new ImageIcon("src\\Ativos\\Imagens\\pause.png"));
        });

        ImageIcon icon = new ImageIcon("src\\Ativos\\Imagens\\image.png");
        JOptionPane.showOptionDialog(
            null,
            player.musicName,
            "Músicas",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            icon,
            new Object[]{prevButton, playStopButton, nextButton},
            nextButton
        );
    }
}