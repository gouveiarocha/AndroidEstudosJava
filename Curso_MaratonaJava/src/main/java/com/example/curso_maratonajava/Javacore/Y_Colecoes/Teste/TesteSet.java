package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import com.example.curso_maratonajava.Javacore.Y_Colecoes.Produto;

import java.util.HashSet;
import java.util.Set;

public class TesteSet {
    
    public static void main(String[] args) {
        
        Produto p1 = new Produto(1, "Mouse",        "45681",    20.50,  10);
        Produto p2 = new Produto(2, "Teclado",      "25846",    35.90,  0);
        Produto p3 = new Produto(3, "Grampeador",   "15846",    10.35,  30);
        Produto p4 = new Produto(4, "Monitor",      "58879",    150.00, 0);
        
        //O Set é uma lista alto desempenho para todas as operações, a principal
        //diferença entre o List e o Set, é que o List possui indice, ou seja conseguimos
        //criar um novo registro igual a outro, já o set não possui indice, logo não permite.
        
        Set<Produto> produtosSet = new HashSet<>();
        produtosSet.add(p1);
        produtosSet.add(p2);
        produtosSet.add(p3);
        produtosSet.add(p4);
        for (Produto p : produtosSet) {
            System.out.println(p);
        }
        
        
        
    }
    
}
