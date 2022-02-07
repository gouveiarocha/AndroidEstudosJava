package com.example.curso_maratonajava.Introducao.Arrays;

public class Arrays4 {
    
    public static void main(String[] args) {
        
        //Arrays multidimensionais
        int[][] numeros = new int[2][2]; //Criamos um array m. de 2 posições, cada posição faz ref. para outro array de 2 posições.    
        
        //Para atribuir valores, precisamos informar a primeira e a segunda possição, veja abaixo como vamos atribuir valores a todas as 4 posições disponiveis:
        //Atribuindo valores para a primeira posição de arrays [0]:
        numeros[0][0] = 50;
        numeros[0][1] = 20;
        
        //Atribuindo valores para a segunda posição posição de arrays [1]:
        numeros[1][0] = 100;
        numeros[1][1] = 120;
        
        //for (int i = 0; i < numeros.length; i++) {
        //    System.out.println(numeros[0][i] + "\n" + numeros[1][i]);
        //}
        
        //Utilizando foreach
        for (int[] aux : numeros) {
            for (int num : aux) {
                System.out.println(num);
            }
        }
    }
    
}
