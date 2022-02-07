package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import com.example.curso_maratonajava.Javacore.Y_Colecoes.Consumidor;

import java.util.PriorityQueue;
import java.util.Queue;

public class TesteQueue {

    public static void main(String[] args) {
        
        //O Queue e PriorityQueue sempre usa o comparable para ordenar os resultados. Caso use uma classe sem o Comparable, ocorrerá erro em tempo de ex.
        //O Queue funciona como uma fila. Com a lógica de 1 a entrar -> 1 a sair. Não possui indice.
        
        //EX1 (vai funcionar)
        Queue<String> queue = new PriorityQueue<>();
        queue.add("C");
        queue.add("D");
        queue.add("A");
        queue.add("B");
        System.out.println(queue); //...vai ordenar automaticamente. A B C D
        queue.peek(); //Retorna e remove o 1º elemento.
        queue.poll(); //Retorna e não remove o 1º elemento
        System.out.println(queue); //...B C D

        //EX2 (não vai funcionar se houver mais de 1 registro)
        Queue<Consumidor> queue2 = new PriorityQueue<>();
        Consumidor consumidor = new Consumidor("Douglas", "122");
        Consumidor consumidor2 = new Consumidor("DevDojo", "321");
        queue2.add(consumidor);
        //queue2.add(consumidor2);
        //System.out.println(queue2);
    }
}
