package com.example.curso_maratonajava.Javacore.O_Exception.CheckedExceptions.Teste;

import java.io.File;
import java.io.IOException;

public class TesteCheckedException {
    
    public static void main(String[] args) {
        
        //criarAquivo();
        
        //No caso abaixo, a exeção esta na declaração do método, por tanto precisamos executar o método dentro do try-catch.
        try{
            criarArquivo2();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        abrirArquivo();
        
    }
    
    public static void criarAquivo(){
        File file = new File("Teste.txt");
        try{
            System.out.println("Arquivos Criado: " + file.createNewFile());
            System.out.println("Arquivo criado...");
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    //Método com lançamento de excessão na declaração...
    public static void criarArquivo2() throws IOException {
        File file = new File("Teste.txt");
        try{
            System.out.println("Arquivos Criado: " + file.createNewFile());
            System.out.println("Arquivo criado...");
        }catch(IOException e){
            e.printStackTrace();
            throw e;
        }
    }
    
    //Usando bloco finally
    //O bloco finally sempre sera executado, independente se o sistema caiu no try ou no catch
    public static String abrirArquivo() {
        try{
            System.out.println("Abrindo arquivo...");
            System.out.println("Executando leitura do arquivo...");
            //throw new Exception();
            System.out.println("Escrevendo no arquivo...");
            return "retorno";
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("Fechando o arquivo...");
        }
        return null;
    }
    
}
