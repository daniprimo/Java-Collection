package br.dio.com.collections.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1","0","4","1","2","3","9","9","6","5");

        System.out.println("Imprima todos elementos dessa lista de string: Reference Method");
        numerosAleatorios.forEach(System.out::println);
//        numerosAleatorios.forEach(c -> System.out.println(c));

            //forma convencional
//        numerosAleatorios.stream().forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
        System.out.println("Pegue os 5 ultimos e coloque dentro de um set: ");
/*
* Limiti(). -> ele limita as casas dos vetores
* collect() -> ele coleta as casas dos vetores separados
* Foreaxh() -> que realiza aimpressão dos dados
* */
        numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);
      Set<String> numerosAleatoriosset = numerosAleatorios.stream().limit(5).collect(Collectors.toSet());

        System.out.println("Transforme esta lista de String em uma lista de numeros inteiros: ");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        List<Integer> numerosAleatoriosTransformado = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

//        numerosAleatorios.stream()
//                .mapToInt(new ToIntFunction<String>() {
//                    @Override
//                    public int applyAsInt(String s) {
//                        return Integer.parseInt(s);
//                    }
//                })


        System.out.println("Pegue os numeros pares e maior que 2 e coloque em uma lista: ");

        List<Integer> numerosAleatoriosInteiro = numerosAleatorios.stream()
                .map(Integer::parseInt)
                //predicate para devificar os numeros que serão separados
                .filter(i -> i %2 == 0 && i > 2)
                .collect(Collectors.toList());
        System.out.println(numerosAleatoriosInteiro);


//        filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer i) {
//                if (i %2 == 0 && i > 2) return true;
//                return false;
//            }
//        })


        System.out.println("Mostre as media dos numeros: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()//eviatar retorna valor null
                .ifPresent(System.out::println);



//        ifPresent(new DoubleConsumer() {
//            @Override
//            public void accept(double v) {
//                System.out.println(v);
//            }
//        });

        System.out.println("Remova os numeros impares");
        numerosAleatoriosInteiro.removeIf(i -> (i %2 != 0));
        System.out.println(numerosAleatoriosInteiro);

//        numerosAleatoriosInteiro.removeIf(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                if (integer %2 != 0)return true;
//                return false;
//            }
//        });

    }
}
