package br.dio.com.collections;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/
public class ExercicioProposto02 {
    public static void main(String[] args) {
        List<String> respostas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Perguntas: ");
        String resposta = JOptionPane.showInputDialog("Telefonou para vítima? ");
        respostas.add(resposta.toLowerCase());
        resposta = JOptionPane.showInputDialog("Esteve no local do crime? ");
        respostas.add(resposta.toLowerCase());
        resposta = JOptionPane.showInputDialog("Mora perto da vítima? ");
        respostas.add(resposta.toLowerCase());
        resposta = JOptionPane.showInputDialog("Devia para vítima? ");
        respostas.add(resposta.toLowerCase());
        resposta = JOptionPane.showInputDialog("Já trabalhou com a vítima? ");
        respostas.add(resposta.toLowerCase());

        System.out.println(respostas);

        int count = 0;

        //vai rodar toda a lista e contar os "s"
        Iterator<String> contador = respostas.iterator();
        while(contador.hasNext()){
            String resp = contador.next();
            if(resp.contains("s")) {
                count ++;
            }
        }

        switch(count) {
            case 2:
                System.out.println(">> SUSPEITA <<"); break;
            case 3:
            case 4:
                System.out.println(">> CÚMPLICE <<"); break;
            case 5:
                System.out.println(">> ASSASSINO <<"); break;
            default:
                System.out.println(">> INOCENTE <<"); break;
        }
    }
}

