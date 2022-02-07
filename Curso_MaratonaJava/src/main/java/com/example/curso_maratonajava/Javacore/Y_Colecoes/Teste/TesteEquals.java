package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import com.example.curso_maratonajava.Javacore.Y_Colecoes.Celular;

import java.util.Objects;

public class TesteEquals {
    
    public static void main(String[] args) {
        
        //Método equals
        String nome1 = "Douglas";
        String nome2 = new String("Douglas");
        System.out.println(nome1 == nome2);         //false.
        System.out.println(nome1.equals(nome2));    //true.
        
        //Comparando objetos com equals diferentes.
        Celular celular1 = new Celular("REDMI5", "02468");
        Celular celular2 = new Celular("RED5", "02468");
        System.out.println("Usando o metodo equals da classe Objects:       " + Objects.equals(celular1, celular2));  
        System.out.println("Usando o equals sobescrito e criado pela IDE:   " + celular1.equals(celular2));
        System.out.println("Usando o equals criado manualmente:             " + celular1.meuEquals(celular2));
        
    }
    
}
