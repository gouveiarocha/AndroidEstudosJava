package com.example.curso_maratonajava.Javacore.W_NIO.Teste;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteResolvendo {

    public static void main(String[] args) {
        
        Path dir = Paths.get("D:\\Teste\\Teste2\\Teste3");
        Path arq = Paths.get("Teste4\\Arquivo.txt");
        Path result = dir.resolve(arq); //O método .resolve junta os paths.
        System.out.println(result); 
        
    }
    
}
