package br.dio.com.collections;

import com.sun.jdi.InvalidLineNumberException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExercicioTemperatura {
    public static void main(String[] args) {
        List<Mes> temperaturaDoMes = new ArrayList<>(){{
                boolean opcao = false;
                while (!opcao) {
                    try {
                        add(new Mes(1, "Janeiro", JOptionPane.showInputDialog("Insira a temperatura de Janeiro: ")));
                        add(new Mes(2, "Fevereiro", JOptionPane.showInputDialog("Insira a temperatura de Fevereiro: ")));
                        add(new Mes(3, "Março", JOptionPane.showInputDialog("Insira a temperatura de Março: ")));
                        add(new Mes(4, "Abriu", JOptionPane.showInputDialog("Insira a temperatura de Abriu: ")));
                        add(new Mes(5, "JUnho", JOptionPane.showInputDialog("Insira a temperatura de Junho: ")));
                        add(new Mes(6, "Julho", JOptionPane.showInputDialog("Insira a temperatura de Julho: ")));
                        opcao = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada invalida digite um numero inteiro");
                    }
                }

        }};

        System.out.println("Temperatura dos 6 primeiros meses: ");
        System.out.println(temperaturaDoMes);

        Iterator<Mes> iterator = temperaturaDoMes.iterator();
        double soma = 0d;
        while (iterator.hasNext()){
            Mes next = iterator.next();
            soma += next.getTemperatura();
        }

        System.out.println("A media Semestral da temperatura é: "+ (soma/ temperaturaDoMes.size()));

        double media = soma/temperaturaDoMes.size();
        Iterator<Mes> iterator2 = temperaturaDoMes.iterator();

        while (iterator2.hasNext()){
            Mes next = iterator2.next();

            if (next.getTemperatura() < media) iterator2.remove();

        }

        System.out.println("Meses que a temperatura que estão acima da media ");
        System.out.println(temperaturaDoMes);

    }

}

class Mes {
        private Integer referenciaMes;
        private String mes;
        private Integer temperatura;

    public Mes(Integer referenciaMes, String mes, String temperatura) {
        this.referenciaMes = referenciaMes;
        this.mes = mes;
        this.temperatura = Integer.valueOf(temperatura);
    }

    public Integer getReferenciaMes() {
        return referenciaMes;
    }

    public void setReferenciaMes(Integer referenciaMes) {
        this.referenciaMes = referenciaMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Mes{" + referenciaMes +
                "-" + mes +
                " temperatura: " + temperatura +
                '}';
    }


}
