package com.example.curso_maratonajava.Javacore.A_IntroducaoClasses.Teste;

import com.example.curso_maratonajava.Javacore.A_IntroducaoClasses.Estudante;

public class EstudanteTeste {
    
    public static void main(String[] args) {
        
        Estudante e = new Estudante();
        e.nome = "Douglas";
        e.matricula = "001";
        e.idade = 30;
        
        System.out.println(e.nome);
        System.out.println(e.matricula);
        System.out.println(e.idade);
        
    }
    
}
