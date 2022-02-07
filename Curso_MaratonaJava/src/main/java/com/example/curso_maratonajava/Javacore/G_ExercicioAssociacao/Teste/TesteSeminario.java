package com.example.curso_maratonajava.Javacore.G_ExercicioAssociacao.Teste;

import com.example.curso_maratonajava.Javacore.G_ExercicioAssociacao.Aluno;
import com.example.curso_maratonajava.Javacore.G_ExercicioAssociacao.Seminario;

public class TesteSeminario {
    
    public static void main(String[] args) {
        
        Seminario seminario = new Seminario();
        
        Aluno aluno1 = new Aluno("Douglas Gouveia", 28);
        
        aluno1.setSeminario(seminario);
        aluno1.imprimeDados();       
        
    }
    
}
