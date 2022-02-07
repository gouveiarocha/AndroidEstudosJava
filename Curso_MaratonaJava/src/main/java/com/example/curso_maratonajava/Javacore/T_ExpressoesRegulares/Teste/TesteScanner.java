package com.example.curso_maratonajava.Javacore.T_ExpressoesRegulares.Teste;

import java.util.Scanner;

public class TesteScanner {

    public static void main(String[] args) {
        
        //Ex1.
        Scanner scanner = new Scanner("1 true 100 01"); //O Delimitador da classe Scanner, por padrão, é o espaço.
        while(scanner.hasNext()){ //o .hasNext verifica se tem um próximo após o delimitador.
            System.out.println(scanner.next());
        } 
        System.out.println("##############################");
        
        //Ex2 - Convertendo para os tipos primitivos
        Scanner scanner2 = new Scanner("1 true 100 oi");
        while(scanner2.hasNext()){ //verificar se tem o próximo
            if(scanner2.hasNextInt()){ //...e depois usamos if para cada tipo primitivo
                int i = scanner2.nextInt();
                System.out.println(i);
            }else if(scanner2.hasNextBoolean()){
                boolean b = scanner2.nextBoolean();
                System.out.println(b);
            }else{
                System.out.println(scanner2.next());
            }
        }
    }

}
