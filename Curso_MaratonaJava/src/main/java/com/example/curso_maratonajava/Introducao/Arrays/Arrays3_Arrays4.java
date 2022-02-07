package com.example.curso_maratonajava.Introducao.Arrays;

public class Arrays3_Arrays4 {

    public static void main(String[] args) {

        //Na linha abaixo, estamos inicializando um array já inicianlizando os valores, a quantidade total é definida automaticamente.
        int[] numeros = {5, 10, 12, 500}; //Temos quatro numeros, com indice 3 (0,1,2,3)
        String[] nomes = {"Douglas", "Caroline"};
        
        //Imprimindo os números...
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        
        //Imprimindo com foreach. Essa forma facilita na hora de imprimir todos os valores de um array, ela cria uma variavel local e armazena o valor a cada iteração, tudo de forma automatica.
        for (String aux : nomes) {
            System.out.println(aux);
        }

    }

}
