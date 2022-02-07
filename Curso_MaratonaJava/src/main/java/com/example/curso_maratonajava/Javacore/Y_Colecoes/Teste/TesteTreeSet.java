package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;


import com.example.curso_maratonajava.Javacore.Y_Colecoes.Celular;
import com.example.curso_maratonajava.Javacore.Y_Colecoes.Produto;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class CelularNomeComparator implements Comparator<Celular>{

    @Override
    public int compare(Celular o1, Celular o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
    
}

public class TesteTreeSet {
    
    public static void main(String[] args) {
        
        //Exemplo com a classe Celular. O Navset requer implementação de um Comparator.
        Celular c1 = new Celular("MI8", "12345");
        
        NavigableSet<Celular> celuNavSet = new TreeSet<>(new CelularNomeComparator());
        celuNavSet.add(c1);
        for (Celular c : celuNavSet) {
            System.out.println(c);
        }
        
        //Agora exercitando. A classe Produto já implementa um comparator.
        Produto p1 = new Produto(1, "Mouse",        "45681",    20.50,  10);
        Produto p2 = new Produto(2, "Teclado",      "25846",    35.90,  0);
        Produto p3 = new Produto(3, "Grampeador",   "15846",    10.35,  30);
        Produto p4 = new Produto(4, "Monitor",      "58879",    150.00, 0);
        
        NavigableSet<Produto> prodNavSet = new TreeSet<>();
        
        prodNavSet.add(p1);
        prodNavSet.add(p2);
        prodNavSet.add(p3);
        prodNavSet.add(p4);
        
        for (Produto p : prodNavSet) {
            System.out.println(p);
        }
        
        //Metodos
        //lower <
        //floor <=
        //higher >
        //celiling >=
        
        System.out.println(prodNavSet.lower(p2));
        
    }
    
}
