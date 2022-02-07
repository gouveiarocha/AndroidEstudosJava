package com.example.curso_maratonajava.Javacore.Y_Colecoes.Teste;

import com.example.curso_maratonajava.Javacore.Y_Colecoes.Celular;

import java.util.ArrayList;
import java.util.List;

public class TesteListObject {
    
    public static void main(String[] args) {
        
        Celular celular1 = new Celular("MotoG", "5986");
        Celular celular2 = new Celular("Galaxy", "4589");
        
        List<Celular> listaCelulares = new ArrayList<>();
        listaCelulares.add(celular1);
        listaCelulares.add(celular2);
        
        for (Celular c : listaCelulares) {
            System.out.println(c);
        }
        
    }
    
}
