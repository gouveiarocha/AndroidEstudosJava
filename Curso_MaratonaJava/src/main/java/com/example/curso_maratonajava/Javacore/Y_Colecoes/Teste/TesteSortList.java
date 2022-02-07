package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteSortList {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        nomes.add("Douglas");
        nomes.add("Gouveia");
        nomes.add("Caroline");
        nomes.add("Marcheti");
        
        Collections.sort(nomes);    //Ordena Default - no caso de Strings, por ordem alfabetica. Inteiros, do menos para o maior - e etc...

        for (String n : nomes) {
            System.out.println(n);
        }

    }

}
