package br.dio.com.collections.map;

import java.util.*;

public class ordenacao {
    public static void main(String[] args) {
        System.out.println("Ordenação Aleatoria");
        Map<String, Livros> meusLivros = new HashMap<>() {{
            put("Haking Stephen", new Livros("Uma Breve Historia do tempo",256));
            put("Dubbig CHarles", new Livros("O poder do habito", 408));
            put("Harari Vuayal", new Livros("21 lições para o seculo 21", 432));
        }};
        //para passar o nome do autor e livro somente utlizaremos um for each
        for (Map.Entry<String, Livros> livro : meusLivros.entrySet()) {
            System.out.println(livro.getKey() + " - "+ livro.getValue().getNome());
        }
        System.out.println("******************************************************");

        System.out.println("Ordenação Inserção");
        Map<String, Livros> meusLivros2 = new LinkedHashMap<>() {{
            put("Haking Stephen", new Livros("Uma Breve Historia do tempo",256));
            put("Dubbig CHarles", new Livros("O poder do habito", 408));
            put("Harari Vuayal", new Livros("21 lições para o seculo 21", 432));
        }};
        for (Map.Entry<String, Livros> livro : meusLivros2.entrySet()){
            System.out.println(livro.getKey() + " - "+ livro.getValue().getNome());
        }
        System.out.println("******************************************************");

        System.out.println("Ordenação Alfabetica Autores");
        Map<String, Livros> meusLivros3 = new TreeMap<>(meusLivros2);
        for (Map.Entry<String, Livros> livro : meusLivros3.entrySet()){
            System.out.println(livro.getKey() + " - "+ livro.getValue().getNome());
        }
        System.out.println("******************************************************");

        System.out.println("Ordenação Alfabetica Livros");
        //para realziar a ordenação pelo os nomes dos livros deve se utilizar o Set
        Set<Map.Entry<String, Livros>> meusLivros4 = new TreeSet<>(new comparatorNome());//deve se criar uma classe comparetor para realizar operação
        //para atribuir valor ao SetcomMap
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livros> livro : meusLivros4){
            System.out.println(livro.getKey() + " - "+ livro.getValue().getNome());
        }
        System.out.println("******************************************************");

        System.out.println("Ordenação por numero de pagina");
        Set<Map.Entry<String, Livros>> meusLivros5 = new TreeSet<>(new comparaPagina());
        meusLivros5.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livros> livro : meusLivros5){
            System.out.println(livro.getKey() + " - "+ livro.getValue().getNome() + " " + livro.getValue().getPaginas());
        }


        System.out.println("******************************************************");

    }
}

class Livros {

    private String nome;
    private  Integer paginas;

    public Livros(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livros livros = (Livros) o;
        return nome.equals(livros.nome) && paginas.equals(livros.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livros{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class  comparatorNome implements Comparator<Map.Entry<String, Livros>> {

    @Override
    public int compare(Map.Entry<String, Livros> l1, Map.Entry<String, Livros> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}


class  comparaPagina implements Comparator<Map.Entry<String,Livros>> {

    @Override
    public int compare(Map.Entry<String, Livros> l1, Map.Entry<String, Livros> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}