package com.example.curso_maratonajava.Javacore.W_NIO.Teste;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteRelativizando {

    public static void main(String[] args) {

        Path dir = Paths.get("/douglas/teste");
        Path classe = Paths.get("/douglas/teste/java/Pessoa.class");

        //O método .relativize relaciona os paths, eliminando o que for igual, ou relativo.
        Path pathToClasse = dir.relativize(classe);
        System.out.println(pathToClasse);

    }

}
