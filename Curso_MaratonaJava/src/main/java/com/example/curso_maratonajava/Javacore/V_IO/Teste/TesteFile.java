package com.example.curso_maratonajava.Javacore.V_IO.Teste;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteFile {
    
    public static void main(String[] args) {
        
        //Classe File
        File file = new File("Arquivo.txt"); //cria um obj do tipo File.
        try {
            System.out.println("O arquivo foi criado: " + file.createNewFile());
            System.out.println("O arquivo existe: " + file.exists());
            System.out.println("O arquivo tem permissão de leitura: " + file.canRead());
            System.out.println("O arquivo tem permissão de escrita: " + file.canWrite());
            System.out.println("Path: " + file.getPath());
            System.out.println("Path Absoluto: " + file.getAbsolutePath());
            System.out.println("Diretorio: " + file.isDirectory());
            System.out.println("Arquivo: " + file.isFile());
            System.out.println("Esta oculto: " + file.isHidden());
            System.out.println("Ult. modificação: " + new Date(file.lastModified()));
            if(file.exists()){
                System.out.println("Deletou: " + file.delete()); //Deleta o arquivo se o mesmo existir.
            }
        } catch (IOException ex) {
            Logger.getLogger(TesteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
