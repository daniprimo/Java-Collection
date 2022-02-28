package br.dio.com.collections.set;

import java.util.*;

public class OrdemDeElementos {
    public static void main(String[] args) {
        System.out.println("Ordem Aleatoria");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("Got","Fantasia", 60 ));
            add(new Serie("Dark","Drama", 60 ));
            add(new Serie("That '70 Show","Comedia", 25 ));
        }};

        for (Serie serie:minhasSeries) {
            System.out.println(serie.getNome()+ " - "+serie.getGenero()+" - "+serie.getTempoEpisodio());
        }

        System.out.println("Ordem Natural (Tempo de Episodio)");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries);
        for (Serie serie:minhasSeries2) {
            System.out.println(serie.getNome()+ " - "+serie.getGenero()+" - "+serie.getTempoEpisodio());
        }

        System.out.println("Ordem nome/Gênero/tempoEpisodio");
        Set<Serie> minhasSerie3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSerie3.addAll(minhasSeries);
        for (Serie serie: minhasSerie3) {
            System.out.println(serie.getNome()+ " - "+serie.getGenero()+" - "+serie.getTempoEpisodio());

        }









    }
}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());

    }
}


class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}