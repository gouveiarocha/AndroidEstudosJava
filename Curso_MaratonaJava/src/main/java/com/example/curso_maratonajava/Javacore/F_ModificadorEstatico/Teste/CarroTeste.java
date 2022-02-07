package com.example.curso_maratonajava.Javacore.F_ModificadorEstatico.Teste;

import com.example.curso_maratonajava.Javacore.F_ModificadorEstatico.Carro;

public class CarroTeste {

    public static void main(String[] args) {
        
        Carro.setVelocidadeLimite(300);
        
        Carro c1 = new Carro("BMW", 250);
        Carro c2 = new Carro("FERRARI", 260);
        
        c1.printInfo();
        c2.printInfo();

        //c1.setVelocidadeLimite(250); //Apesar de usar o objeto c1, altera para todos os objetos.
        //Carro.velocidadeLimite = 250;  //Forma 'correta' de alterar um atributo estatico, desde que seja publico. 
        //Carro.setVelocidadeLimite(300); //Forma mais correta ainda, usando um metodo setter
        
        c1.printInfo();
        
    }
    
}
