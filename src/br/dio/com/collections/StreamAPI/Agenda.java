package br.dio.com.collections.StreamAPI;

import java.util.*;
import java.util.function.Function;

public class Agenda {
    public static void main(String[] args) {
        System.out.println("Ordem Aleatoria");
        Map<Integer, Contato> agenda = new HashMap<>(){{
           put(1, new Contato("Daniel",985850569));
           put(8, new Contato("Ana",998715554));
           put(6, new Contato("Helaine",937772509));
           put(3, new Contato("Paulo",940457187));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()){
            System.out.println(entry.getKey() +" - "+ entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

        System.out.println("Ordem INserção");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
            put(1, new Contato("Daniel",985850569));
            put(8, new Contato("Mauro",998715554));
            put(6, new Contato("Helaine",937772509));
            put(3, new Contato("Paulo",940457187));
        }};
        System.out.println(agenda1);
        for (Map.Entry<Integer, Contato> entry : agenda1.entrySet()){
            System.out.println(entry.getKey() +" - "+ entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

        System.out.println("Ordem correta pelo ID");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda1);
        System.out.println(agenda2);
        for (Map.Entry<Integer, Contato> entry : agenda2.entrySet()){
            System.out.println(entry.getKey() +" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

        //seria feito sem o auxio das stream pelo Set e a classe criada para compara
        // mas vamos realizar com classe anonima
        System.out.println("Ordem de telefone - Classe Anonima");         //classe anonima
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
                return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
            }
        });
        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : set){
            System.out.println(entry.getKey() +" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

        System.out.println("Ordem de telefone - Interface Funcional");         //classe anonima
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(new Function<Map.Entry<Integer, Contato>, Integer>() {
            @Override
            public Integer apply(Map.Entry<Integer, Contato> cont) {
                return cont.getValue().getNumero();
            }
        }));
        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : set1){
            System.out.println(entry.getKey() +" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

        System.out.println("Ordem de telefone - Lambda");         //classe anonima
        Set<Map.Entry<Integer, Contato>> set2 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero()));
        set2.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : set2){
            System.out.println(entry.getKey() +" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());
        }

        System.out.println("Ordem Nome do contato");
        Set<Map.Entry<Integer, Contato>> set3 = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNome()));
        set3.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : set3){
            System.out.println(entry.getKey() +" - "+entry.getValue().getNome()+" - "+entry.getValue().getNumero());

        }


    }
}

class Contato {
    private String nome;
    private Integer numero;

    public Contato(String nome, int numero) {
        this.nome = nome;
        this.numero = Integer.valueOf(numero);
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && numero.equals(contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}