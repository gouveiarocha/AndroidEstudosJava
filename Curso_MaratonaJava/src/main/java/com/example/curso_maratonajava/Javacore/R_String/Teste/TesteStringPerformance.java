package com.example.curso_maratonajava.Javacore.R_String.Teste;

public class TesteStringPerformance {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatString(10000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução String " + (fim-inicio) + " ms");
        
        inicio = System.currentTimeMillis();
        concatStringBuilder(100000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução StringBuilder " + (fim-inicio) + " ms");
        
        inicio = System.currentTimeMillis();
        concatStringBuffer(100000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução StringBuffer " + (fim-inicio) + " ms");
    }
    
    private static void concatString(int tam){
        String string = "";
        for(int i=0; i<tam; i++){
            string += i;
        }
    }
    
    private static void concatStringBuilder(int tam){
        StringBuilder sb = new StringBuilder(tam);
        for(int i=0; i<tam; i++){
            sb.append(i);
        }
    }
    
    private static void concatStringBuffer(int tam){
        StringBuffer sb = new StringBuffer(tam);
        for(int i=0; i<tam; i++){
            sb.append(i);
        }
    }
    
}
