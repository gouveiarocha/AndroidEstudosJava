package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import com.example.curso_maratonajava.Javacore.Y_Colecoes.Consumidor;
import com.example.curso_maratonajava.Javacore.Y_Colecoes.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TesteConsumidorMap {
    
    public static void main(String[] args) {
        
        Consumidor consumidor = new Consumidor("Douglas", "122");
        Consumidor consumidor2 = new Consumidor("DevDojo", "321");
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Mouse",        "45681",    20.50));
        produtos.add(new Produto(2, "Teclado",      "25846",    35.90));
        produtos.add(new Produto(3, "Grampeador",   "15846",    10.35));
        
        //Associar um consumidor a um produto usando o Map.
        Map<Consumidor, Produto> map = new HashMap<>();
        map.put(consumidor, produtos.get(0)); //...'Douglas compra(associa) um Mouse...'
        map.put(consumidor2, produtos.get(2)); //...'DevDojo compra(associa) um grampeador...'
        
        //Iterar e navegar para ver quem comprou e o que comprou.
        for (Map.Entry<Consumidor,Produto> entry : map.entrySet()) {
            //System.out.println(entry.getKey() + " comprou um " + entry.getValue()); //vai retorar o toString das classes
            System.out.println(entry.getKey().getNome() + " comprou um " + entry.getValue().getNome()); //vai retornar somente o nome
        }
        
        System.out.println("-------------------------------------------------------");
        
        //Complicando. Associar um consumidor a varios produtos.
        List<Produto> produtosCon = new ArrayList<>();
        produtosCon.add(produtos.get(0));
        produtosCon.add(produtos.get(1));
        
        List<Produto> produtosCon2 = new ArrayList<>();
        produtosCon2.add(produtos.get(1));
        produtosCon2.add(produtos.get(2));
        
        Map<Consumidor, List<Produto>> map2 = new HashMap<>();
        map2.put(consumidor, produtosCon);
        map2.put(consumidor2, produtosCon2);
        
        for (Map.Entry<Consumidor, List<Produto>> entry2 : map2.entrySet()) {
            System.out.println(entry2.getKey().getNome() + " comprou: ");
            for (Produto p : entry2.getValue()) {
                System.out.println(p.getNome());
            }
        }
        
    }
    
}
