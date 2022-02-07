package com.example.curso_maratonajava.Javacore.W_NIO.Teste;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class TesteFileVisitor {

    //Neste caso, vamos trabalhar para que o sistema percorra as pastas, subpastas e arquivos, e busque apenas um determinado tipo de arquivo.
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("NovaPasta\\DirectoryStream");

        //Metodo walkFileTree recebe um Path e um método FileVisit, neste casso sobrecarregado pela classe que criamos.
        //Files.walkFileTree(path, new AcharTodosBkp());
        Files.walkFileTree(path, new ImprimeDiretorios());

    }

}

/**
 * Vamos criar as classes abaixo para sobrecarregar e customizar os método
 * FileVisitResult... *
 */

//EX visitFile...
class AcharTodosBkp extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

        //System.out.println(file.getFileName()); //Aqui vai pegar todos os arquivos.
        //Aqui somente os arquivos .bkp
        if (file.getFileName().toString().endsWith(".bkp")) { //Pega o nome do arquivo, converte para String e pega retorna true se o final for .bkp
            System.out.println(file.getFileName());
        }

        return FileVisitResult.CONTINUE;            //Percorre todos as pastas, subpastas e arquivos.
        //return FileVisitResult.SKIP_SIBLINGS;
        //return FileVisitResult.SKIP_SUBTREE;
        //return FileVisitResult.TERMINATE;

    }
}

//Demais exemplos:
class ImprimeDiretorios extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("Pre: " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("File: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.println("Post: " + dir);
        return FileVisitResult.CONTINUE;
    }

}
