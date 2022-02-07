package com.example.curso_maratonajava.Javacore.W_NIO.Teste;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteDirectoryStream {

    public static void main(String[] args) {

        Path dir = Paths.get("NovaPasta\\DirectoryStream");
        
        //DirectoryStream - recupera os arquivos dentro de um dir especifico.
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) { //Instancia um objeto do tipo DirectoryStream
            //Agora, em um for, vamos criar uma var de ref. do tipo Path e percorrer com o objeto stream.
            for(Path paths : stream){
                System.out.println(paths.getFileName());   //imprimindo os arquivos encontrados.
            }
        } catch (IOException ex) {
            Logger.getLogger(TesteDirectoryStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
