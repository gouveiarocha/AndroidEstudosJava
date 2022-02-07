package com.example.curso_maratonajava.Javacore.W_NIO.Teste;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteNormalizacao {

    public static void main(String[] args) {

        String dir = "D:\\Pasta\\SubPasta\\OutraPasta";
        String arq = "..\\..\\arquivo.txt";
        Path p1 = Paths.get(dir, arq);
        System.out.println(p1);
        System.out.println(p1.normalize()); //Normalizado. - o método conheçe a instrução de voltar através do '..\'
        
        Path p2 = Paths.get("D:home/./Pasta/./SubPasta/./Dev");
        System.out.println(p2);
        System.out.println(p2.normalize()); //Normalizado.
    }

}
