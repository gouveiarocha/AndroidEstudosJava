package com.example.curso_maratonajava.Javacore.Z_A_Generics.Teste;

import com.example.curso_maratonajava.Javacore.Y_Colecoes.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class TesteGenerics {

    public static void main(String[] args) {
        //Observar que, até o java 4 era possivel criar uma lista em especificar o tipo e inserir varios tipos de dados nela, o que causava certos problemas.
        List list = new ArrayList();
        list.add("String");
        list.add(1L);
        list.add(new Consumidor("Douglas", "123"));

        //Agora, com Genercis, é possivel especificar o tipo de dado, prevenindo erros.
        List<String> list2 = new ArrayList<>();
        list2.add("String1");
        list2.add("String2");
        list2.add("String3");
        
        //Apesar de ser String, o código abaixo vai compilar - pois a Generics vai acusar erro somente em tempo de execução, e não compilação...
        add(list2, 5L); 
        
        //Agora, com o for, o erro, em tempo de execução irá se manifestar, pois na iteração do for ele vai encontrar um dado incompativel.
        //for (String s : list2) {
        //    System.out.println(s);
        //}
        
    }

    public static void add(List list, Long l) {
        list.add(l);
    }

}
