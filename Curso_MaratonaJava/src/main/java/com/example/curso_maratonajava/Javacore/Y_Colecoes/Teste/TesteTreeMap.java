package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TesteTreeMap {

    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A", "Letra A");
        map.put("C", "Letra C");
        map.put("B", "Letra B");
        map.put("D", "Letra D");
        
        //O TreeMap usa o comparator da key, portanto, mesmo estando fora de ordem, vai imprimir na ordem.
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        //Métodos...
        System.out.println(map.headMap("C",true)); //...vai retornar os valores menores do que a chave inserida no método.
                                              //...o par. boolean indica: default(false) -> quer excluir a chave inserida. true -> vai incluir a chave inserida no resultado  
    }
}
