package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nome;
    private List<Musica> musicas = new ArrayList<>();

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public List<Musica> getMusicas(){
        return musicas;
    }

    public void addMusica(Musica musica){
        musicas.add(musica);
    }

    public void addMusicas(List<Musica> musicas){
            this.musicas.addAll(musicas);
    }
    
}