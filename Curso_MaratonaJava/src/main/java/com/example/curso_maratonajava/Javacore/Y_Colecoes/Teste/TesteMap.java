package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TesteMap {
        
    public static void main(String[] args) {
        
        //Map<String,String> map = new HashMap<>();
        Map<String,String> map = new LinkedHashMap<>();
        map.put("teklado", "teclado");
        map.put("mouze", "mouse");
        map.put("vc", "você");
        map.put("vc", "você2"); //quando repetimos a key, o valor antigo é subtituido pelo novo.
        map.put("dolglas", "douglas"); //observar nas iterações, que usando o HashMap, não irá obedecer a ordem de inserção.
                                            //para resolver esse problema, basta trocar de HashMap para LinkedHashMap.
        
        //Iteração...
        System.out.println("---Iterando pela chave---");
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        
        System.out.println("---Iterando pelo valor---");
        for (String value : map.values()) {
            System.out.println(value);
        }
        
        System.out.println("---Pegando a key e o valor---");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        
    }
    
}
