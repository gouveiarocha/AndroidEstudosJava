package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import com.example.curso_maratonajava.Javacore.Y_Colecoes.Produto;
import com.example.curso_maratonajava.Javacore.Y_Colecoes.Produto_NOME_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteBinarySearch {
    
    public static void main(String[] args) {
        
        List<Integer> numeros = new ArrayList<>();
        numeros.add(4);
        numeros.add(0);
        numeros.add(2);
        numeros.add(3);
        
        //(0,1,2,3)
        //(0,2,3,4)
        
        //(-(ponto de inserção) -1)
        Collections.sort(numeros);
        System.out.println("Indice: " + Collections.binarySearch(numeros,3) +                   //ret. indice
                           " - Valor: "  + numeros.get(Collections.binarySearch(numeros, 3)));  //ret. valor
        
        //Exemplo com objeto...
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Mouse",        "45681",    20.50));
        produtos.add(new Produto(2, "Teclado",      "25846",    35.90));
        produtos.add(new Produto(3, "Grampeador",   "15846",    10.35));
        Collections.sort(produtos, new Produto_NOME_Comparator());
        produtos.add(new Produto(4, "Monitor",      "58879",    150.00));
        System.out.println("Indice: " + Collections.binarySearch(produtos, produtos.get(0),new Produto_NOME_Comparator()) + 
                           " - Valor: " + produtos.get(Collections.binarySearch(produtos, produtos.get(0),new Produto_NOME_Comparator())));
        
    }
    
}
