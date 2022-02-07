package com.example.curso_maratonajava.Javacore.B_IntroducaoMetodos.Teste;

import com.example.curso_maratonajava.Javacore.B_IntroducaoMetodos.Estudante;

public class EstudanteTeste {
    
    public static void main(String[] args) {
        
        Estudante e = new Estudante("Douglas", 30);
        e.imprimeDados();
        e.calcularMedia(5, 5, 5, 5, 10);
        
    }
    
}
