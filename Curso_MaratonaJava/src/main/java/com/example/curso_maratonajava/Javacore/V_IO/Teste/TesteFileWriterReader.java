package com.example.curso_maratonajava.Javacore.V_IO.Teste;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteFileWriterReader {

    public static void main(String[] args) {
        
        File file = new File("Arquivo.txt");
        
        try {
            //Escrevendo no arquivo...
            FileWriter fw = new FileWriter(file); //Para adicionar e não sobescrever o texto, precisamos colocar o true no 2º par - o valor padrão e false e se false, vai sobescrever.
            fw.write("Escrevendo no arquivo...\nPulando linha...\n"); //Escreve no arq.
            fw.flush(); //Envia ou Gospe tudo do buff para o arq.
            fw.close(); //Fecha o arq.
            
            //Lendo o arquivo...
            FileReader fr = new FileReader(file);
            char[] in = new char[500]; //cria um array de caracteres com tam 500
            int size = fr.read(in); //ret. o tamanho do arquivo
            System.out.println("Tamanho: " + size);
            for(char c:in){
                System.out.print(c);
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(TesteFileWriterReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
