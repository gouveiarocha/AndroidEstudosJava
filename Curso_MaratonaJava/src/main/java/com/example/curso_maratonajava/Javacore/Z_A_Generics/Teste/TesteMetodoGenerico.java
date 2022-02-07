package com.example.curso_maratonajava.Javacore.Z_A_Generics.Teste;

import java.util.ArrayList;
import java.util.List;

public class TesteMetodoGenerico {
    
    public static void main(String[] args) {
        
        criarArrayList(new Cachorro());
        
        List<Cachorro> listaCachorro = criarArrayListComRetorno(new Cachorro());
        System.out.println(listaCachorro);
        
    }
    
    //Métodos para criar um ArrayList, onde o tipo do ArrayList será definido pela chamada do método.
    
    public static <T> void criarArrayList(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
    }
    
    public static <T> List<T> criarArrayListComRetorno(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        return lista;
    }
    
    //No Caso abaixo, o tipo esta limitado as classes e subclasses de Animal.
    public static <T extends Animal> void criarArrayListLimitado(T t){
        List<T> lista = new ArrayList<>();
        lista.add(t);
        System.out.println(lista);
    }
    
}
