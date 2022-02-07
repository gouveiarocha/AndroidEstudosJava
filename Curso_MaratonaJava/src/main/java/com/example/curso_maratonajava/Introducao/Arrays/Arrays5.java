package com.example.curso_maratonajava.Introducao.Arrays;

public class Arrays5 {

    public static void main(String[] args) {
        
        //Arrays multidimensionais2.
        //Agora vamos ver como criar um array multidimensionais, mas cada posição referenciada com tamanho diferente.
        
        int[][] numeros = new int[2][]; // Cria um array multidimensional de 2 posições.
        
        numeros[0] = new int[]{1,5,9}; //Aqui, eu inicializo a primeira posição dos numeros com 3 posições(automaticamente ao atribuir os valores).
        numeros[1] = new int[5]; //Aqui, eu inicializo a segunda posição do array numeros com 5 posições(manualmente).
        
        //Imprimindo os numeros
        for (int[] aux : numeros){
            for (int nums : aux){
                System.out.println(nums);
            }
        }
        
        //Como inicializar um array multidimensial automanticamente, atribuindo valores:
        int[][] numeros2 = {{0,0},{1,2,3},{0,0,0,0}}; //Array multidimensional com 3 posições, a 1 com 2(0,0) - a segunda com 3(1,2,3) e a 3 com 4(0,0,0,0).
        
        
    }
    
}
