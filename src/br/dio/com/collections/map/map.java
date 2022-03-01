package br.dio.com.collections.map;

import java.util.*;

public class map {
    public static void main(String[] args) {
        System.out.println("Crie um dicionario e relacione os modelos dos veiculos");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            //DIferente do list e set a operação para inseiri é diferente de add. é put.
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        //mostrar oque esta na lista utilizando o toString
        System.out.println(carrosPopulares.toString());

        System.out.println("Subistitua o consumo do gol por 15.2 km/L: ");
        //para substituir um valor e so sobreescrever como não pode ter chaver(nome) repetidos
        carrosPopulares.put("gol", 14.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo Tucson esta no dicionario: "+ carrosPopulares.containsKey("tucson"));

        System.out.println("EXiba o consumo do uno: "+ carrosPopulares.get("uno"));
        //para exibir basta puxar com o get adicionando a chave que é o nome e o mesmo resultara no valor

//        System.out.println("EXiba o Terceiro modelo adicionado: "); -> no map não tem funcionalidades para ação

        System.out.println("EXiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);
        //para mostrar todos os modelos

        System.out.println("EXiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("EXiba o modelo mais economico e seu consumo: ");
        Double consumoMiasEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry : entries){
            if (entry.getValue().equals(consumoMiasEficiente)){
                modeloMaisEficiente = entry.getKey();
            }
        }
        System.out.println("Modelo mais eficiente é "+ modeloMaisEficiente +" - "+ consumoMiasEficiente);

        System.out.println("EXiba o modelo menos economico e seu consumo: ");

        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry:carrosPopulares.entrySet()){
            if (entry.getValue().equals(consumoMenosEficiente))
                modeloMenosEficiente = entry.getKey();
        };
        System.out.println("Modelo menos eficiente: "+ modeloMenosEficiente + " - "+ consumoMenosEficiente);

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: "+ soma);

        System.out.println("EXiba a medias dos consumos deste dicionario de carros: "+ (soma/carrosPopulares.size()));

        System.out.println("Remova os modelos com o consumo igual a 15.6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba todos os carros na ordem que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            //DIferente do list e set a operação para inseiri é diferente de add. é put.
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        //mostrar oque esta na lista utilizando o toString
        System.out.println(carrosPopulares1.toString());

        System.out.println("Exiba o dicionario ordenados pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("Apague o conjunto de carros: "); carrosPopulares.clear();

        System.out.println("Confira se a lista ta vazia: "+ carrosPopulares.isEmpty());

    }
}
