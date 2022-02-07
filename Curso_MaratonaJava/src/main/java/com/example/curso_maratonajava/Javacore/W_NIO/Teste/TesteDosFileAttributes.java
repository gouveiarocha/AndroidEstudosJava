package com.example.curso_maratonajava.Javacore.W_NIO.Teste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class TesteDosFileAttributes {

    public static void main(String[] args) throws IOException {
        
        //DosFileAttributes - apenas leitura.
        Path path = Paths.get("NovaPasta\\NovoArquivoTesteDos.txt");
        //Files.createFile(path);
        Files.setAttribute(path, "dos:hidden", false);   //Seta o arquivo como oculto.
        Files.setAttribute(path, "dos:readonly", false); //Seta o arquivo para somente leitura.
        DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dos.isArchive());    //é um arquivo...
        System.out.println(dos.isHidden());     //oculto...
        System.out.println(dos.isReadOnly());   //apenas leitura...
        System.out.println("------------------------------------------");
        //Files.delete(path);
        
        //DosFileAtrributeView - modificando.
        DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        dosView.setHidden(true);        //Seta para arquivo oculto.
        dosView.setReadOnly(true);      //Seta para somente leitura.
        dos = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dos.isArchive());    //é um arquivo...
        System.out.println(dos.isHidden());     //oculto...
        System.out.println(dos.isReadOnly());   //apenas leitura...
        
    }
    
}
