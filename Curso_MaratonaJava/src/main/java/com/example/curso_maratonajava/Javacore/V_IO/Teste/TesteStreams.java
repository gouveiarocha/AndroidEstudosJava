package com.example.curso_maratonajava.Javacore.V_IO.Teste;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TesteStreams {
    
    public static void main(String[] args) {
        
        gravador();
        leitor();
        
    }
    
    //Gravar
    public static void gravador(){
        byte[] dados = {65,66,67,68,69,70};
        try(FileOutputStream gravador = new FileOutputStream("Pasta/Stream.txt")){  //1ºPar.: o Path 2ºPar.: true ou false(default) - se false, vai sobescrever o arquivo, se true, vai adicionar no final.
            gravador.write(dados);
            gravador.flush();       //O flush cospe tudo que estiver dentro do buffer antes de fecha-lo.     
            System.out.println("Dados Gravados com Sucesso.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //Gravar com buffer
    public static void gravadorTunado(){
        byte[] dados = {65,66,67,68,69,70};
        try(BufferedOutputStream gravadorBuffer = new BufferedOutputStream(new FileOutputStream("Pasta/Stream.txt"),4098)){ //O 1par é um obj do tipo FileOutputStream e o 2 é o tamanho do buffer
            gravadorBuffer.write(dados);
            gravadorBuffer.flush();         //O flush cospe tudo que estiver dentro do buffer antes de fecha-lo.     
            System.out.println("Dados Gravados com Sucesso.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //Ler
    public static void leitor(){
        try(FileInputStream leitor = new FileInputStream("Pasta/Stream.txt")){  
            int leitura;
            while((leitura = leitor.read()) != -1){ //O método .read retorna -1 quando concluir a leitura do arquivo, portanto vamos usar um while for diferente de -1.
                byte b = (byte) leitura;
                System.out.println(" " + b);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //Ler com buffer
    public static void leitorTunado(){
        try(BufferedInputStream leitorBuffer = new BufferedInputStream(new FileInputStream("Pasta/Stream.txt"),4098)){
            int leitura;
            while((leitura = leitorBuffer.read()) != -1){ //O método .read retorna -1 quando concluir a leitura do arquivo, portanto vamos usar um while for diferente de -1.
                byte b = (byte) leitura;
                System.out.println(" " + b);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
