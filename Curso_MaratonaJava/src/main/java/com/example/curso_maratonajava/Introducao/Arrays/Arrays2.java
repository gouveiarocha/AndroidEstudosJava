package com.example.curso_maratonajava.Introducao.Arrays;

public class Arrays2 {

    public static void main(String[] args) {

    /*Os arrays são inicializados automaticamente, sendo:
    int, double, float, byte, short, long = 0
    char = ''
    boolean = false
    reference(objetos) = null*/
        
        String[] nomes = new String[3];
        
        nomes[0] = "Goku";
        nomes[1] = "Vegeta";
        nomes[2] = "Gohan";
        
        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }

    }

}
