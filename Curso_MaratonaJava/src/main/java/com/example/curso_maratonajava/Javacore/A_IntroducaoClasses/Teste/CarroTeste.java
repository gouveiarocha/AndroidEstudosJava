package com.example.curso_maratonajava.Javacore.A_IntroducaoClasses.Teste;

import com.example.curso_maratonajava.Javacore.A_IntroducaoClasses.Carro;

public class CarroTeste {
    
    public static void main(String[] args) {
        
        Carro carro = new Carro();
        carro.placa = "BZI3026";
        carro.modelo = "GLS";
        carro.velocidadeMaxima = 220f;
        
        System.out.println(carro.placa);
        System.out.println(carro.modelo);
        System.out.println(carro.velocidadeMaxima);
        
    }
    
}
