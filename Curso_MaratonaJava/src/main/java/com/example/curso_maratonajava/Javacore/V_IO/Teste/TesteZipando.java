package com.example.curso_maratonajava.Javacore.V_IO.Teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TesteZipando {
    
    public static void main(String[] args) {
        
        //Paths...
        Path dirZip = Paths.get("Pasta");               //Path do diretorio que o zip será gravado.
        Path dirFiles = Paths.get("NovaPasta");         //Paths dos arquivos que serão compactados.
        Path zipFile = dirZip.resolve("arquivo.zip");   //Arquivo zip.
        
        try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile())); //Cria um objeto do tipo ZipOutputStream
            DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles)) {               //Stream
            for (Path path : stream){                                                          //For com o Stream para pegar o nome dos arquivos
                ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());               //Cria a entrada do arquivo zip .
                zip.putNextEntry(zipEntry);                                                    //Coloca o zipEntry dentro do zip e prepara a proxima entrada;                 
                
                FileInputStream fileInputStream = new FileInputStream(path.toFile());
                byte[] buff = new byte[2048];
                int bytesRead;
                while((bytesRead = fileInputStream.read(buff))>0){
                zip.write(buff, 0, bytesRead);
                }
                zip.closeEntry();
                fileInputStream.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(TesteZipando.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
