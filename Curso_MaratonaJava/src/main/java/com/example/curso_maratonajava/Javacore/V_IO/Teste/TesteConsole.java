package com.example.curso_maratonajava.Javacore.V_IO.Teste;

import java.io.Console;

public class TesteConsole {

    public static void main(String[] args) {
        
        Console c = System.console();
        char[] pw = c.readPassword("%s","pw: "); //Ler um pass do console.
        for(char pass : pw){
            c.format("%c", pass);
        }
        c.format("\n");
    }
    
}
